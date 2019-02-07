/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nzposttest.service;

import com.nzposttest.exception.ShortestRouteException;
import com.nzposttest.jgrapht.RailwayNetwork;
import com.nzposttest.jgrapht.RailwayNetwork.Town;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ShortestPathService provides method for querying the shortest path
 * implementation of the JGraphit Djikstra Shortest Path algorithm
 *
 * @author serge
 */
@Component
public class ShortestPathService {

    /**
     * shortestPath implementation instance
     *
     * @author serge
     */
    @Autowired
    private RailwayNetwork railwayNetwork;

    /**
     * findShortestPath obtains the shortest route by calling
     * findPathBetweenRoute method of ShortestPathDAG
     *
     * @param query - comma delimited source and destination Towns/Letters
     * @return the shortest route eg AB12 or BIJ25
     */
    public String findShortestPath(final String query) {
        String[] q = query.split(",");
        if (q.length < 2) {
            throw new ShortestRouteException("Invalid route query " + query);
        }
        return railwayNetwork.shortestRoute(
                Town.valueOf(q[0]), 
                Town.valueOf(q[1])
        );
    }
}
