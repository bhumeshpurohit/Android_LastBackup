package com.zaptech.dataoperationpro;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {

	private static final String DATABASE_DBTEMP = "databasetemp.db";
	private static final int DATABASE_VERSION = 1;
	public static final String TABLE_TEMP = "tbTemp";

	public static final String COL_NAME = "Name";
	public static final String COL_AGE = "Age";

	public MyDatabase(Context context) {
		super(context, DATABASE_DBTEMP, null, DATABASE_VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TABLE = "CREATE TABLE " + TABLE_TEMP
				+ "(ID INTEGER PRIMARY KEY, " + COL_NAME + " VARCHAR,"
				+ COL_AGE + " INTEGER)";
		db.execSQL(CREATE_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	public SQLiteDatabase getDB() {
		SQLiteDatabase sdb = getWritableDatabase();
		return sdb;
	}

	public void insertData(String name, int age) {
		SQLiteDatabase db = getDB();
		ContentValues values = new ContentValues();
		values.put(COL_NAME, name);
		values.put(COL_AGE, age);
		db.insert(TABLE_TEMP, null, values);
		db.close();
	}

	public void updateData(String name, int age) {
		SQLiteDatabase db = getDB();
		ContentValues values = new ContentValues();
		values.put(COL_NAME, name);
		db.update(TABLE_TEMP, values, "Age=" + age, null);
		db.close();
	}

	public void deleteData(int age) {
		SQLiteDatabase db = getDB();
		db.delete(TABLE_TEMP, "Age=" + age, null);
		db.close();
	}

	public void deleteAllData() {
		SQLiteDatabase db = getDB();
		db.delete(TABLE_TEMP, null, null);
		db.close();
	}

	// FOR DIAPLAY DATA...in ListView
	public List<String> getDisplayLabels() {
		List<String> labels = new ArrayList<String>();

		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_TEMP;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {

				labels.add("Age : "
						+ cursor.getString(cursor.getColumnIndex(COL_AGE))
						+ "   Name : "
						+ cursor.getString(cursor.getColumnIndex(COL_NAME)));
				// labels.add(cursor.getString(cursor.getColumnIndex(COL_NAME)));
			} while (cursor.moveToNext());
		}

		// closing connection
		cursor.close();
		db.close();

		// returning lables
		return labels;
	}

	// For DELETE and UPDATE...
	public List<String> getLabels() {
		List<String> labels = new ArrayList<String>();

		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_TEMP;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {

				labels.add(cursor.getString(cursor.getColumnIndex(COL_AGE)));

				// labels.add(cursor.getString(cursor.getColumnIndex(COL_NAME)));
			} while (cursor.moveToNext());
		}

		// closing connection
		cursor.close();
		db.close();

		// returning lables
		return labels;
	}

	
}
