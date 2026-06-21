package com.sdet.practice;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    Properties props = new Properties();
    public ConfigManager(){

        InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");

        try{

            props.load(input);

        } catch (IOException e) {

            throw new RuntimeException(e);
        }

    }

    public String getProperty(String key){

        return props.getProperty(key);
    }

}
