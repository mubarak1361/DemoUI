package com.example.materialdesign.asynctask;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.materialdesign.model.Transcation;
import com.example.materialdesign.service.ServiceHandler;

public class ExpensesAsyncTask extends AsyncTask<String, Integer, ArrayList<Transcation>> {

	private static final String BASE_URL ="https://expensetracker-opendesk.rhcloud.com/";
	private ServiceHandler sh;
	private JSONObject expense ;
	private ArrayList<Transcation> expenses;
	private ExpenseActivityTask expenseActivityTask;
	public interface ExpenseActivityTask{
		public void getAllExpenses(ArrayList<Transcation> transcations);
	}
	
	public ExpensesAsyncTask(Context context){
//		expenseActivityTask = (ExpenseActivityTask) context;
		expenses = new ArrayList<Transcation>(); 
	}
	
	@Override
	protected void onPreExecute(){

	}
	
	@Override
	protected ArrayList<Transcation> doInBackground(String... params) {
		
		sh =  ServiceHandler.Instance();
	
		String response=null;
	
		response =  sh.makeServiceCall(BASE_URL
				+ "expenses/index.json", 1);
		/*Log.d("Expense Response", response.toString());*/
		
		try {
			 expense =  new JSONObject(response.toString());
			JSONArray jsArray = expense.getJSONArray("expen");
			/*Log.d("Length",""+jsArray.length());*/
			for(int i=0; i<jsArray.length();i++){
				JSONObject obj = jsArray.getJSONObject(i);
				Transcation transcation = new Transcation(obj.getJSONObject("Expense").getString("date"),obj.getJSONObject("Expensecategory").getString("name"),
						obj.getJSONObject("Expense").getString("amount"));
				expenses.add(transcation);
				/*Log.d("Expense "+(i+1),
						obj.getJSONObject("Expensecategory").getString("name")+" "+
						obj.getJSONObject("Expense").getString("amount"));*/
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return expenses;
	}
	
	@Override
	protected void onPostExecute(ArrayList<Transcation> transcations){
		/*expenseActivityTask.getAllExpenses(transcations);*/
	}

}
