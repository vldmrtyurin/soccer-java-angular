package com.vtyurin.soccer.business.resource;

import com.vtyurin.soccer.business.entity.AbstractEntity;

import java.util.Collection;
import java.util.LinkedHashMap;
import javax.ws.rs.core.UriInfo;

public class Link extends LinkedHashMap {
    
    public static final String PATH_SEPARATOR = "/";
    
    public static final String PLAYERS = PATH_SEPARATOR + "players";
    public static final String COUNTRIES = PATH_SEPARATOR + "countries";
    public static final String STADIUMS = PATH_SEPARATOR + "stadiums";
    public static final String CLUBS = PATH_SEPARATOR + "clubs";
    
    public Link() {
        
    }

    public Link(UriInfo info, String collectionName, AbstractEntity entity) {
        StringBuilder sb = new StringBuilder(getContextPath(info));
        sb.append(collectionName)
            .append(PATH_SEPARATOR)
            .append(entity.getId());
        put("href", sb);
    }
    
    public Link(UriInfo info, String collectionName) {
        StringBuilder sb = new StringBuilder(getContextPath(info));
        sb.append(collectionName);
        put("href", sb);
    }
    
    public Link(UriInfo info, AbstractEntity entity) {
        
    }
    
    public Link(UriInfo info, Collection items) {
        
    }
    
    private String getContextPath(UriInfo info) {
        String path = info.getBaseUri().toString();
        if (path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }
        return path;
    }
    
}
