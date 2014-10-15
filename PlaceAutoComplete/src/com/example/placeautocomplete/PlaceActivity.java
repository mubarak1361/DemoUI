package com.example.placeautocomplete;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;

public class PlaceActivity extends Activity {

	private AutoCompleteTextView source,destination;
	private PlacesAutoCompleteAdapter Padapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        
        source =  (AutoCompleteTextView) findViewById(R.id.source);
        destination = (AutoCompleteTextView) findViewById(R.id.dest);
        
        source.setThreshold(1);
        destination.setThreshold(1);
        
        Padapter =  new PlacesAutoCompleteAdapter(this, android.R.layout.simple_list_item_1);
        source.setAdapter(Padapter);
        destination.setAdapter(Padapter);
        
      
    }

}
