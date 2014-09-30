package com.vtyurin.soccer.business.controller;

import com.vtyurin.soccer.business.entity.Player;
import javax.ws.rs.core.UriInfo;

public class PlayerResource extends Link {
    
    public PlayerResource(UriInfo info, Player player) {
        super(info, Link.PLAYERS, player);
        put("name", player.getName());
        put("birhtDate", player.getBirthDate());
        put("country", new Link(info, Link.COUNTRIES, player.getCountry()));
        put("club", new Link(info, Link.CLUBS, player.getClub()));
    }

}
