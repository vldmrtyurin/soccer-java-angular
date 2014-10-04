package com.vtyurin.soccer.business.service;

import com.vtyurin.soccer.business.entity.Club;
import com.vtyurin.soccer.business.entity.Country;
import com.vtyurin.soccer.business.entity.Player;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Stateless
public class DefaultClubService implements ClubService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Club getById(long id) {
        return entityManager.find(Club.class, id);
    }

    @Override
    public Club save(Club club) {
        return null;
    }

    @Override
    public Club deleteById(long id) {
        return null;
    }

    @Override
    public Country getCountry(long id) {
        Club club = entityManager.find(Club.class, id);
        return club.getCountry();
    }

    @Override
    public Collection<Club> getClubs() {
        return entityManager.createNamedQuery("Club.findAll").getResultList();
    }

    @Override
    public Collection<Player> getPlayers() {
        return null;
    }
}
