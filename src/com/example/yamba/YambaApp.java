package com.example.yamba;

import winterwell.jtwitter.Twitter;
import android.app.Application;
import android.util.Log;

public class YambaApp  extends Application {
	static final String Tag = "YambaApp" ;
	private Twitter twitter;
	@Override
	public void onCreate() {
		super.onCreate();
		twitter = new Twitter("stdent", "password");
		twitter.setAPIRootUrl("http://yamba.marakana.com/api");
		Log.d(Tag,"onCreated");
	}

	public Twitter getTwitter() {
		return twitter;
	}
	
}
