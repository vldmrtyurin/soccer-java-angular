package com.vtyurin.soccer.business.service.impl;

import com.vtyurin.soccer.business.entity.Club;
import com.vtyurin.soccer.business.entity.Country;
import com.vtyurin.soccer.business.entity.Player;
import com.vtyurin.soccer.business.entity.Stadium;
import com.vtyurin.soccer.business.service.ClubService;

import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Stateless
public class DefaultClubService implements ClubService {

    @PersistenceContext
    EntityManager em;

    @Override
    public Club getById(long id) {
        return em.find(Club.class, id);
    }

    @Override
    public Country getCountryById(long id) {
        Club club = em.find(Club.class, id);
        return club.getCountry();
    }

    @Override
    public List<Club> getAll() {
        return em.createNamedQuery("Club.findAll").getResultList();
    }

    @Override
    public void save(JsonObject json) {
        Club club = new Club();
        Country country = em.find(Country.class, (long) json.getJsonObject("country").getInt("id"));
        Stadium stadium = em.find(Stadium.class, (long) json.getJsonObject("stadium").getInt("id"));
        List<Stadium> stadiumList = new ArrayList<>();
        stadiumList.add(stadium);

        club.setName(json.getString("name"));
        club.setCity(json.getString("city"));
        club.setSite(json.getString("site"));
        club.setLogo(json.getString("logo"));
        club.setStadiumList(stadiumList);
        club.setCountry(country);
        stadium.getClubList().add(club);
        em.persist(club);
    }

    // think !!!!
    @Override
    public void addPlayer(long id, Player player) {
        Club club = em.find(Club.class, id);
        club.getPlayerList().add(player);
    }

    @Override
    public void deleteById(long id) {
        Club club = em.find(Club.class, id);
        em.remove(em.merge(club));
    }

    @Override
    public Collection<Player> getPlayersById(long id) {
        Query query = em.createNamedQuery("Club.fetchPlayerList");
        Club club = (Club) query.setParameter("id", id).getSingleResult();
        return club.getPlayerList();
    }

    @Override
    public Collection<Stadium> getStadiumsById(long id) {
        Query query = em.createNamedQuery("Club.fetchStadiumList");
        Club club = (Club) query.setParameter("id", id).getSingleResult();
        return club.getStadiumList();
    }
}
