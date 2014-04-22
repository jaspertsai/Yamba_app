package com.example.yamba;

import winterwell.jtwitter.Twitter;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.PreferenceManager;
import android.util.Log;

public class YambaApp  extends Application implements OnSharedPreferenceChangeListener {
	static final String TAG = "YambaApp" ;
	private Twitter twitter;
	SharedPreferences prefs;
	StatusData statusData;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		
		//Prefs stuff
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		prefs.registerOnSharedPreferenceChangeListener(this);
	
		statusData = new StatusData(this);
		
		Log.d(TAG,"onCreated");
	}

	public Twitter getTwitter() {
		if(twitter==null) {
			//Twitter stuff
			prefs = PreferenceManager.getDefaultSharedPreferences(this);
			String username = prefs.getString("username", "");
			String password = prefs.getString("password", "");
			String server = prefs.getString("server", "");
			twitter = new Twitter(username, password);
			twitter.setAPIRootUrl(server);
			
		}
		return twitter;
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
		twitter=null;
		this.prefs = prefs;
		
		Log.d(TAG, "onSharedPreferenceChanged for key: "  +key);
		
	}
	
}
