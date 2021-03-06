package com.vtyurin.soccer.business.service;

import com.vtyurin.soccer.business.entity.Club;
import com.vtyurin.soccer.business.entity.Player;

import javax.json.JsonObject;
import java.util.Collection;

public interface PlayerService {

    Player getById(long id);
    Collection<Player> getAll();
    Club getClub();
    void save(JsonObject json);
    void deleteById(long id);

}
