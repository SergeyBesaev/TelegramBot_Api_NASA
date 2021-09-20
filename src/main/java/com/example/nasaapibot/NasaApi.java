package com.example.nasaapibot;

import java.util.Date;
import java.util.GregorianCalendar;

public class NasaApi {

    private final static String APIKEY = "*****";
    private final static String EMAIL = "ser.besaev@gmail.com";
    private final static String IdAPI = "****";

    public static String urlMARS() {
        GregorianCalendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();
        int year = calendar.getWeekYear();
        int month = date.getMonth() + 1;
        int day = date.getDate() - 2;

        String dateString = year + "-" + month + "-" + day;

        String urlMARS = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=" + dateString + "&api_key=" + APIKEY;

    return urlMARS;
    }

    public static String urlMARS(String userDate) {
        String urlMARS = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=" + userDate + "&api_key=" + APIKEY;
    return urlMARS;
    }


}
