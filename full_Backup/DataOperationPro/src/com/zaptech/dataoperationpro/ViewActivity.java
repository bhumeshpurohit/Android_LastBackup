package com.zaptech.dataoperationpro;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ViewActivity extends Activity implements OnClickListener {
	MyDatabase mdb;
	EditText edAge;
	Button btnSearch, btnGoBack;
	TextView tvSearch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_view);
		init();
	}

	public void init() {
		mdb = new MyDatabase(this);
		btnSearch = (Button) findViewById(R.id.btnSearch);
		btnGoBack = (Button) findViewById(R.id.btnGoBackFromSearch);
		edAge = (EditText) findViewById(R.id.edAge);
		tvSearch = (TextView) findViewById(R.id.tvViewData);

		btnGoBack.setOnClickListener(this);
		btnSearch.setOnClickListener(this);
	}

	public void searchData() {
		StringBuffer str = new StringBuffer();
		String sqlSearch = "SELECT * FROM " + MyDatabase.TABLE_TEMP
				+ " WHERE Name=?"+ new String[]{edAge.getText().toString()};
		/*Cursor c = mdb.getDB().rawQuery(sqlSearch, null);

		if (c.moveToFirst()) {
			do {
				str.append(c.getString(c.getColumnIndex(MyDatabase.COL_NAME)));
			} while (c.moveToNext());

		}
*/		tvSearch.setText(str.toString());
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnSearch:
			searchData();
			break;
		case R.id.btnGoBackFromSearch:

			break;

		default:
			break;
		}

	}
}
