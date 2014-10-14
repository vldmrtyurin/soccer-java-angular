package com.vtyurin.soccer.business.controller;

import com.vtyurin.soccer.business.entity.Club;
import com.vtyurin.soccer.business.entity.Player;
import com.vtyurin.soccer.business.entity.Stadium;
import com.vtyurin.soccer.business.resource.ClubResource;
import com.vtyurin.soccer.business.resource.CollectionResource;
import com.vtyurin.soccer.business.resource.Link;
import com.vtyurin.soccer.business.service.ClubService;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Collection;

@Path(Link.CLUBS)
public class ClubController extends BasicController {

    @Inject
    ClubService clubService;

    @GET
    @Produces(JSON_UTF8)
    public CollectionResource clubList(@Context UriInfo info) {
        Collection<Club> clubs = clubService.getAll();
        Collection items = getClubResourceCollection(info, clubs);
        return new CollectionResource(info, items, Link.CLUBS);
    }

    @POST
    @Consumes(JSON_UTF8)
    public Response save(JsonObject json) {
        clubService.save(json);
        return Response.ok(json).build();
    }

    @GET
    @Path("/{id}")
    @Produces(JSON_UTF8)
    public ClubResource getClubById(@Context UriInfo info,
                                    @PathParam("id") long id) {
        Club club = clubService.getById(id);
        return new ClubResource(info, club);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") long id) {
        clubService.deleteById(id);
    }

    @Path("/{id}/players")
    @GET
    @Produces(JSON_UTF8)
    public CollectionResource getPlayers(@Context UriInfo info,
                                         @PathParam("id") long id) {
        Collection<Player> players = clubService.getPlayersById(id);
        Collection items = getPlayerResourceCollection(info, players);
        return new CollectionResource(info, items, info.getPath());
    }

    @Path("/{id}/stadiums")
    @GET
    @Produces(JSON_UTF8)
    public CollectionResource getStadiums(@Context UriInfo info,
                                          @PathParam("id") long id) {
        Collection<Stadium> stadiums = clubService.getStadiumsById(id);
        Collection items = getStadiumResourceCollection(info, stadiums);
        return new CollectionResource(info, items, Link.STADIUMS);
    }
}