package com.Demo.database_demo;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener 
{

	EditText etname,etno;
	Button ins,upd,del,nex;
	SQLiteDatabase mdaDatabase;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}
    public void init()
    {
    	etname=(EditText)findViewById(R.id.etname);
    	etno=(EditText)findViewById(R.id.etno);
    	ins=(Button)findViewById(R.id.btn1);
    	upd=(Button)findViewById(R.id.btn2);
    	del=(Button)findViewById(R.id.btn3);
    	nex=(Button)findViewById(R.id.btn4);
    	
    	ins.setOnClickListener(this);
    	upd.setOnClickListener(this);
    	del.setOnClickListener(this);
    	nex.setOnClickListener(this);
    	mdaDatabase= openOrCreateDatabase("diary",MODE_PRIVATE,null);
    	
    	
    }
    @Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
    	switch (v.getId()) {
		case R.id.btn1:
			insert(mdaDatabase);
			break;
		case R.id.btn2:
			update(mdaDatabase);
			break;
		case R.id.btn3:
			delete(mdaDatabase);
			break;
				
		case R.id.btn4:
			next(mdaDatabase);
			break;
		
		default:
			break;
		}
		
	}
    
    public void insert(SQLiteDatabase mdaDatabase)
    {
    	ContentValues contentValues = new ContentValues();

        contentValues.put("name", etname.getText().toString());
        contentValues.put("phone",etno.getText().toString());
       

       mdaDatabase.insert("contacts", null, contentValues);
    }

    public void update(SQLiteDatabase mdaDatabase)
    {
    	
    }
    

    public void delete(SQLiteDatabase mdaDatabase)
    {
    	
    }
    

    public void next(SQLiteDatabase mdaDatabase)
    {
    	Intent i=new Intent(MainActivity.this,Second.class);
    	startActivity(i);
    	
    }
    
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
