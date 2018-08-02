/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xyz.weatherapplication;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


/**
 *
 * @author Omar Attia
 */
public class WeatherReciever 
{
    
    /**
     * Starts a connection with the Yahoo weather service APIS
     * @return incoming data from the API
     * @throws Exception 
     */
    public InputStream retrieve() throws Exception 
    {
        String url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text=%27braunschweig%27)";
        URLConnection conn = new URL(url).openConnection();
        return conn.getInputStream();
    }
}
