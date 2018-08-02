/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xyz.weatherapplication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Omar Attia
 * 
 */
public class toDiskWriter 
{
    private final Timer timer;
    private Weather weather;
    
    public toDiskWriter()
    {
        timer = new Timer();
        timer.schedule(task,0,1000);
    }
    
    private final TimerTask task = new TimerTask()
    {
        @Override
        public void run() 
        {
            try {        
                InputStream dataIn = new WeatherReciever().retrieve();
                weather = new WeatherParser().parse( dataIn );
                saveToDisk();
                Thread.sleep(60*60*1000l);
            } catch (JAXBException | IOException | InterruptedException ex) {
                Logger.getLogger(toDiskWriter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(toDiskWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        /**
         * saves weather information in a file
         * @throws JAXBException
         * @throws IOException 
         */
        public void saveToDisk() throws JAXBException, IOException
        {
            System.out.println(weather.toString());
            File file = new File("Weather.csv");
            boolean newFile = file.createNewFile();
            FileWriter fw = new FileWriter(file,true);
                       
            if(newFile)
            {
                fw.append(Weather.toDiskColumnNames());
                fw.append(System.lineSeparator());
            }
            fw.append(weather.toString());
            fw.append(System.lineSeparator());
            fw.close();
        }
    };   
}
    