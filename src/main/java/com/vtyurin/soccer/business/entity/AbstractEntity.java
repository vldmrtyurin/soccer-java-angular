package com.vtyurin.soccer.business.entity;

public abstract class AbstractEntity {

    private long id;

    public AbstractEntity(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
