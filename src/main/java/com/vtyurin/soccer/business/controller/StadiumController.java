package com.vtyurin.soccer.business.controller;

import com.vtyurin.soccer.business.entity.Club;
import com.vtyurin.soccer.business.entity.Stadium;
import com.vtyurin.soccer.business.resource.CollectionResource;
import com.vtyurin.soccer.business.resource.Link;
import com.vtyurin.soccer.business.service.StadiumService;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Collection;

@Path(Link.STADIUMS)
public class StadiumController extends BasicController {

    @Inject
    StadiumService stadiumService;

    @GET
    @Produces(JSON_UTF8)
    public CollectionResource stadiumList(@Context UriInfo info) {
        Collection stadiums = stadiumService.getAll();
        Collection items = getStadiumResourceCollection(info, stadiums);
        return new CollectionResource(info, items, Link.STADIUMS);
    }

    @POST
    @Consumes(JSON_UTF8)
    public Response save(JsonObject json) {
        stadiumService.save(json);
        return Response.ok(json).build();
    }


    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") long id) {
        stadiumService.deleteById(id);
    }

    @GET
    @Path("/{id}/clubs")
    @Produces(JSON_UTF8)
    public CollectionResource clubList(@Context UriInfo info, @PathParam("id") long id) {
        // work here
        Collection<Club> clubs = stadiumService.getClubsById(id);
        clubs = getClubResourceCollection(info, clubs);
        return new CollectionResource(info, clubs, info.getPath());
    }

}
