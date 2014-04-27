package com.example.yamba;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.ListView;

public class TimelineActivity extends Activity {
	static final String[] FROM = { StatusData.C_USER, StatusData.C_TEXT, StatusData.C_CREATED_AT};
	static final int[] TO = { R.id.text_user, R.id.text_text, R.id.text_created_at};
	ListView list;
	Cursor cursor;
	SimpleCursorAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timeline);
		
		list = (ListView) findViewById(R.id.list);
		
		cursor = ((YambaApp)getApplication()).statusData.query();
		
		adapter = new SimpleCursorAdapter(this, 
			R.layout.row, cursor, FROM, TO);
		
		list.setAdapter(adapter);
		  
		
		
	}
}
