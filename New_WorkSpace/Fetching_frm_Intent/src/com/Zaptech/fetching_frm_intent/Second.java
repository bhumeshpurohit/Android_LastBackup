package com.Zaptech.fetching_frm_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Second extends Activity {
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		tv=(TextView)findViewById(R.id.textView1);
		Intent i=getIntent();
		tv.setText("FirstName=="+String.valueOf(i.getStringExtra("First"))+"  "+"LastName=="+String.valueOf(i.getStringExtra("Last")));
		
		
	}
}
