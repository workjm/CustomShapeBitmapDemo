package com.ape.customshapedemo;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView mOldImage;
	private ImageView mShapeImage;
	private ImageView mNewImage;
	Bitmap shapeBitmap;
	Bitmap oldBitmap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mOldImage = (ImageView)this.findViewById(R.id.old_image);
		mShapeImage = (ImageView)this.findViewById(R.id.shape_image);
		mNewImage = (ImageView)this.findViewById(R.id.new_image);
		oldBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.old);
		shapeBitmap = Utils.getShape(oldBitmap.getWidth(), oldBitmap.getHeight(), this, R.drawable.my_shape);
		
		mNewImage.setImageBitmap(Utils.getShapedBitmap(this, oldBitmap, shapeBitmap, 0));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
