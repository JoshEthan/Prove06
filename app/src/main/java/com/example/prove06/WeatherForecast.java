package com.example.prove06;

import com.google.gson.annotations.SerializedName;

import java.util.*;

public class WeatherForecast {

    @SerializedName("list")
    List<WeatherForecastItem> list = new ArrayList<>();
    float maxTemp=0;
    float maxSpeed=0;

    public void displayStats(){

        System.out.println();
        int count=0;

        for (WeatherForecastItem list2 : list) {
            count++;
            System.out.println("WEATHER FORECAST #"+count);
            System.out.println("    TIME: "+list2.dt_txt);
            System.out.println("    Temperature: "+list2.measurements.get("temp"));
            System.out.println("    Speed: "+list2.wind.get("speed"));
            System.out.println("    Description: "+list2.weather.get(0).id);
            if(list2.measurements.get("temp_max")>maxTemp){maxTemp=list2.measurements.get("temp_max");};
            if(list2.wind.get("speed")>maxSpeed){maxSpeed=list2.wind.get("speed");};
        }
    } //DISPLAY
}
