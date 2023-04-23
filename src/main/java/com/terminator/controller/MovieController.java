package com.terminator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.terminator.model.Episode;
import com.terminator.model.Movie;
import com.terminator.service.EpisodeProxy;
import com.terminator.service.MovieProxy;

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
public class MovieController {
    
    @RestClient
    MovieProxy proxy;

    @RestClient
    EpisodeProxy episodeProxy;

    @GET
    @Fallback(fallbackMethod = "fallbackMovie")
    public Response findAll(@QueryParam("title") String title){
        Movie movie = proxy.get(title);
        List<Episode> episodes = episodeProxy.get(movie.getId());
        movie.setEpisodes(episodes);
        return Response.ok(movie).build();
    }

    private Response fallbackMovie(String title){
        return Response.ok(new ArrayList<>()).build();
    }
}
