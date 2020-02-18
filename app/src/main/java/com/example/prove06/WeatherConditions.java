package com.example.prove06;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class WeatherConditions {
    int id;
    String name;
    @SerializedName("main")
    Map<String, Float> measurements = new HashMap<String, Float>();

    public void displayStats(){
        System.out.println("CURRENT WEATHER CONDITIONS");
        System.out.println("CITY: "+name);
        System.out.println("ID: "+id);
        System.out.println("GENERAL INFO: "+measurements);
        System.out.println();
    }
}
