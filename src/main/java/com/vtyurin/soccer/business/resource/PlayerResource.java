package com.vtyurin.soccer.business.resource;

import com.vtyurin.soccer.business.entity.Player;
import javax.ws.rs.core.UriInfo;

public class PlayerResource extends Link {
    
    public PlayerResource(UriInfo info, Player player) {
        super(info, PLAYERS, player);
        put("id", player.getId());
        put("name", player.getName());
        put("num", player.getSquadNumber());
        put("birthDate", player.getBirthDate());
        put("age", player.getAge());
        put("country", new CountryResource(info, player.getCountry()));
    }

}
