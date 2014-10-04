package com.vtyurin.soccer.business.controller;

import com.vtyurin.soccer.business.entity.Club;
import com.vtyurin.soccer.business.entity.Country;
import com.vtyurin.soccer.business.service.ClubService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.Collection;

@Path(Link.CLUBS)
public class ClubController {

    @Inject
    ClubService clubService;

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; " +
            MediaType.CHARSET_PARAMETER + "=UTF-8")
    public CollectionResource getClubs(@Context UriInfo info) {
        Collection<Club> clubs = clubService.getClubs();
        Collection items = new ArrayList(clubs.size());

        for (Club club : clubs) {
            items.add(new ClubResource(info, club));
        }

        return new CollectionResource(info, items, Link.CLUBS);
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + "; " +
            MediaType.CHARSET_PARAMETER + "=UTF-8")
    public ClubResource getClubById(@Context UriInfo info, @PathParam("id") long id) {
        Club club = clubService.getById(id);
        return new ClubResource(info, club);
    }
}
