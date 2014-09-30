package com.vtyurin.soccer.business.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@javax.persistence.Entity
@Table(name = "country")
@XmlRootElement
@NamedQueries({
@NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c"),
@NamedQuery(name = "Country.findById",
            query = "SELECT c FROM Country c WHERE c.id = :idd")})
public class Country extends Entity implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private long id;
    
    @Column(name = "name")
    private String name;
    
//    @OneToMany(mappedBy = "country")
//    private List<Club> clubsList;
//    
//    @OneToMany(mappedBy = "country")
//    private List<Player> playersList;

    public Country() {
    }
    
    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
//    @XmlTransient
//    public List<Club> getClubsList() {
//        return clubsList;
//    }
//
//    public void setClubsList(List<Club> clubsList) {
//        this.clubsList = clubsList;
//    }
//    
//    @XmlTransient
//    public List<Player> getPlayersList() {
//        return playersList;
//    }
//
//    public void setPlayersList(List<Player> playersList) {
//        this.playersList = playersList;
//    }
    
    
}
