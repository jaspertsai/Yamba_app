package com.example.yamba;

import winterwell.jtwitter.Twitter;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class StatusActivity extends Activity {
	EditText editStatus;
	
	/**Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.status);
		
		editStatus = (EditText) findViewById(R.id.edit_status) ;
		
	}

	public void onClick(View v) {
		String statusText = editStatus.getText().toString();
		
		Twitter twitter = new Twitter("student","password") ;
		twitter.setAPIRootUrl("http://yamba.marakana.com/api") ;
		twitter.setStatus(statusText);
		
		Log.d("StatusActivity", "onClicked!:" + statusText) ;
	}
}