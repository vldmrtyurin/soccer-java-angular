package com.vtyurin.soccer.business.service;

import com.vtyurin.soccer.business.entity.Club;
import com.vtyurin.soccer.business.entity.Country;
import com.vtyurin.soccer.business.entity.Player;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DefaultCountryService implements CountryService {
    
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Collection<Country> getCountries() {
        return entityManager.createNamedQuery("Country.findAll").getResultList();
    }

    @Override
    public Country getById(long id) {
        return entityManager.find(Country.class, id);
    }

    @Override
    public Country save(Country country) {
        return null;
    }

    @Override
    public Country deleteById(long id) {
        return null;
    }

    @Override
    public List<Player> getPlayers(Country country) {
        return entityManager.createNamedQuery("Player.findByCountry").setParameter("country", country).getResultList();
    }

    @Override
    public List<Club> getClubs(Country country) {
        return entityManager.createNamedQuery("Club.findByCountry").setParameter("country", country).getResultList();
    }

}
