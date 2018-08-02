/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xyz.weatherapplication;

/**
 * Weather App that stores weather information in Excel sheet
 * @author Omar Attia
 */
public class Main {

    public static void main(String[] args) throws Exception 
    {
        new Main().start();
    }
    
    /**
     * Sarts recieving weather information and storing it
     * @throws Exception 
     */
    public void start() throws Exception
    {
        new toDiskWriter();
    }
}
