package com.zaptech.dataoperationpro;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ViewAllActivity extends Activity implements OnClickListener {
	ListView listViewAll;
	Button btnGoBack;
	MyDatabase mdb;

	public ArrayList<MyModel> dataList = new ArrayList<MyModel>();
	public static LayoutInflater inflater;
	MyCustomAdapter customAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_all);
		Intent iGet = getIntent();
		init();
		getData();

		listViewAll.setAdapter(customAdapter);
	}

	public void init() {

		mdb = new MyDatabase(getApplicationContext());
		customAdapter = new MyCustomAdapter(this);
		listViewAll = (ListView) findViewById(R.id.listViewAll);
		btnGoBack = (Button) findViewById(R.id.btnGoBackFromViewAll);

		btnGoBack.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnGoBackFromViewAll:
			Intent iGoBack = new Intent(getApplicationContext(),
					MainActivity.class);
			startActivity(iGoBack);
			break;

		default:
			break;
		}
	}

	public void getData() {
		dataList.clear();
		Cursor c = mdb.getDB()
				.rawQuery("SELECT * FROM " + mdb.TABLE_TEMP, null);
		Log.i("cursor size", " >> " + c.getCount());
		if (c.moveToFirst()) {
			do {
				MyModel model = new MyModel();

				model.setStrName(c.getString(c
						.getColumnIndex(MyDatabase.COL_NAME)));
				model.setAge(Integer.parseInt(c.getString(c
						.getColumnIndex(MyDatabase.COL_AGE))));
				dataList.add(model);
			} while (c.moveToNext());
		}
	}

	public class MyCustomAdapter extends BaseAdapter {

		Context mcontextNew;

		public MyCustomAdapter(Context context) {
			this.mcontextNew = context;
		}

		@Override
		public int getCount() {
			return dataList.size();
		}

		@Override
		public Object getItem(int position) {

			return dataList.get(position);
		}

		@Override
		public long getItemId(int position) {

			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (inflater == null)
				inflater = (LayoutInflater) mcontextNew
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			if (convertView == null)
				convertView = inflater.inflate(R.layout.list_item_raw, null);

			TextView name = (TextView) convertView.findViewById(R.id.tvName);
			TextView age = (TextView) convertView.findViewById(R.id.tvAge);

			name.setText(dataList.get(position).getStrName());
			age.setText(String.valueOf(dataList.get(position).getAge()));

			convertView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

				}
			});

			return convertView;

		}

	}
}
