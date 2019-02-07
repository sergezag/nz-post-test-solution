/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nzposttest.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * ShortestPathDAG provides data model for the shortest path query result as a
 * String
 *
 * @author serge
 */
public class ShortestPathBean {

    /*
    * Shortest route result 
     */
    @JsonValue
    private String shortestRoute;

    /*
    * deafult constructor
     */
    public ShortestPathBean() {

    }

    /*
    *  constructor takes Shortest route string
     */
    public ShortestPathBean(final String shortestRoute) {
        this.shortestRoute = shortestRoute;

    }

    /**
     * @return the shortestRoute
     */
    public String getShortestRoute() {
        return shortestRoute;
    }

    /**
     * @param shortestRoute the shortestRoute to set
     */
    public void setShortestRoute(String shortestRoute) {
        this.shortestRoute = shortestRoute;
    }

    /**
     * @return shortestRoute as string
     */
    @Override
    public String toString() {
        return this.shortestRoute;
    }
}
