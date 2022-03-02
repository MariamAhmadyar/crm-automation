package com.nextbasecrm.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    // 1- Create the object of properties

    private static Properties properties =new Properties();

    static {
        try {
            // 2- we need to open the file in java memory: fileInputStream

            FileInputStream file= new FileInputStream("configuration.properties");

            //3- load the properties object using FileInputStream objet;

            properties.load(file);

            file.close();


        } catch (IOException e) {

            System.out.println("File not found in the Configuration class");

            e.printStackTrace();
        }



    }

    public  static  String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}
