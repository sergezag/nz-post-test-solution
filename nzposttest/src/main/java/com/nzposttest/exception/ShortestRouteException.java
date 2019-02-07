/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nzposttest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ShortestRouteException for North South Railway application Web service
 *
 * @author serge
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ShortestRouteException extends RuntimeException {

    /**
     * constructor takes string error message
     *
     * @author serge
     */
    public ShortestRouteException(final String message) {
        super(message);
    }
}
