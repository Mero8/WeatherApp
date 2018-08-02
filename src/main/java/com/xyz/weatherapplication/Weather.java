/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xyz.weatherapplication;
/**
 * Weather object and it's attributes
 * @author Omar Attia
 */
public class Weather 
{

  private String temp; //Temperature
  private String chill; // Wind Chill
  private String humidity; // Humidity
  private String lastBuildDate; // Date and time of nuild

  public Weather() {}


  public String getTemp() 
  {
      return temp; 
  }
  
  public void setTemp(String temp) 
  {
    this.temp = temp;
  }

  public String getChill()
  {
      return chill;
  }
  
  public void setChill(String chill) 
  {
    this.chill = chill;
  }

  public String getHumidity()
  {
      return humidity;
  }
  
  public void setHumidity(String humidity) 
  {
    this.humidity = humidity;
  }

  public void setLastBuildDate(String lastBuildDate) 
  {
    this.lastBuildDate = lastBuildDate;
  }

  public String getLastBuildDate() 
  {
    return lastBuildDate;
  }
  
  /**
   * converts weather object into string
   * @return weather information 
   */
  @Override
  public String toString()
  {
        StringBuilder sb = new StringBuilder();
        
        sb.append(lastBuildDate).append(";");
        sb.append(( new Integer(temp)-32)*5/9).append(";");
        sb.append(chill).append(";");
        sb.append(humidity);        
        return sb.toString();
  }
    
    /**
     * 
     * @return headers of the excel sheet 
     */
    public static String toDiskColumnNames()
    {
      StringBuilder sb = new StringBuilder();
      
      sb.append("Build Date").append(";");
      sb.append("Temp").append(";");
      sb.append("Chill").append(";");
      sb.append("Humidity");        
      return sb.toString();
    }
  
}
