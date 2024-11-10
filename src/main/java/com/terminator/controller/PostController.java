package com.terminator.controller;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import com.terminator.restclients.PostProxy;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
public class PostController {

    @RestClient
    PostProxy postProxy;

    @Inject
    Logger logger;

    @GET
    public Response getPosts() {
        Response response = postProxy.getPosts();
        logger.info(response.getHeaders());

        return Response.ok().build();
    }
    
}
