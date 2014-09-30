package com.vtyurin.soccer.business.entity;

public abstract class Entity {

    private long id;

    public Entity(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
