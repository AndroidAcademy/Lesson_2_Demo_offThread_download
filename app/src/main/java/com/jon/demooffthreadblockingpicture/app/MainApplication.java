package com.jon.demooffthreadblockingpicture.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MainApplication
		extends Application {

	//==============================================
	//              Fields
	//==============================================

	private static Context mAppContext;
	private static Handler mUIhanlder;

	//==============================================
	//              Application Life cycle
	//==============================================

	@Override
	public void onCreate() {
		super.onCreate();

		mAppContext = getApplicationContext();
		mUIhanlder = new Handler();

		// Create global configuration and initialize ImageLoader with this config
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();

		ImageLoader.getInstance()
		           .init(config);
	}

	//==============================================
	//              Getter Method
	//==============================================

	public static Context getAppContext() {
		return mAppContext;
	}

	public static Handler getUIhanlder() {
		return mUIhanlder;
	}
}