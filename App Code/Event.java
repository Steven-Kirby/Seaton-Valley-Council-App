package com.team8.seatonvalley;

import java.sql.Date;
import static java.sql.Types.NULL;

/**
 * Created by Steven Kirby on 06/04/2018.
 * Last Edited by Steven Kirby on 11/04/2018.
 *
 * Event object contains information about an event
 */


public class Event {

    String name;
    String dateTime;
    String location;
    double latitude;
    double longitude;
    int picture;
    String description;

    Event(String name, String dateTime, String location, double latitude, double longitude, int picture , String description){
        this.name = name;
        this.dateTime = dateTime;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.picture = picture;
        this.description = description;

    }

    Event(String name, String dateTime, int picture, String description){
        this.name = name;
        this.dateTime = dateTime;
        this.location = "TBA";
        this.latitude = NULL;
        this.longitude = NULL;
        this.picture = picture;
        this.description = description;
    }

    Event(String name, String location, double latitude, double longitude, String description){
        this.name = name;
        this.dateTime = new Date(System.currentTimeMillis()).toString();
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
    }

    Event(String name, String location, double latitude, double longitude, int picture, String description){
        this.name = name;
        this.dateTime = "TBA";
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.picture = picture;
        this.description = description;
    }

    Event(String name, String dateTime, String location, int picture, String description){
        this.name = name;
        this.dateTime = dateTime;
        this.location = location;
        this.latitude = NULL;
        this.longitude = NULL;
        this.picture = picture;
        this.description = description;
    }
    Event(String name, String dateTime, String location, double latitude, double longitude, String description){
        this.name = name;
        this.dateTime = dateTime;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.picture = R.drawable.seatonheart;
        this.description = description;
    }

    Event(String name, String dateTime, String location, String description){
        this.name = name;
        this.dateTime = dateTime;
        this.location = location;
        this.latitude = NULL;
        this.longitude = NULL;
        this.picture = R.drawable.seatonheart;
        this.description = description;
    }

    Event(String name, String location, Double latitude,Double longitude, String description){
        this.name = name;
        this.dateTime = "TBA";
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.picture = R.drawable.seatonheart;
        this.description = description;
    }

    Event(String name, String location, String description){
        this.name = name;
        this.dateTime = "TBA";
        this.location = location;
        this.latitude = NULL;
        this.longitude = NULL;
        this.picture = R.drawable.seatonheart;
        this.description = description;
    }

    Event(String name, String description){
        this.name = name;
        this.dateTime = "TBA";
        this.location = "TBA";
        this.latitude = NULL;
        this.longitude = NULL;
        this.picture = R.drawable.seatonheart;
        this.description = description;
    }
}
