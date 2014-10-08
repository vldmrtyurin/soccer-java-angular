package com.vtyurin.soccer.business.controller;

import com.vtyurin.soccer.business.entity.Club;
import com.vtyurin.soccer.business.entity.Player;
import com.vtyurin.soccer.business.service.ClubService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.Collection;

@Path(Link.CLUBS)
public class ClubController extends BasicController {

    @Inject
    ClubService clubService;

    @GET
    @Produces(JSON_UTF8)
    public CollectionResource clubList(@Context UriInfo info) {
        Collection<Club> clubs = clubService.getClubs();
        Collection items = new ArrayList(clubs.size());

        for (Club club : clubs) {
            items.add(new ClubResource(info, club));
        }

        return new CollectionResource(info, items, Link.CLUBS);
    }

    @GET
    @Path("/{id}")
    @Produces(JSON_UTF8)
    public ClubResource getClubById(@Context UriInfo info, @PathParam("id") long id) {
        Club club = clubService.getById(id);
        return new ClubResource(info, club);
    }

    @Path("/{id}/players")
    @GET
    @Produces(JSON_UTF8)
    public CollectionResource getPlayers(@Context UriInfo info, @PathParam("id") long id) {
        Club club = clubService.getById(id);
        Collection<Player> players = clubService.getPlayers(club);
        Collection items = new ArrayList(players.size());
        for (Player player : players) {
            items.add(new PlayerResource(info, player));
        }

        return new CollectionResource(info, items, info.getPath());
    }
}
