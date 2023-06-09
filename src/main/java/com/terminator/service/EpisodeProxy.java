package com.terminator.service;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import com.terminator.model.Episode;

@Path("showsz")
@RegisterRestClient(baseUri = "https://api.tvmaze.com/")
@Produces(MediaType.APPLICATION_JSON)
public interface EpisodeProxy {
    @GET
    @Path("{id}/episodes")
    List<Episode> get(@PathParam("id") Long id);
}
