package com.example.prove06;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherForecastItem {
    String dt_txt;                                          //THE TIME

    @SerializedName("main")
    Map<String, Float> measurements = new HashMap<String, Float>();     //THE TEMP

    @SerializedName("wind")
    Map<String, Float> wind = new HashMap<String, Float>();             //WIND

    @SerializedName("weather")
    List<weather> weather = new ArrayList<weather>();       //DESCRIPTION

}

 class weather {
    @SerializedName("description")
    String id;
}


