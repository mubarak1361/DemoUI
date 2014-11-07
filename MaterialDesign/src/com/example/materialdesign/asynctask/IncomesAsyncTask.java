package com.example.materialdesign.asynctask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

import com.example.materialdesign.service.ServiceHandler;

public class IncomesAsyncTask extends AsyncTask<String, Integer, String> {

	private static final String BASE_URL ="https://expensetracker-opendesk.rhcloud.com/";
	private ServiceHandler sh;

	private JSONObject income ;
	
	public IncomesAsyncTask(){
	}
	
	@Override
	protected void onPreExecute(){

	}
	
	@Override
	protected String doInBackground(String... params) {
		
		sh =  ServiceHandler.Instance();
	
		String response=null;
		
		response =  sh.makeServiceCall(BASE_URL
				+ "incomes/index.json", 1);
	/*	Log.d("Income Response", response.toString());*/
		 try {
			income =  new JSONObject(response.toString());
			JSONArray incomeJSONArray = income.getJSONArray("incom");
			for(int i=0; i<incomeJSONArray.length();i++){
				
				JSONObject obj = incomeJSONArray.getJSONObject(i);
				Log.d("Income "+(i+1),
						obj.getJSONObject("Incomecategory").getString("name")+" "+
						obj.getJSONObject("Income").getString("amount"));
			}
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
