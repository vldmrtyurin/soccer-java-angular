package com.vtyurin.soccer.business.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PrePersist;

public class PlayerClubChangeListener {
    
    @PersistenceContext
    EntityManager entityManager;
    
    @PrePersist
    public void changeClub(Player player) {
        Club club = entityManager.find(Club.class, player.getClubId());
        player.setClub(club);
        Country country = entityManager.find(Country.class, player.getCountryId());
        player.setCountry(country);
    }

}
