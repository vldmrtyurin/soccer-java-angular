package com.vtyurin.soccer.business.service;

import com.vtyurin.soccer.business.entity.Club;
import com.vtyurin.soccer.business.entity.Country;
import com.vtyurin.soccer.business.entity.Player;

import java.util.Collection;

public interface ClubService {

    Club getById(long id);
    Club save(Club club);
    Club deleteById(long id);
    Country getCountry(long id);
    Collection<Club> getClubs();
    Collection<Player> getPlayers();
}
