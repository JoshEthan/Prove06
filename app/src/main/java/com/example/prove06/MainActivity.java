package com.example.prove06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtCity;
    String cityName;
    Context thisContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void onGetTemperature(View theButton) {
                                                            // VARIABLES
        txtCity  = (EditText) findViewById(R.id.cityName);
        cityName = txtCity.getText().toString();
                                                            // BACKGROUND THREAD
        temperature t = new temperature(cityName);
        t.theContext = this;
        Thread aBackgroundThread = new Thread(t);
        aBackgroundThread.start();
    }

    public void onGetForecast(View theButton) {
        // VARIABLES
        txtCity  = (EditText) findViewById(R.id.cityName);
        cityName = txtCity.getText().toString();

        forecast f = new forecast(cityName);
        f.theContext = thisContext;

        Thread thread2 = new Thread(f, "Forecast");
        thread2.start();
    }

}



