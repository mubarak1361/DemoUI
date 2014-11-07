package com.example.materialdesign.asynctask;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.materialdesign.model.Categories;
import com.example.materialdesign.service.ServiceHandler;

public class LogoutAsyncTask extends
		AsyncTask<String, Integer, String> {

	private static final String BASE_URL = "https://expensetracker-opendesk.rhcloud.com/";
	private ServiceHandler sh;


	public LogoutAsyncTask(Context context) {
		
	}

	@Override
	protected void onPreExecute() {

	}

	@Override
	protected String doInBackground(String... params) {

		sh = ServiceHandler.Instance();

		String response = null;

		response = sh.makeServiceCall(BASE_URL + "users/logout.json", 1);
		Log.d("Logout Response", response.toString());

		return response;
	}

	@Override
	protected void onPostExecute(String string) {
	
	}

}
