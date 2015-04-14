package com.example.salonipracticedesign;
import java.util.ArrayList;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class detailsActivity extends ListActivity
{
    ListView l;
    MyDatabase db;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // String data[]={};
        //int i=0;
        //db.disp();
/*        ArrayList<String> list = new ArrayList<String>();
        l=(ListView)findViewById(R.id.listView1);
        Cursor c = db.getDb().rawQuery("SELECT * FROM " + MyDatabase.TABLE_CONTACTS,null);
        
       if(c.moveToFirst()){
     	   do {
     		  list.add(c.getString(c.getColumnIndex(MyDatabase.COLUMN_NAME)));
     			data[i] = c.getString(c.getColumnIndex(MyDatabase.COLUMN_Id));
     		 data[i] = c.getString(c.getColumnIndex(MyDatabase.COLUMN_NAME));
     		data[i] = c.getString(c.getColumnIndex(MyDatabase.COLUMN_EMAIL));
     		data[i] = c.getString(c.getColumnIndex(MyDatabase.COLUMN_GENDER));
     		data[i] = c.getString(c.getColumnIndex(MyDatabase.COLUMN_DOB));
     		data[i] = c.getString(c.getColumnIndex(MyDatabase.COLUMN_CONTACT));
     		data[i] = c.getString(c.getColumnIndex(MyDatabase.COLUMN_Blood));
     		data[i] = c.getString(c.getColumnIndex(MyDatabase.COLUMN_PASSWORD));
     			
     			//i++;
     			
     		} while (c.moveToNext());
        }
        
        for (int j = 0; j < data.length; ++j) {
            list.add(data[i]);
          }
        
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);
            l.setAdapter(adapter);
        if (!c.isClosed()) 
        { 
            c.close();
        }

        }
    
  */
    } 
}