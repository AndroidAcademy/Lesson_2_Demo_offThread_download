package com.jon.demooffthreadblockingpicture.threads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import android.widget.ImageView;

import com.jon.demooffthreadblockingpicture.app.MainApplication;
import com.nostra13.universalimageloader.core.ImageLoader;

public class CustomThread
		extends Thread {

	//==============================================
	//              Fields
	//==============================================

	private ImageView mIV;

	//==============================================
	//              Constructor
	//==============================================

	public CustomThread(ImageView IV){

		mIV = IV;
	}

	//==============================================
	//              Thread Implementation
	//==============================================

	@Override
	public void run() {

		//Here we perform a blocking operation
		final Bitmap bitmap = ImageLoader.getInstance()
		                           .loadImageSync("http://brilliantwallpapers.net/wp-content/uploads/2015/10/673018_eiffel_tower.jpg");

		MainApplication.getUIhanlder().post(new Runnable() {
			@Override
			public void run() {

				// Should use weakReference but this is not the purpose of the demo
				mIV.setImageBitmap(bitmap);
			}
		});
		super.run();
	}
}
