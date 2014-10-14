package com.vtyurin.soccer.business.service.impl;

import com.vtyurin.soccer.business.entity.Club;
import com.vtyurin.soccer.business.entity.Country;
import com.vtyurin.soccer.business.entity.Stadium;
import com.vtyurin.soccer.business.service.StadiumService;

import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

@Stateless
public class DefaultStadiumService implements StadiumService {

    @PersistenceContext
    EntityManager em;

    @Override
    public Collection<Stadium> getAll() {
        return em.createNamedQuery("Stadiums.findAll").getResultList();
    }

    @Override
    public Stadium getById(long id) {
        return em.find(Stadium.class, id);
    }

    @Override
    public void save(JsonObject newClub) {
        Stadium stadium = new Stadium();
        stadium.setName(newClub.getString("name"));
        stadium.setCity(newClub.getString("city"));
        long countryId = newClub.getJsonObject("country").getInt("id");
        Country country = em.find(Country.class, countryId);
        stadium.setCountry(country);
        em.persist(stadium);
    }

    @Override
    public Collection<Club> getClubsById(long id) {
        Query query = em.createNamedQuery("Stadiums.fetchClubList");
        Stadium stadium = (Stadium) query.setParameter("id", id).getSingleResult();
        return stadium.getClubList();
    }

    @Override
    public void deleteById(long id) {
        Stadium stadium = em.find(Stadium.class, id);
        em.remove(em.merge(stadium));
    }
}
