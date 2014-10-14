package com.vtyurin.soccer.business.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "COUNTRY")
@NamedQueries({
@NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c"),
@NamedQuery(name = "Country.findById",
            query = "SELECT c FROM Country c WHERE c.id = :id")})
public class Country extends AbstractEntity implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUNTRY_ID")
    private long id;

    @Column(name = "CODE")
    private String code;
    
    @Column(name = "NAME")
    private String name;

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

}
