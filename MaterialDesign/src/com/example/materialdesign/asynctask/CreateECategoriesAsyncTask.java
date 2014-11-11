package com.example.materialdesign.asynctask;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

import com.example.materialdesign.service.ServiceHandler;

public class CreateECategoriesAsyncTask extends AsyncTask<String, Integer, String> {

	private static final String BASE_URL ="https://expensetracker-opendesk.rhcloud.com/";
	private static final String EXPENSE_CATEGOIES_ADD = "expensecategories/add";
	private static final String OUTPUT = ".json";
	private static final String NAME_KEY = "name";
	private static final String COLOR_KEY = "color";
	private ServiceHandler sh;

	
	public CreateECategoriesAsyncTask(){

	}
	@Override
	protected void onPreExecute(){

	}
	
	@Override
	protected String doInBackground(String... params) {
		
		sh = ServiceHandler.Instance();
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair(NAME_KEY, params[0]));
		nameValuePairs.add(new BasicNameValuePair(COLOR_KEY, params[1]));
		String response=null;
		response =  sh.makeServiceCall(BASE_URL
				+ EXPENSE_CATEGOIES_ADD + OUTPUT, 2, nameValuePairs);
		Log.d("Create Ecategory Response", response.toString());
		try {
			JSONObject jsonObject = new JSONObject(response);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return null;
	}
	
	@Override
	protected void onPostExecute(String string){
		
	}

}
