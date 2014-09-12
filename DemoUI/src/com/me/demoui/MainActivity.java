package com.me.demoui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
 
	private Button set;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        set = (Button) findViewById(R.id.pass);
        set.setOnClickListener(this);
        
       
    }
	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.pass:
			StorageAccess.getInstance().setString("Test String");
			Intent intent = new Intent(this, NewActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
		
	}
}
