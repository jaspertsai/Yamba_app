package com.example.yamba;

import winterwell.jtwitter.Twitter;
import winterwell.jtwitter.TwitterException;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
		
		new PostToTwitter().execute(statusText);
		
		Log.d(TAG, "onClicked!:" + statusText) ;
	}
	
	class PostToTwitter extends AsyncTask<String, Void, String> {

		/*New thread*/
		@Override
		protected String doInBackground(String... params) {
			try {
				Twitter twitter = new Twitter("student", "password");
				twitter.setAPIRootUrl("http://yamba.marakana.com/api");
				twitter.setStatus(params[0]);
				Log.d(TAG, "Sucessfully posted: "+params[0]);
				return "Sucessfully posted: " +params[0];
			} catch (TwitterException e) {
				Log.e(TAG,"Died", e);
				e.printStackTrace();
				return "Failed posting: " +params[0];

			}
		}
		
		/*UI Thread*/
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			Toast.makeText(StatusActivity.this, 
					"Sucessfully posted: " +result, 
					Toast.LENGTH_LONG).show();
		}
		
	}
	
}