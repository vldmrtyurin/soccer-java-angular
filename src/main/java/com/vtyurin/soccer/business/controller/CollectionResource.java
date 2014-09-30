package com.vtyurin.soccer.business.controller;

import java.util.Collection;
import javax.ws.rs.core.UriInfo;

public class CollectionResource extends Link {
    
    public CollectionResource(UriInfo info, Collection items, String collectionName) {
        super(info, collectionName);
        put("items", items);
    }
}
