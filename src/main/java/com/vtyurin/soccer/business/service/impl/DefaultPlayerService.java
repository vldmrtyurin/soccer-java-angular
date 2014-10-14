package com.vtyurin.soccer.business.service.impl;

import com.vtyurin.soccer.business.entity.Club;
import com.vtyurin.soccer.business.entity.Country;
import com.vtyurin.soccer.business.entity.Player;
import com.vtyurin.soccer.business.entity.Position;
import com.vtyurin.soccer.business.service.PlayerService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DefaultPlayerService implements PlayerService {
    
    @PersistenceContext
    EntityManager em;
    

    @Override
    public Collection<Player> getAll() {
        return em.createNamedQuery("Player.findAll").getResultList();
    }

    @Override
    public Player getById(long id) {
        return em.find(Player.class, id);
    }

    @Override
    public void save(JsonObject json) {
        Player player = new Player();
        player.setName(json.getString("name"));
        player.setSquadNumber(json.getInt("squadNumber"));
        player.setBirthDate(Date.valueOf(json.getString("birthDate")));
        player.setPosition(em.find(Position.class, (long) json.getJsonObject("position").getInt("id")));
        player.setCountry(em.find(Country.class, (long) json.getJsonObject("country").getInt("id")));
        List<Club> clubList = new ArrayList<>();
        Club club = em.find(Club.class, (long) json.getJsonObject("club").getInt("id"));
        clubList.add(club);
        player.setClubList(clubList);
        club.getPlayerList().add(player);
        em.persist(player);
    }

    @Override
    public Club getClub() {
        return null;
    }

    @Override
    public void deleteById(long id) {
        Player player = em.find(Player.class, id);
        em.remove(em.merge(player));
    }

}
