package com.example.materialdesign;

import android.app.Activity;
import android.os.Bundle;
import android.text.BoringLayout;

import com.example.materialdesign.asynctask.LoginAsyncTask;

public class MainActivity extends Activity {
	
	BoringLayout boringLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		LoginAsyncTask asyncTask =  new LoginAsyncTask(this);
		asyncTask.execute("mubarak","Simple123");
		
		
	}

}