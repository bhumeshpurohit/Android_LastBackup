package com.zaptech.registration_demo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.Toast;

public class Dialog extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog);
	}
	 private DatePickerDialog.OnDateSetListener myDateListener
	    = new DatePickerDialog.OnDateSetListener() {

	    @Override
	    public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
	       // TODO Auto-generated method stub
	       // arg1 = year
	       // arg2 = month
	       // arg3 = day
	       showDate(arg1, arg2+1, arg3);
	    }
	    };

	    private void showDate(int year, int month, int day) {
	       String s=String.valueOf(new StringBuilder().append(day).append("/")
	       .append(month).append("/").append(year));
	       Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
	    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dialog, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
