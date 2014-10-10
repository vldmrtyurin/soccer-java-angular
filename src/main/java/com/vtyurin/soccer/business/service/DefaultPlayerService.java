package com.vtyurin.soccer.business.service;

import com.vtyurin.soccer.business.entity.Club;
import com.vtyurin.soccer.business.entity.Player;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DefaultPlayerService implements PlayerService {
    
    @PersistenceContext
    EntityManager entityManager;
    

    @Override
    public Collection<Player> getPlayers() {
        return entityManager.createNamedQuery("Player.findAll").getResultList();
    }

    @Override
    public Player getById(long id) {
        return entityManager.find(Player.class, id);
    }

    @Override
    public void save(Player player) {
        entityManager.persist(player);
    }

    @Override
    public void delete(Player player) {
        entityManager.remove(entityManager.merge(player));
    }

    @Override
    public Club getClub() {
        return null;
    }

}
