package com.zaptech.new_demo_gallery;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	ImageView Iv;
	Gallery gl;
	Integer imgid[]={R.drawable.apple,R.drawable.lemon,R.drawable.orange,R.drawable.strow};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}
	public void init()
	{
		Iv=(ImageView)findViewById(R.id.imageView1);
		gl=(Gallery)findViewById(R.id.gallery1);
		
		gl.setSpacing(1);
		gl.setAdapter(new  GalleryImageAdapter(this));
		gl.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_LONG).show();
				Iv.setImageResource(imgid[position]);
				
			}
		});
		
		
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

	
		public class GalleryImageAdapter extends BaseAdapter {
		private Context mContext;

		/*private Integer[] mImageIds = { R.drawable.one, R.drawable.two,
				R.drawable.five, R.drawable.fore, R.drawable.index,
				R.drawable.six, };*/

		public GalleryImageAdapter(Context context) {
			mContext = context;
		}

		public int getCount() {
			return imgid.length;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		// Override this method according to your need

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
		
			
			ImageView i = new ImageView(mContext);

			i.setImageResource(imgid[position]);
			i.setLayoutParams(new Gallery.LayoutParams(200, 200));

			i.setScaleType(ImageView.ScaleType.FIT_XY);

			return i;		}
	}


		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
}


