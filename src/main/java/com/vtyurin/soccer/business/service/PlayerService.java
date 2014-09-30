package com.vtyurin.soccer.business.service;

import com.vtyurin.soccer.business.entity.Club;
import com.vtyurin.soccer.business.entity.Player;
import java.util.Collection;

public interface PlayerService {
    
    Collection<Player> getPlayers();
    
    Player getById(long id);
    
    void save(Player player);
    
    Player deleteById(long id);
    
    Club getClub();

}
