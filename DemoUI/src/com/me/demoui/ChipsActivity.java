package com.me.demoui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class ChipsActivity extends Activity {

	private TextView text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chips);
		
		text  = (TextView) findViewById(R.id.spantext);
		SpannableStringBuilder span = new SpannableStringBuilder(text.getText());
		StyleSpan bold = new StyleSpan(Typeface.BOLD);
		span.setSpan(bold, 1, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		 Bitmap smiley = BitmapFactory.decodeResource( getResources(), R.drawable.ic_launcher );
		 span.setSpan(new ImageSpan(smiley), 1, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		text.setText(span,BufferType.SPANNABLE);
	}
}
