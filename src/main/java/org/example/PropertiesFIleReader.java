package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFIleReader {
    public static String readPropsTestData(String fileName, String key){
        try {
            FileInputStream F = new FileInputStream("TestData/"+fileName+"_testData.properties");
            Properties P = new Properties();
            P.load(F);
            return P.getProperty(key);
        } catch (Exception e) {

        }
        return null;
    }
}
