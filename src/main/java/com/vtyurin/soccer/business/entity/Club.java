package com.vtyurin.soccer.business.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@javax.persistence.Entity
@Table(name = "club")
@XmlRootElement
@NamedQueries({
@NamedQuery(name = "Club.findAll", query = "SELECT c FROM Club c"),
@NamedQuery(name = "Club.findById",
            query = "SELECT c FROM Club c WHERE c.id = :id"),
@NamedQuery(name = "Club.findByCountry",
            query = "SELECT c FROM Club c WHERE c.country = :country")})
public class Club extends Entity implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="club_id")
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "city")
    private String city;
        
    @OneToMany(mappedBy = "club")
    private List<Player> playerList;
    
    public Club() {
        
    }
    
    @XmlTransient
    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long clubId) {
        this.id = clubId;
    }
    
    @XmlTransient
    public Country getCountry() {
        return country;
    }

    public void setCountryId(Country country) {
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
    
    @XmlTransient
    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

}
