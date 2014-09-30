package com.vtyurin.soccer.business.controller;

import com.vtyurin.soccer.business.entity.Player;
import com.vtyurin.soccer.business.service.PlayerService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path(Link.PLAYERS)
public class PlayerController {
    
    @Inject
    PlayerService playerService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON + "; " +
              MediaType.CHARSET_PARAMETER + "=UTF-8")
    public CollectionResource playerList(@Context UriInfo info) {
        Collection<Player> players = playerService.getPlayers();
        Collection items = new ArrayList(players.size());
        
        for (Player player : players) {
            items.add(new PlayerResource(info, player));
        }
        
        return new CollectionResource(info, items, Link.PLAYERS);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON + "; " +
              MediaType.CHARSET_PARAMETER + "=UTF-8")
    public Response create(Player player) {
        playerService.save(player);
        return Response.ok(player).build();
    }
    
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON + "; " +
              MediaType.CHARSET_PARAMETER + "=UTF-8")
    public PlayerResource getPlayer(@Context UriInfo info, @PathParam("id") long id) {
        Player player = playerService.getById(id);
        return new PlayerResource(info, player);
    }
    
    @Path("/test/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON + "; " +
              MediaType.CHARSET_PARAMETER + "=UTF-8")
    public Player getTestPlayer(@Context UriInfo info, @PathParam("id") long id) {
        Player player = playerService.getById(id);
        return player;
    }

}