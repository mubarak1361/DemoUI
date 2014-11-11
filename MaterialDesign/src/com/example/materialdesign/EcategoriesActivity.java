package com.example.materialdesign;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

import com.example.materialdesign.adapter.EcategoriesAdapter;
import com.example.materialdesign.asynctask.CreateECategoriesAsyncTask;
import com.example.materialdesign.asynctask.EcategoriesAsyncTask;
import com.example.materialdesign.asynctask.EcategoriesAsyncTask.ECategoriesTaskActivity;
import com.example.materialdesign.asynctask.ExpensesAsyncTask;
import com.example.materialdesign.model.Categories;

public class EcategoriesActivity extends Activity implements ECategoriesTaskActivity {
private ListView list;
private EcategoriesAdapter adapter;
private LayoutInflater inflater;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ecategories);
		list=(ListView) findViewById(R.id.categorylist);
		inflater = LayoutInflater.from(this);
		
		ExpensesAsyncTask expenseAsyncTask = new ExpensesAsyncTask(this);
		expenseAsyncTask.execute();
		
		/*IncomesAsyncTask incomesAsyncTask = new IncomesAsyncTask();
		incomesAsyncTask.execute();*/
		
		EcategoriesAsyncTask ecategoriesAsyncTask = new EcategoriesAsyncTask(this);
		ecategoriesAsyncTask.execute();
		
		CreateECategoriesAsyncTask createECategoriesAsyncTask = new CreateECategoriesAsyncTask();
		createECategoriesAsyncTask.execute("EMI","e3e3e3");
	}

	@Override
	public void getCategories(ArrayList<Categories> categoriesArray) {
		// TODO Auto-generated method stub
		
		adapter =  new EcategoriesAdapter(inflater, categoriesArray);
		list.setAdapter(adapter);
	}
	
}