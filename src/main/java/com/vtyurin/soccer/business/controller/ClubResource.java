package com.vtyurin.soccer.business.controller;

import com.vtyurin.soccer.business.entity.Club;
import javax.ws.rs.core.UriInfo;

public class ClubResource extends Link {
    
    public ClubResource(UriInfo info, Club club) {
        super(info, Link.CLUBS, club);
        put("name", club.getName());
    }

}
