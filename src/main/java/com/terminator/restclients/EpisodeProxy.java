package com.terminator.restclients;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.terminator.models.Episode;

@Path("/shows")
@RegisterRestClient(configKey = "movie-api")
@Consumes(MediaType.APPLICATION_JSON)
public interface EpisodeProxy {

    @GET
    @Path("/{id}/episodes")
    List<Episode> get(@PathParam("id") Long id);
}
