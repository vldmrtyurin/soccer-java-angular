package com.vtyurin.soccer.business.controller;

import com.vtyurin.soccer.business.entity.Player;
import javax.ws.rs.core.UriInfo;

public class PlayerResource extends Link {
    
    public PlayerResource(UriInfo info, Player player) {
        super(info, Link.PLAYERS, player);
        put("id", player.getId());
        put("name", player.getName());
        put("num", player.getNum());
        put("birthDate", player.getBirthDate());
        put("country", new CountryResource(info, player.getCountry()));
        put("club", new ClubResource(info, player.getClub()));
    }

}
