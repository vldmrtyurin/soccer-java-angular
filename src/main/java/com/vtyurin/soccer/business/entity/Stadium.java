package com.vtyurin.soccer.business.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@javax.persistence.Entity
@Table(name = "stadium")
@NamedQueries({
        @NamedQuery(name = "Stadiums.findAll", query = "SELECT s FROM Stadium s"),
        @NamedQuery(name = "Stadiums.fetchClubList", query = "SELECT s FROM Stadium s join fetch s.clubList where s.id = :id"),
})
public class Stadium extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stadium_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToMany
    @JoinTable(
            name = "stadium_club",
            joinColumns = {@JoinColumn(name = "stadium_id", referencedColumnName = "stadium_id")},
            inverseJoinColumns = {@JoinColumn(name ="club_id", referencedColumnName = "club_id")})
    private List<Club> clubList;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    public Stadium() {

    }

    public Stadium(String name, String city, Country country) {

    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @XmlTransient
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Club> getClubList() {
        return clubList;
    }

    public void setClubList(List<Club> clubList) {
        this.clubList = clubList;
    }

}
