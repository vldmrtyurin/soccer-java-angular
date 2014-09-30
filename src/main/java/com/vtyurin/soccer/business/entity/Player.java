package com.vtyurin.soccer.business.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@javax.persistence.Entity
@EntityListeners(PlayerClubChangeListener.class)
@Table(name = "player")
@XmlRootElement
@NamedQueries({
@NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
@NamedQuery(name = "Player.findById",
            query = "SELECT p FROM Player p WHERE p.id = :id"),
@NamedQuery(name = "Player.findByClubId",
            query = "SELECT p FROM Player p WHERE p.club = :club"),
@NamedQuery(name = "Player.findByCountry",
            query = "SELECT p FROM Player p WHERE p.country = :country")})
public class Player extends Entity implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="player_id")
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    
    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;
    
    @Transient
    private long clubId;
    
    @Transient
    private long countryId;

    @Column(name = "name")
    private String name;
    
    @Column(name = "num")
    private int num;
    
    @Column(name = "birth_date")
    private Date birthDate;

    public Player() {
    }
    
    @PrePersist
    public void init() {
        
    }
    
    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long playerId) {
        this.id = playerId;
    }
    
    @XmlTransient
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    
    @XmlTransient
    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    public long getClubId() {
        return clubId;
    }

    public void setClubId(long clubId) {
        this.clubId = clubId;
    }
    
    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }
    

}
