package com.example.salonipracticedesign;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private int year;
	private int month;
	private int day;
	final Calendar c = Calendar.getInstance();

	final Context Context = this;
	private EditText edtName;
	private EditText edtLastName;
	private EditText edtPhone;
	private EditText edtEmail;
	private EditText edtDOB;
	private EditText edtBloodGroup;
	private EditText edtpassword;
	private EditText edtcopassword;
	private Button btnSubmit;
	private Button btnCancel;
	private ImageButton next;
	private RadioGroup rg;
	String gender;
	private String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private String phonePattern = "^[+][0-9]{10,13}$";
	Resources res;
	CalendarView calendar;
	MyDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		res = getResources();
		// String a1 = res.getString(R.string.alertusername);
		 db  = new MyDatabase(this);
	        
	        if(db.isDBCreated()){
	        	Log.e("DatabaseMainActivity", "DBCreated");
	        }

		ImageView hosImage = (ImageView) findViewById(R.id.home_banner);
		hosImage.setBackgroundResource(R.drawable.animationdemo1);
		AnimationDrawable anim = (AnimationDrawable) hosImage.getBackground();
		anim.start();

		init();
		radioButton();

	}

	public void init() {

		edtName = (EditText) findViewById(R.id.username);
		edtLastName = (EditText) findViewById(R.id.lastname);
		edtPhone = (EditText) findViewById(R.id.ContactNumber);
		edtEmail = (EditText) findViewById(R.id.EmailId);
		edtDOB = (EditText) findViewById(R.id.BirthDate);
		edtBloodGroup = (EditText) findViewById(R.id.bloodGroup);
		edtpassword = (EditText) findViewById(R.id.password);
		edtcopassword = (EditText) findViewById(R.id.Confirmpassword);
		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		btnSubmit.setOnClickListener(MainActivity.this);
		btnCancel = (Button) findViewById(R.id.btnCancel);
		btnCancel.setOnClickListener(MainActivity.this);
		next=(ImageButton)findViewById(R.id.info);
		next.setOnClickListener(MainActivity.this);
		rg = (RadioGroup) findViewById(R.id.rggender);

		edtDOB.setOnClickListener(this);
		// final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

		edtDOB.setText(new StringBuilder()
				// Month is 0 based, just add 1
				.append(day).append("-").append(month + 1).append("-")
				.append(year).append(" "));

	}

	protected Dialog onCreateDialog(int id) {

		// open datepicker dialog.
		// set date picker for current date
		// add pickerListener listner to date picker
		return new DatePickerDialog(this, pickerListener, year, month, day);

	}

	private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {

		// when dialog box is closed, below method will be called.
		@Override
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {

			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;

			// Show selected date
			edtDOB.setText(new StringBuilder().append(day).append("-")
					.append(month + 1).append("-").append(year).append(" "));

		}
	};

	public void radioButton() {
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == R.id.radioButtonMale) {
					gender = "Male";
				} else {
					gender = "Female";
				}
			}
		});
	}

	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btnSubmit:
			this.deleteDatabase("Employee.db");
			//alertBox();
			/*db.addContact(edtName.getText().toString(),
					      edtLastName.getText().toString(),
					      edtPhone.getText().toString(),
					      edtEmail.getText().toString(),
					      gender,
					      edtDOB.getText().toString(),
					      edtBloodGroup.getText().toString(),
					      edtpassword.getText().toString()
					      );*/
			
																																																																																																																																																																																																																																																																																																																																																																
			break;
		case R.id.BirthDate:
			showDialog(1);
			break;

		case R.id.btnCancel:
			cancelAlertBox();// call cancel alertbox method
			break;
		case R.id.info:
			Intent i=new Intent(MainActivity.this,detailsActivity.class);
			startActivity(i);
			

			break;
		default:
			break;
		}
	}

	public void alertBox() {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				Context);
		alertDialogBuilder.setTitle("Submit your Data");
		alertDialogBuilder.setMessage("please click ok to save your data");
		alertDialogBuilder.setIcon(R.drawable.ic_launcher);

		alertDialogBuilder.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						// Write your code here to execute after dialog closed
						submitData();

					}
				});

		alertDialogBuilder.show();
	}

	// alert box for cancel button
	public void cancelAlertBox() {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				Context);
		alertDialogBuilder.setTitle("Are you sure to cancel???");
		alertDialogBuilder.setMessage("please click oK");
		alertDialogBuilder.setIcon(R.drawable.ic_launcher);

		alertDialogBuilder.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						onClear(); // call onClear method
						Toast.makeText(getApplicationContext(),
								"You data is canceled", Toast.LENGTH_SHORT)
								.show();
					}
				});

		alertDialogBuilder.show();
	}

	

	public void submitData() {
		if (edtName.getText().toString().trim().length() < 1) {
			Toast.makeText(this, res.getString(R.string.alertusername),
					Toast.LENGTH_SHORT).show();
		} else if (edtLastName.getText().toString().trim().length() < 1) {
			Toast.makeText(this, res.getString(R.string.alertlastname),
					Toast.LENGTH_SHORT).show();
		} else if (edtPhone.getText().toString().trim().length() < 1) {
			Toast.makeText(this, res.getString(R.string.alertphone),
					Toast.LENGTH_SHORT).show();
		} else if (edtEmail.getText().toString().trim().length() < 1) {
			Toast.makeText(this, res.getString(R.string.alertemail),
					Toast.LENGTH_SHORT).show();
		} else if (edtBloodGroup.getText().toString().trim().length() < 1) {
			Toast.makeText(this, res.getString(R.string.alertbloodgroup),
					Toast.LENGTH_SHORT).show();
		} else if (!edtEmail.getText().toString().matches(emailPattern)) {
			Toast.makeText(this, "InValid Email", Toast.LENGTH_SHORT).show();

		} else if (!edtPhone.getText().toString().matches(phonePattern)) {
			Toast.makeText(this, "InValid Phone Number", Toast.LENGTH_SHORT)
					.show();
		} else if (edtDOB.getText().toString().trim().length() < 1) {
			Toast.makeText(this, res.getString(R.string.alertDOB),
					Toast.LENGTH_SHORT).show();
		} else if (edtpassword.getText().toString().trim().length() < 1) {
			Toast.makeText(this, res.getString(R.string.alertpassword),
					Toast.LENGTH_SHORT).show();
		} else if (edtcopassword.getText().toString().trim().length() < 1) {
			Toast.makeText(this, res.getString(R.string.alertcopassword),
					Toast.LENGTH_SHORT).show();
		} else if (!edtpassword.getText().toString()
				.equals(edtcopassword.getText().toString())) {
			Toast.makeText(this, "your Password does not match",
					Toast.LENGTH_SHORT).show();

		} else {
			Intent myIntent = new Intent(MainActivity.this,
					detailsActivity.class);
			myIntent.putExtra("USERNAME", edtName.getText().toString());
			myIntent.putExtra("LASTNAME", edtLastName.getText().toString());
			myIntent.putExtra("PHONE", edtPhone.getText().toString());
			myIntent.putExtra("EMAILID", edtEmail.getText().toString());
			myIntent.putExtra("DOB", edtDOB.getText().toString());
			myIntent.putExtra("BLOODGROUP", edtBloodGroup.getText().toString());
			myIntent.putExtra("PASSWORD", edtBloodGroup.getText().toString());
			myIntent.putExtra("CONFIRM_PASSWORD", edtBloodGroup.getText()
					.toString());
			myIntent.putExtra("GENDER", gender);
			startActivity(myIntent);
			Toast.makeText(getApplicationContext(),
					"You data is successfully submited", Toast.LENGTH_SHORT)
					.show();
		}
	}

	// clear data of form

	public void onClear() {
		if (edtName != null)
			edtName.setText("");
		if (edtLastName != null)
			edtLastName.setText("");
		if (edtPhone != null)
			edtPhone.setText("");
		if (edtEmail != null)
			edtEmail.setText("");
		if (edtDOB != null)
			edtDOB.setText("");
		if (edtBloodGroup != null)
			edtBloodGroup.setText("");
		if (edtpassword != null)
			edtpassword.setText("");
		if (edtcopassword != null)
			edtcopassword.setText("");
		rg.clearCheck();// for clear radio button
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.main, menu);
	// return true;
	// }
	//
	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// // Handle action bar item clicks here. The action bar will
	// // automatically handle clicks on the Home/Up button, so long
	// // as you specify a parent activity in AndroidManifest.xml.
	// int id = item.getItemId();
	// if (id == R.id.action_settings) {
	// return true;
	// }
	// return super.onOptionsItemSelected(item);

}
