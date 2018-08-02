package com.xyz.weatherapplication;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Omar Attia
 */
public class WeatherParser
{
    
    /**
     * parses Inputstrean from online Yahoo weather API and sets attributes
     * @param inputStream information retieved from the online api 
     * @return weather object
     * @throws Exception 
     */
    public Weather parse(InputStream inputStream) throws Exception
    {
        Weather weather = new Weather();

        SAXReader xmlReader = createXmlReader();
        Document doc = xmlReader.read(inputStream);

        weather.setLastBuildDate(doc.valueOf("/query/results/channel/item/y:condition/@date"));
        weather.setTemp(doc.valueOf("/query/results/channel/item/y:condition/@temp"));
        weather.setChill(doc.valueOf("/query/results/channel/y:wind/@chill"));
        weather.setHumidity(doc.valueOf("/query/results/channel/y:atmosphere/@humidity"));

        return weather;
    }

    /**
     * creates XML file that stores data from inputstream
     * @return 
     */
    private SAXReader createXmlReader() 
    {
        Map<String, String> uris = new HashMap<String, String>();
        uris.put("y", "http://xml.weather.yahoo.com/ns/rss/1.0");

        DocumentFactory factory = new DocumentFactory();
        factory.setXPathNamespaceURIs(uris);

        SAXReader xmlReader = new SAXReader();
        xmlReader.setDocumentFactory(factory);

        return xmlReader;
    }
}