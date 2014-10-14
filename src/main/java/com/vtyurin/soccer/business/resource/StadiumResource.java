package com.vtyurin.soccer.business.resource;

import com.vtyurin.soccer.business.entity.Stadium;

import javax.ws.rs.core.UriInfo;

public class StadiumResource extends Link {

    public StadiumResource(UriInfo info, Stadium stadium) {
        super(info, STADIUMS, stadium);
        put("id", stadium.getId());
        put("name", stadium.getName());
        put("city", stadium.getCity());
        put("country", new CountryResource(info, stadium.getCountry()));
        put("clubs", new Link(info, CLUBS));
    }
}
