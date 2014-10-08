package com.vtyurin.soccer.business.service;

import com.vtyurin.soccer.business.entity.Club;
import com.vtyurin.soccer.business.entity.Country;
import com.vtyurin.soccer.business.entity.Player;
import java.util.Collection;
import java.util.List;

public interface CountryService {
    
    Collection<Country> getCountries();
    
    Country getById(long id);
    
    Country save(Country country);
    
    Country deleteById(long id);
    
    List<Player> getPlayers(Country country);

    List getClubs(Country country);

}
