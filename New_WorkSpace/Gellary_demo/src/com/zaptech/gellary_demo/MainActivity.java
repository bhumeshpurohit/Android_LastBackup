package com.zaptech.gellary_demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	private void processGallery() {
		 adapter = new MyAdapter(this, containers, appName);
		 if (adapter != null) {
		  gallery.setAdapter(adapter);
		 }
		}

		@Override
		public void onItemClick(final AdapterView<?> adapterView, final View view, final int position, final long id) {
		 if (containers != null) {
		  container = containers.get(position);
		  if (container != null) {
		   // Handle selected image
		  }
		 }
		}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
