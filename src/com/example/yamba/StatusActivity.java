package com.example.yamba;

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
		
		Log.d(TAG, "onCLick with Bundle: " + bundle) ;
		
		setContentView(R.layout.status);
		
		editStatus = (EditText) findViewById(R.id.edit_status) ;
		
	}

	public void onClick(View v) {
		String statusText = editStatus.getText().toString();
		
		Log.d(TAG, "onClicked!:" + statusText) ;
	}
}