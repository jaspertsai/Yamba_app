package com.example.yamba;

import java.util.List;

import winterwell.jtwitter.Twitter;
import winterwell.jtwitter.Twitter.Status;
import winterwell.jtwitter.TwitterException;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class UpdaterService extends Service {
	static final String TAG = "UpdaterService";
	static final int DELAY = 30; //in seconds
	Twitter twitter;
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		twitter = new Twitter("stdent", "password");
		twitter.setAPIRootUrl("http://yamba.marakana.com/api");
		Log.d(TAG,"onCreate");
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		new Thread() {
			public void run() {
				try {
					while(true) {
					List<Status> timeline = twitter.getPublicTimeline();

					for (Status status : timeline) {
						Log.d(TAG, String.format("%s:%s", status.user.name,
								status.text));
					}
					Thread.sleep(DELAY*1000);
					}
				} catch (TwitterException e) {
					Log.e(TAG, "Failed because of network error");
				} catch (InterruptedException e) {
					Log.d(TAG,"Updater interrupted", e);
				}
			}
		}.start();
		
		Log.d(TAG, "onStarted");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() { 
		super.onDestroy();
		Log.d(TAG, "onDestroyed");
	}

	

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

}
