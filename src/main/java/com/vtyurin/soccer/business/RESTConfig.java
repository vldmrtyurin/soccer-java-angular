package com.vtyurin.soccer.business;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("resources")
public class RESTConfig extends Application {
    
//    public RESTConfig() {
//        register(new AbstractBinder() {
//
//            @Override
//            protected void configure() {
//                bind(PlayerService.class).to(PlayerService.class);
//            }
//        });
//        packages("com.vtyurin.soccer");
//    }
}
