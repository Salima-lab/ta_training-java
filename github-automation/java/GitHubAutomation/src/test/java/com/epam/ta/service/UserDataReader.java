package com.epam.ta.service;

import java.util.ResourceBundle;

public class UserDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));
    public static String getUserData(String key){
        return resourceBundle.getString(key);
    }
}
