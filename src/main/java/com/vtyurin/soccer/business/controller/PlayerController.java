package com.vtyurin.soccer.business.controller;

import com.vtyurin.soccer.business.entity.Player;
import com.vtyurin.soccer.business.service.PlayerService;

import java.util.Collection;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path(Link.PLAYERS)
public class PlayerController extends BasicController {

    @Inject
    PlayerService playerService;
    
    @GET
    @Produces(JSON_UTF8)
    public CollectionResource playerList(@Context UriInfo info) {
        Collection<Player> players = playerService.getPlayers();
        Collection items = getPlayerResourceCollection(info, players);
        
        return new CollectionResource(info, items, Link.PLAYERS);
    }
    
    @POST
    @Consumes(JSON_UTF8)
    public Response create(Player player) {
        playerService.save(player);
        return Response.ok(player).build();
    }
    
    @Path("/{id}")
    @GET
    @Produces(JSON_UTF8)
    public PlayerResource getPlayerById(@Context UriInfo info, @PathParam("id") long id) {
        Player player = playerService.getById(id);
        return new PlayerResource(info, player);
    }

    @Path("/{id}")
    @DELETE
    public void deletePlayer(@PathParam("id") long id) {
        Player player = playerService.getById(id);
        playerService.delete(player);
    }

}
