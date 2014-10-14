package com.vtyurin.soccer.business.resource;

import com.vtyurin.soccer.business.entity.Country;
import javax.ws.rs.core.UriInfo;

public class CountryResource extends Link {
    
    public CountryResource(UriInfo info, Country country) {
        super(info, Link.COUNTRIES, country);
        put("id", country.getId());
        put("name", country.getName());
//        put("clubs", new Link(info, info.getPath() + CLUBS));
//        put("players", new Link(info, info.getPath() + PLAYERS));
    }
}
