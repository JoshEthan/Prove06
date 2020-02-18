package com.example.prove06;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

// ANITA'S GIT TEST FOR TEAM ACTIVITY: FEEL FREE TO DELETE THIS!!!

public class forecast implements Runnable {

    private static Gson g = new Gson();
    Handler handler = new Handler(Looper.getMainLooper());
    Context theContext;
    String theCityName;
    String message;

    public forecast(String aCityName) {
        theCityName = aCityName;
        System.out.print(aCityName);
    }

    public void run() {
        Log.d("Pre-Creation", "About to create intent with " + theCityName);

        URLConnection connection = new URLConnection(theCityName);
        String info1 = connection.getContent();
        System.out.println();
        WeatherForecast wf = g.fromJson(info1, WeatherForecast.class);
        wf.displayStats();

        for (WeatherForecastItem list2 : wf.list) {
            message = " " +(list2.measurements.get("temp"));
        }

        handler.post(new Runnable() {

            @Override
            public void run() {
               Toast.makeText(theContext, "Temperature:"+message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}