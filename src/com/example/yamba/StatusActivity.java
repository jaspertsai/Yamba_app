package com.example.yamba;

import winterwell.jtwitter.Twitter;
import winterwell.jtwitter.TwitterException;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class StatusActivity extends Activity {
	static final String TAG = "StatusActivity";
	EditText editStatus;
	
	/**Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		
		Log.d(TAG, "onCreated with Bundle: " + bundle) ;
		
		setContentView(R.layout.status);
		
		editStatus = (EditText) findViewById(R.id.edit_status) ;
		
	}

	public void onClick(View v) {
		final String statusText = editStatus.getText().toString();
		
		new Thread() {
			public void run() {
				try {
					Twitter twitter = new Twitter("student", "password");
					twitter.setAPIRootUrl("http://yamba.marakana.com/api");
					twitter.setStatus(statusText);
				} catch (TwitterException e) {
					Log.e(TAG,"Died", e);
					e.printStackTrace();
				}
			}
		}.start();
		Log.d(TAG, "onClicked!:" + statusText) ;
	}
}