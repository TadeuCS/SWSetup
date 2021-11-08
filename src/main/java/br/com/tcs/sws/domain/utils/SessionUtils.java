/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcs.sws.domain.utils;

import br.com.tcs.sws.domain.entities.ParamettersFile;

/**
 *
 * @author Tadeu-pc
 */
public class SessionUtils {

    public static String operationalSystem = System.getProperty("os.name"); //Windows, Linux
    public static ParamettersFile parametters;
    
    private static final SessionUtils instance = new SessionUtils();

    private SessionUtils() {}

    public static SessionUtils getInstance() {
        return instance; 
    }

}
