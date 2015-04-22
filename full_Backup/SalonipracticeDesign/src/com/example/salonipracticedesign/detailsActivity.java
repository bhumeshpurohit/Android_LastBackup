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
    MyDatabase myDb;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // String data[]={};
        //int i=0;
        //db.disp();
        l=(ListView)findViewById(R.id.listView1);
        
        ArrayList<String> itemList = new ArrayList<String>();
		Cursor fetchData = myDb.getDb().rawQuery("SELECT * FROM " + MyDatabase.TABLE_CONTACTS, null);
		if (fetchData.moveToFirst()) {
			do {
				itemList.add(fetchData.getString(fetchData
						.getColumnIndex(MyDatabase.COLUMN_NAME)));
						/*+ fetchData.getString(fetchData
								.getColumnIndex(MyDatabase.Name))
						+ fetchData.getString(fetchData
								.getColumnIndex(MyDatabase.Mark)));*/
			} while (fetchData.moveToNext());
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, itemList);
			l.setAdapter(adapter);
		}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*ArrayList<String> itemlist = new ArrayList<String>();
       
       
        Cursor cur = mydb.getDb().rawQuery("SELECT * FROM Trainee", null);*/
        /*
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
        }*/

        }
    
  
    } 
//}