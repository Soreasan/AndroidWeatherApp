package com.cslearner.www.weather;

/**
 * Created by User on 9/22/2016.
 * This is a class that can store and retrieve weather information.
 */

public class WeatherObject {
    //Programming does two things: stores data, manipulates data
    private String temp;
    private String location;
    private String condition;
    private String image;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
