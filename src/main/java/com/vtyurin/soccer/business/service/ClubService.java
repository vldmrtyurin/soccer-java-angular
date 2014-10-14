package com.vtyurin.soccer.business.service;

import com.vtyurin.soccer.business.entity.Club;
import com.vtyurin.soccer.business.entity.Country;
import com.vtyurin.soccer.business.entity.Player;
import com.vtyurin.soccer.business.entity.Stadium;
import com.vtyurin.soccer.business.resource.ClubResource;

import javax.json.JsonObject;
import java.util.Collection;

public interface ClubService {

    Club getById(long id);
    Collection<Club> getAll();
    Country getCountryById(long id);
    Collection<Player> getPlayersById(long id);
    Collection<Stadium> getStadiumsById(long id);
    void save(JsonObject club);
    void deleteById(long id);
    void addPlayer(long id, Player player);
}
