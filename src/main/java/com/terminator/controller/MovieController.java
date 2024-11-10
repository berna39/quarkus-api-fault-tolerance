package com.terminator.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import com.terminator.models.Episode;
import com.terminator.models.Movie;
import com.terminator.restclients.EpisodeProxy;
import com.terminator.restclients.MovieProxy;

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
public class MovieController {
    
    @RestClient
    MovieProxy movieProxy;

    @RestClient
    EpisodeProxy episodeProxy;

    @Inject
    Logger logger;

    @GET
    @Fallback(fallbackMethod = "fallbackMovieRequest", skipOn = {IllegalArgumentException.class, WebApplicationException.class})
    public Response findAll(@QueryParam("title") String title) {
        if(title == null)
            throw new IllegalArgumentException("Bad request, please check your input query");

        logger.infov("incoming movie request {0}", title);
        Movie movie = movieProxy.get(title);
        List<Episode> episodes = episodeProxy.get(movie.getId());
        movie.setEpisodes(episodes);

        return Response.ok(movie)
                        .build();
    }

    private Response fallbackMovieRequest(String title) {
        logger.infov("executing fallback request request from title: {0}", title);
        return Response.ok(new ArrayList<>())
                        .build();
    }
}
