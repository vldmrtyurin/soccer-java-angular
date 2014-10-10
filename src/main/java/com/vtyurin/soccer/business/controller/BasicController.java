package com.vtyurin.soccer.business.controller;

import com.vtyurin.soccer.business.entity.Club;
import com.vtyurin.soccer.business.entity.Country;
import com.vtyurin.soccer.business.entity.Player;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.Collection;

public class BasicController {

    public static final String JSON_UTF8 = MediaType.APPLICATION_JSON + "; " +
            MediaType.CHARSET_PARAMETER + "=UTF-8";

    public Collection<Player> getPlayerResourceCollection(UriInfo info, Collection<Player> players) {
        Collection items = new ArrayList(players.size());
        for (Player player: players) {
            items.add(new PlayerResource(info, player));
        }
        return items;
    }

    public Collection<Club> getClubResourceCollection(UriInfo info, Collection<Club> clubs) {
        Collection items = new ArrayList(clubs.size());
        for (Club club: clubs) {
            items.add(new ClubResource(info, club));
        }
        return items;
    }

    public Collection<Country> getCountryResourceCollection(UriInfo info, Collection<Country> countries) {
        Collection items = new ArrayList(countries.size());
        for (Country country: countries) {
            items.add(new CountryResource(info, country));
        }
        return items;
    }

}
