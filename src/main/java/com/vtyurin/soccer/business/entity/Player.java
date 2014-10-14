package com.vtyurin.soccer.business.entity;

import com.vtyurin.soccer.business.entity.listener.AgeCalculationListener;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;

@javax.persistence.Entity
@EntityListeners(AgeCalculationListener.class)
@Table(name = "PLAYER")
@NamedQueries({
@NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
@NamedQuery(name = "Player.findById",
            query = "SELECT p FROM Player p WHERE p.id = :id"),
@NamedQuery(name = "Player.findByCountry",
            query = "SELECT p FROM Player p WHERE p.country = :country")})
public class Player extends AbstractEntity implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="PLAYER_ID")
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    @Column(name = "NAME")
    private String name;
    
    @Column(name = "SQUAD_NUMBER")
    private int squadNumber;
    
    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "POSITION_ID")
    private Position position;

    @ManyToMany(mappedBy = "playerList")
    private List<Club> clubList;

    @Transient
    private Integer age;

    public Player() {
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long playerId) {
        this.id = playerId;
    }
    
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

    public int getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(int num) {
        this.squadNumber = num;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Club> getClubList() {
        return clubList;
    }

    public void setClubList(List<Club> clubList) {
        this.clubList = clubList;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
