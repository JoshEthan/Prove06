package com.example.prove06;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;


public class temperature implements Runnable {

    private static Gson g = new Gson();
    Handler handler = new Handler(Looper.getMainLooper());
    Context theContext;
    String theCityName;
    float message;

    public temperature(String aCityName) {
        theCityName = aCityName;
        System.out.print(aCityName);
    }

    public void run() {
        Log.d("Pre-Creation", "About to create intent with " + theCityName);

        URLConnection connection = new URLConnection(theCityName, "us");
        String info1 = connection.getContent();
        System.out.println();
        WeatherConditions w1 = g.fromJson(info1, WeatherConditions.class);
        w1.displayStats();

        message = w1.measurements.get("temp");

        handler.post(new Runnable() {

            @Override
            public void run() {
                Toast.makeText(theContext, "Temperature:"+message, Toast.LENGTH_SHORT).show();
            }
        });

    }
}