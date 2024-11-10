package com.terminator.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

@ApplicationScoped
public class RestControllerErrorMapper {

    @Inject
    Logger logger;
    
    @ServerExceptionMapper
    public Response handleBadRequestException(IllegalArgumentException exception) {
        logger.errorv(exception.getMessage());
        return Response.status(Status.BAD_REQUEST)
                        .entity(exception.getMessage())
                        .build();
    }

    @ServerExceptionMapper
    public Response handleRestClientException(WebApplicationException exception) {
        logger.errorv(exception.getMessage());
        String message = exception.getResponse().getStatus() == 404 ? "ressource not found" : exception.getMessage();
        return Response.status(exception.getResponse().getStatus())
                        .entity(message)
                        .build();
    }
}
