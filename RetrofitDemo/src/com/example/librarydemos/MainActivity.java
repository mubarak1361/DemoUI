package com.example.librarydemos;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements android.view.View.OnClickListener{

	private static final String API_URL = "http://api.openweathermap.org/data/2.5";
	private Button submit;
	private EditText city;
	private WeatherApi weatherApi;
	private RestAdapter restAdapter;
	private TextView countryValue,weatherValue,tempValue,windValue;
	
	public interface WeatherApi {
		@GET("/weather")
		public void getWeather(@Query("q") String cities,
				Callback<WeatherData> callback);
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		submit =(Button) findViewById(R.id.submit);
		city = (EditText) findViewById(R.id.city);
		
		countryValue = (TextView) findViewById(R.id.country);
		weatherValue = (TextView) findViewById(R.id.weathervalue);
		tempValue = (TextView) findViewById(R.id.tempvalue);
		windValue = (TextView) findViewById(R.id.windvalue);
		
		restAdapter = new RestAdapter.Builder()
				.setEndpoint(API_URL).build();
		
		 weatherApi = restAdapter.create(WeatherApi.class);
		 submit.setOnClickListener(this);
	}
	
	

	// JSON structure Classes
	public static class WeatherData {
		Weather main;
		Country sys;
		String name;
		WindData wind;
		List<Data> weather;
	}
	public static class Weather {
		String humidity;
		String temp;
		String temp_max;
		String temp_min;
	}

	public static class Main {
		Weather main;
	}

	public static class Sys {
		Country sys;
	}

	public static class Country {
		String country;
	}

	public static class WindData {
		String speed;
		String deg;
	}

	public static class Data {
		String main;
		String description;
	}

	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.submit:
			if(city.getText().length() > 0){
				
			weatherApi.getWeather(city.getText().toString(),

					new Callback<WeatherData>() {

						@Override
						public void failure(RetrofitError arg0) {

						}

						@Override
						public void success(WeatherData values, Response arg1) {
							
							
							countryValue.setText(values.name.toString() + ", "+ values.sys.country.toString());
							weatherValue.setText(values.weather.get(0).main.toString());
							tempValue.setText(values.main.temp.toString());
							windValue.setText(values.wind.speed.toString());
							
							Log.d("Name", values.name.toString());
							Log.d("humidity", values.main.humidity.toString());
							Log.d("temp", values.main.temp.toString());
							Log.d("temp_max", values.main.temp_max.toString());
							Log.d("temp_min", values.main.temp_min.toString());
							Log.d("Wind Speed", values.wind.speed.toString());
							Log.d("main", values.weather.get(0).main.toString());
							Log.d("Description", values.weather.get(0).description.toString());

						}
					});
			
			}
			else {
				
				countryValue.setText("Country");
				weatherValue.setText("-");
				tempValue.setText("-");
				windValue.setText("-");
				
			}
			break;

		default:
			break;
		}		
	}

}
