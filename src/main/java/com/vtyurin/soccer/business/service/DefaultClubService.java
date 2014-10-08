package com.vtyurin.soccer.business.service;

import com.vtyurin.soccer.business.entity.Club;
import com.vtyurin.soccer.business.entity.Country;
import com.vtyurin.soccer.business.entity.Player;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

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
    public List<Club> getClubs() {
        return entityManager.createNamedQuery("Club.findAll").getResultList();
    }

    @Override
    public List<Player> getPlayers(Club club) {
        return entityManager.createNamedQuery("Player.findByClubId")
                .setParameter("club", club).getResultList();
    }
}
