package com.vtyurin.soccer.business.resource;

import com.vtyurin.soccer.business.entity.Club;
import javax.ws.rs.core.UriInfo;

public class ClubResource extends Link {
    
    public ClubResource(UriInfo info, Club club) {
        super(info, Link.CLUBS, club);
        put("id", club.getId());
        put("name", club.getName());
        put("city", club.getCity());
        put("country", new CountryResource(info, club.getCountry()));
        put("site", club.getSite());
        put("logo", club.getLogo());
        put("stadium", new Link(info, STADIUMS));
    }

}
