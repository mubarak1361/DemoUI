package com.me.demoui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class NewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new);
		
		TextView text = (TextView)findViewById(R.id.text);
		text.setText(StorageAccess.getInstance().getString());
	}
}
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:interpolator="@android:anim/linear_interpolator">
    <scale
        android:fromXScale="1.0"
        android:toXScale="1.7"
        android:fromYScale="1.0"
        android:toYScale="1.7"
        android:pivotX="50%"
        android:pivotY="50%"
        android:duration="200"
        android:repeatCount="1"
        android:repeatMode="reverse" />
</set>
