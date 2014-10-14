package com.vtyurin.soccer.business.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "CLUB")
@NamedQueries({
        @NamedQuery(name = "Club.findAll", query = "SELECT c FROM Club c"),
        @NamedQuery(name = "Club.findById",
                    query = "SELECT c FROM Club c WHERE c.id = :id"),
        @NamedQuery(name = "Club.findByCountry",
                    query = "SELECT c FROM Club c WHERE c.country = :country"),
        @NamedQuery(name = "Club.fetchPlayerList",
                    query = "SELECT c FROM Club c join fetch c.playerList where c.id = :id"),
        @NamedQuery(name = "Club.fetchStadiumList",
                    query = "SELECT c FROM Club c join fetch c.stadiumList where c.id = :id")
})
public class Club extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLUB_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CITY")
    private String city;

    @Column(name = "SITE")
    private String site;

    @Column(name = "LOGO")
    private String logo;

    @ManyToMany(mappedBy = "clubList")
    private List<Stadium> stadiumList;

    @ManyToMany
    @JoinTable(
            name = "CLUB_PLAYER",
            joinColumns = {@JoinColumn(name = "CLUB_ID", referencedColumnName = "CLUB_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PLAYER_ID", referencedColumnName = "PLAYER_ID")}
    )
    private List<Player> playerList;

    public Club() {

    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long clubId) {
        this.id = clubId;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Stadium> getStadiumList() {
        return stadiumList;
    }

    public void setStadiumList(List<Stadium> stadiumList) {
        this.stadiumList = stadiumList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

}
