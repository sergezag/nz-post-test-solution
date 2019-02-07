/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nzposttest.ws;

import com.nzposttest.model.ShortestPathBean;
import com.nzposttest.service.ShortestPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ShortestRouteController for North South Railway application Web service
 *
 * @author serge
 */
@RestController
public class ShortestRouteController {

    /**
     * getShortestRoute obtains the shortest route by calling
     * ShortestPathService
     *
     * @param query - comma delimited source and destination Towns/Letters eg.,
     * A,B or B,J
     * @return the shortest route eg., AB12 or BIJ25
     */
    @Autowired
    ShortestPathService service;

    @GetMapping(path = "/get-shortest-route/route/{query}")
    public ShortestPathBean getShortestRoute(@PathVariable String query) {
        return new ShortestPathBean(service.findShortestPath(query));
        //return new ShortestPathBean(String.format("Shrt for %s", query));
    }
}
