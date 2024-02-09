package com.uni_sabios.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    
    private static Properties properties;

    static{
        properties = new Properties();
        loadProperties();
    }

    private static void loadProperties() {
        try (FileInputStream input =  new FileInputStream("configuration.properties")) {
            properties.load(input);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return properties.getProperty(key);
    }
    
}
