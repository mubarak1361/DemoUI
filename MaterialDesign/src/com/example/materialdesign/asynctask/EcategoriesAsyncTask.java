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

public class EcategoriesAsyncTask extends
		AsyncTask<String, Integer, ArrayList<Categories>> {

	private static final String BASE_URL = "https://expensetracker-opendesk.rhcloud.com/";
	private ServiceHandler sh;
	private ArrayList<Categories> categoriesArray;
	private JSONObject ecategory;

	private ECategoriesTaskActivity eCategoriesTaskActivity;

	public interface ECategoriesTaskActivity {
		public void getCategories(ArrayList<Categories> categoriesArray);
	}

	public EcategoriesAsyncTask(Context context) {
		eCategoriesTaskActivity = (ECategoriesTaskActivity) context;

	}

	@Override
	protected void onPreExecute() {

	}

	@Override
	protected ArrayList<Categories> doInBackground(String... params) {

		sh = ServiceHandler.Instance();

		String response = null;

		categoriesArray = new ArrayList<Categories>();
		response = sh.makeServiceCall(
				BASE_URL + "expensecategories/index.json", 1);

		try {
			ecategory = new JSONObject(response.toString());
			JSONArray catJSONArray = ecategory.getJSONArray("ecategory");
			for (int i = 0; i < catJSONArray.length(); i++) {
				JSONObject obj = catJSONArray.getJSONObject(i);
				Categories categories = new Categories(obj.getJSONObject(
						"Expensecategory").getString("name"), obj
						.getJSONObject("Expensecategory").getString("color"));
				categoriesArray.add(categories);
			}

		} catch (JSONException e1) {
			
			e1.printStackTrace();
		}

		response = sh.makeServiceCall(BASE_URL + "users/logout.json", 1);
		Log.d("Logout Response", response.toString());

		return categoriesArray;
	}

	@Override
	protected void onPostExecute(ArrayList<Categories> categoriesArray) {
		eCategoriesTaskActivity.getCategories(categoriesArray);
	}

}
