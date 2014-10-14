package com.vtyurin.soccer.business.service;


import com.vtyurin.soccer.business.entity.Club;
import com.vtyurin.soccer.business.entity.Stadium;

import javax.json.JsonObject;
import java.util.Collection;
import java.util.List;

public interface StadiumService {

    Stadium getById(long id);
    Collection<Stadium> getAll();
    Collection<Club> getClubsById(long id);
    void save(JsonObject json);
    void deleteById(long id);

}
