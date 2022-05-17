package dev.marconymous.bookshelf.service;

import dev.marconymous.bookshelf.data.DataHandler;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/book")
public class BookService {
  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getBookList() {
    var data = DataHandler.getInstance().readAllBooks();
    return Response.ok().entity(data).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getSingleBook(@QueryParam("uuid") String uuid) {
    var data = DataHandler.getInstance().readBookByUUID(uuid);

    var regex = Config.getProperty("uuid.regexp");
    if (!uuid.matches(regex)) {
      throw new IllegalArgumentException("Invalid UUID format");
    }

    if (data == null) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }

    return Response.ok().entity(data).build();
  }
}
