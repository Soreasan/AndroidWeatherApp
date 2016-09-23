package com.cslearner.www.weather;
//This class is the entry point for the other classes.
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MainActivity extends AppCompatActivity {

    //This is a magical method in Android land.  Always run on startup.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Many phones are already multithreaded.  64 bit phones automatically implement multithreading.
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        start();
    }

    //Methods manipulate data
    private void start(){
        //The connection URL
        String url = "https://spurious-balance-7335.justapis.io/weather.json";
        //Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();
        //Add the JSON message converter
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        //Make the HTTP GET request, marshaling the response to the WeatherApp
        //This creates a copy of our weatherObject and fills it with information
        WeatherObject weatherObject = restTemplate.getForObject(url, WeatherObject.class);

        //Allows us to interact with the text views in our xml
        TextView tempView = (TextView) findViewById(R.id.tempTextView);
        tempView.setText(weatherObject.getTemp());

        TextView conditionView = (TextView) findViewById(R.id.conditionTextView);
        conditionView.setText(weatherObject.getCondition());

        TextView locationView = (TextView) findViewById(R.id.locationTextView);
        locationView.setText(weatherObject.getLocation());

        //This one is basically a browser
        WebView weatherImg = (WebView) findViewById(R.id.weatherImgWebView);
        weatherImg.loadUrl(weatherObject.getImage());
    }
}
