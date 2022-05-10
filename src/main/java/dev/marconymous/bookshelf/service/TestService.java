package dev.marconymous.bookshelf.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;

/**
 * test service
 */
@Path("test")
public class TestService {

  @GET
  @Path("test")
  @Produces(TEXT_PLAIN)
  public Response test() {
    return Response
      .status(200)
      .entity("Test erfolgreich")
      .build();
  }
}