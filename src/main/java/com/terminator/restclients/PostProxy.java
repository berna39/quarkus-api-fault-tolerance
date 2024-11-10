package com.terminator.restclients;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/posts")
@RegisterRestClient(configKey = "post-api")
@Consumes(MediaType.APPLICATION_JSON)
public interface PostProxy {

    @GET
    Response getPosts();
}
