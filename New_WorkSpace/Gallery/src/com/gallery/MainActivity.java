package com.gallery;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends Activity {

	Integer[] imageIDs = { R.drawable.one, R.drawable.two, R.drawable.five,
			R.drawable.fore, R.drawable.index, R.drawable.six };
	ImageView selectedImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Gallery gallery = (Gallery) findViewById(R.id.gallery1);
		selectedImage = (ImageView) findViewById(R.id.image1);
		gallery.setSpacing(1);
		gallery.setAdapter(new GalleryImageAdapter(this));

		gallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				selectedImage.setImageResource(imageIDs[position]);

			}
		});

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
			return imageIDs.length;
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

			i.setImageResource(imageIDs[position]);
			i.setLayoutParams(new Gallery.LayoutParams(200, 200));

			i.setScaleType(ImageView.ScaleType.FIT_XY);

			return i;
		}
	}
}
