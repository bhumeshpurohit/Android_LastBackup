package com.zaptech.demo_banner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;

public class Register extends Activity {
	Button btnsubmit,btnreset;
	EditText etfirst,etlast,etmail,etpass1,etpass2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		etfirst=(EditText)findViewById(R.id.username);
		etlast=(EditText)findViewById(R.id.lastName);
		etmail=(EditText)findViewById(R.id.emailId);
		etpass1=(EditText)findViewById(R.id.password);
		etpass2=(EditText)findViewById(R.id.confirmPassword);
		btnsubmit=(Button) findViewById(R.id.submit);
	     btnreset=(Button) findViewById(R.id.cancel);
		
		
	
		        
		        
		        btnsubmit.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if(!etpass1.getText().toString().equals(etpass2.getText().toString()))
						{
							etpass2.setError("Password not match");
						}
						else
						{
						Intent i=new Intent(Register.this,Home.class);
						
						startActivity(i);
						}
					}
				});
		   	 btnreset.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
					
						etfirst.setText("");
						etlast.setText("");
						etmail.setText("");
						etpass1.setText("");
						etpass2.setText("");
					}
				});
	}
}
