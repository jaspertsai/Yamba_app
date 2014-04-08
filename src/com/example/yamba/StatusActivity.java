package com.example.yamba;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class StatusActivity extends Activity implements OnClickListener{
	Button buttonUpdate;
	EditText editStatus;
	
	/**Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.status);
		
		buttonUpdate = (Button) findViewById(R.id.button_update);
		editStatus = (EditText) findViewById(R.id.edit_status) ;
		
		buttonUpdate.setOnClickListener(this) ;
	}

	public void onClick(View v) {
		String statusText = editStatus.getText().toString();
		Log.d("StatusActivity", "onClicked!:" + statusText) ;
	}
}