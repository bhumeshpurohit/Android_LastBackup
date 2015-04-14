package com.zaptech.notification_demo;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	NotificationManager nm;
	Button btnrun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnrun=(Button)findViewById(R.id.btnrun);
        
        
        nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification details=new Notification(R.drawable.ic_launcher,"New Alert,Click mee",System.currentTimeMillis());
        Context c= getApplicationContext();
        CharSequence contentTitle="Notification Details";
        CharSequence contentData="Browse TutorialPoint by Clicking mee";
        Intent notyfyIntent=new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("http://www.tutorialspoint.com/ios/ios_accelerometer.htm"));
        PendingIntent intent =
        	      PendingIntent.getActivity(MainActivity.this, 0,
        	      notyfyIntent, android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
        	details.setLatestEventInfo(c, contentTitle, contentData, intent);
        btnrun.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Notification details=new Notification(R.drawable.ic_launcher,"New Alert,Click mee",System.currentTimeMillis());
				Notification Second=new Notification(R.drawable.ic_launcher,"Second Alert",System.currentTimeMillis());
				
		        Context c= getApplicationContext();
		        CharSequence contentTitle="Notification Details";
		        CharSequence contentData="Browse TutorialPoint by Clicking mee";
		        Intent notyfyIntent=new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("http://www.tutorialspoint.com/ios/ios_accelerometer.htm"));
		        Intent fakeIntent=new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("http://www.zaptechsolutions.com/"));
		        PendingIntent intent =
		        	      PendingIntent.getActivity(MainActivity.this, 0,
		        	      notyfyIntent, android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
		        	details.setLatestEventInfo(c, contentTitle, contentData, intent);
		        	PendingIntent intent2 =
			        	      PendingIntent.getActivity(MainActivity.this, 0,
			        	      fakeIntent, android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
			        	Second.setLatestEventInfo(c, "New Notification", "By Click mee Open Zaptech",intent2);
				nm.notify(1, details);
				nm.notify(2,Second);
			}
		});	
        	  
        	  nm.cancel(1);
    }
}
