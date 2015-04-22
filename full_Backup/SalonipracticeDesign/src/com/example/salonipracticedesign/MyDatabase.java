package com.example.salonipracticedesign;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabase extends SQLiteOpenHelper{
	
	

	// All Static variables
    // Database Version
	
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    public static final String DATABASE_NAME = "New_Database";
 
    // Contacts table name
    public static final String TABLE_CONTACTS = "Test";
 
    // Contacts Table Columns names
  
    public static final String COLUMN_NAME = "Name";
	public static final String COLUMN_LASTNAME = "Lastname";
	public static final String COLUMN_DOB = "DOB";
	public static final String COLUMN_EMAIL = "Email";
	public static final String COLUMN_Blood = "Blood_Group";
	public static final String COLUMN_GENDER = "Gender";
	public static final String COLUMN_PASSWORD = "Password";
	public static final String COLUMN_CONTACT = "Contact";


    SQLiteDatabase db;
    
    
    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		Log.d("MyDatabase", "onCreate called");
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " 
						+ TABLE_CONTACTS + "("
						
						+ COLUMN_NAME +" TEXT,"
						+ COLUMN_EMAIL +" TEXT,"
						+ COLUMN_DOB +" TEXT,"
						+ COLUMN_Blood +" TEXT,"
						+ COLUMN_GENDER + " TEXT,"
						+ COLUMN_PASSWORD +" TEXT,"
						+ COLUMN_CONTACT +" TEXT)";
        db.execSQL(CREATE_CONTACTS_TABLE);
        this.db = db;
	}
	public Cursor getDetails()
	{
	    SQLiteDatabase db = getReadableDatabase();
	    return db.rawQuery("select name from "+TABLE_CONTACTS, null);
	}
	  public SQLiteDatabase getDb(){
			return getWritableDatabase();
		}
	
	public boolean isDBCreated(){
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor c= db.rawQuery("select * from "+TABLE_CONTACTS, null);
		if(c!=null){
			return true;
		}
		return false;
	}
	
	void addContact(String first, String last,String phone,String email,String gen,String dob,String blood,String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, first); // Contact Name
        values.put(COLUMN_CONTACT,phone ); // Contact Phone
        values.put(COLUMN_EMAIL,email );
        values.put(COLUMN_GENDER,gen );
        values.put(COLUMN_DOB,dob );
        values.put(COLUMN_Blood,blood );
        values.put(COLUMN_PASSWORD,pass );
        
        

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        
      //  db.execSQL("DELETE * FROM "+TABLE_CONTACTS);
        db.close(); // Closing database connection
    }
	
	void UpdateContact(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
//        values.put(KEY_PH_NO, "000000000"); // Contact Phone
 
        db.update(TABLE_CONTACTS, values, "name='"+name+"'", null);
        db.close(); // Closing database connection
    }
	
	void deleteContact(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        db.delete(TABLE_CONTACTS, "name='"+name+"'", null);
        db.close(); // Closing database connection
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		//
	}

}
