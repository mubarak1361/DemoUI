package com.example.librarydemos;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.GridView;

public class ListviewActivity extends Activity {
	
	private static final String API_URL = "http://api.androidhive.info";
	private MoviesApi moviesApi;
	private RestAdapter restAdapter;
	private GridView gridView;
	
	public interface MoviesApi {
		@GET("/json/movies.json")
		public void getWeather(
				Callback<List<Movies>> callback);
	}

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid);
		
		gridView =  (GridView) findViewById(R.id.grid);
		
		restAdapter = new RestAdapter.Builder()
		.setEndpoint(API_URL).build();

		moviesApi = restAdapter.create(MoviesApi.class);
		
		moviesApi.getWeather(new Callback<List<Movies>>() {
			
			@Override
			public void success(List<Movies> Values, Response arg1) {
				// TODO Auto-generated method stub
				for (Movies movies : Values) {
					Log.d("image", movies.image);
				}
				gridView.setAdapter(new GridAdapter(LayoutInflater.from(getBaseContext()), Values));
				
			}
			
			@Override
			public void failure(RetrofitError arg0) {
				// TODO Auto-generated method stub
				Log.d("Error", arg0.toString());
				
			}
		});
		
	}
	
	public static class Movies {		
		String title;
		String image;
		String rating;
		String releaseYear;
	}
	
	
}
