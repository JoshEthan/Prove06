package com.example.prove06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLConnection {

    private static HttpURLConnection connection; // 1.DEFINE OUR CONNECTION
    // Method 1: java.net
    BufferedReader reader;                              //8. ?
    String line;                                        //9. ?
    StringBuffer responseContent = new StringBuffer();  //10. Used to append each line and build a response content
    URL url;

    public URLConnection(String c1) {
        try {
            this.url = new URL("https://api.openweathermap.org/data/2.5/forecast?q=" + c1 + ",us&units=imperial&appid=8c438088f6bba9ab243fb835c0fbfe09");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public URLConnection(int id) {
        try {
            this.url = new URL("https://api.openweathermap.org/data/2.5/forecast?id=" + id + "&appid=8c438088f6bba9ab243fb835c0fbfe09");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public URLConnection(String city, String country) {
        try {
            this.url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country + "&units=imperial&appid=8c438088f6bba9ab243fb835c0fbfe09");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public String getContent() {
        try {
            /*url = new URL("http://api.openweathermap.org/data/2.5/weather?q=London," + //2. DEFINE URL
                    "uk&APPID=8c438088f6bba9ab243fb835c0fbfe09");   */             //3. NEEDS TRY&CATCH
            connection = (HttpURLConnection) url.openConnection();  //4. OPEN CONNECTION TO API END POINT
            //5. NEEDS TRY&CATCH
            //6. NEEDS TO BE TYPE CAST TO "HttpURLConnection"
            //7. Request setup
            connection.setRequestMethod("GET");         //?
            connection.setConnectTimeout(5000);         //5 seconds or timeout
            connection.setReadTimeout(5000);
            int status = connection.getResponseCode();
            System.out.println(status);                 //Check if connection is successful

            //With HttpURLConnection the response we get is a input stream
            //To read input stream we need input stream reader and wrap inside a buffer reader

            if (status > 299) {     //11. IF status is not successful
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream())); //11A. Reader will read error message
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); //12. Read input message
            }

            while ((line = reader.readLine()) != null) {       //13. While we have things to read, append it to response content
                responseContent.append(line);                //13A. Build response content from input stream
            }
            reader.close();                                 //14. For after reading is complete

            // System.out.println(responseContent.toString()); //15. The stuff we want

        } catch (
                MalformedURLException e) { //3A. THE CATCH
            e.printStackTrace();
        } catch (
                IOException e) {           //5A. THE CATCH
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return responseContent.toString();
    }
}

