package dev.marconymous.bookshelf.service;

import dev.marconymous.bookshelf.data.DataHandler;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

import javax.xml.crypto.Data;

@Path("/publisher")
public class PublisherService {
  @GET
  @Path("/all")
  public Response getPublisherList() {
    return Response.ok().entity(DataHandler.getInstance().readAllPublishers()).build();
  }

  @GET
  public Response getPublisher(@QueryParam("uuid") String uuid) {
    var data = DataHandler.getInstance().readPublisherByUUID(uuid);

    var regex = Config.getProperty("uuid.regexp");
    if (!uuid.matches(regex)) {
      throw new IllegalArgumentException("UUID is not valid");
    }

    if (data == null) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }

    return Response.ok().entity(data).build();
  }
}
