package com.terminator.restclients;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.terminator.models.Movie;

@Path("/singlesearch")
@RegisterRestClient(configKey = "movie-api")
@Consumes(MediaType.APPLICATION_JSON)
public interface MovieProxy {
    
    @GET
    @Path("/shows")
    Movie get(@QueryParam("q") String title);
}
