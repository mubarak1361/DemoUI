package com.example.materialdesign.asynctask;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.materialdesign.EcategoriesActivity;
import com.example.materialdesign.service.ServiceHandler;

public class LoginAsyncTask extends AsyncTask<String, Integer, String> {

	private static final String BASE_URL ="https://expensetracker-opendesk.rhcloud.com/";
	private static final String USERS_LOGIN = "users/login";
	private static final String OUTPUT = ".json";
	private static final String USERNAME_KEY = "username";
	private static final String PASSWORD_KEY = "password";
	private ServiceHandler sh;
	private Context context;
	
	public LoginAsyncTask(Context context){
		this.context =  context;
	}
	@Override
	protected void onPreExecute(){

	}
	
	@Override
	protected String doInBackground(String... params) {
		
		sh = ServiceHandler.Instance();
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair(USERNAME_KEY, params[0]));
		nameValuePairs.add(new BasicNameValuePair(PASSWORD_KEY, params[1]));
		String response=null;
		String result=null;
		response =  sh.makeServiceCall(BASE_URL
				+ USERS_LOGIN + OUTPUT, 1,0, nameValuePairs);
		Log.d("Login Response", response.toString());
		try {
			JSONObject jsonObject = new JSONObject(response);
			result = jsonObject.getJSONObject("message").getJSONObject("data").getString("loginSuccess");
			Log.d("Result", result);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		if(result.equals("1")){
		Intent intent =  new Intent(context,EcategoriesActivity.class);
		context.startActivity(intent);
		}
		
	
		return null;
	}
	
	@Override
	protected void onPostExecute(String string){
		
	}

}
