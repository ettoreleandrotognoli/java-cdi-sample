package org.arc.service;

import org.arc.dao.DAO;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.persistence.EntityManager;

@Path("/hello")
public class HelloWorld {

    
    //@Inject
    private DAO<String> dao;

    @Inject
    public HelloWorld( DAO<String> dao) {
        this.dao = dao;
    }

    @GET
    @Path("/inject")
    public Response hello(@PathParam("message") String message) {
		return Response.status(200).entity("Intance : "+dao).build();
    }

}