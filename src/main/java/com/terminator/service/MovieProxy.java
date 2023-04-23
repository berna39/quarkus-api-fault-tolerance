package com.terminator.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import com.terminator.model.Movie;

@Path("/singlesearch/")
@RegisterRestClient(baseUri = "https://api.tvmaze.com/")
@Produces(MediaType.APPLICATION_JSON)
public interface MovieProxy {
    
    @GET
    @Path("/shows")
    Movie get(@QueryParam("q") String title);
}
