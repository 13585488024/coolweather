package com.cooleweather.activity;

import com.cooleweather.R;
import com.cooleweather.R.layout;
import com.cooleweather.R.menu;
import com.cooleweather.db.create.CooleatherDB;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Menu;
import android.view.Window;

public class MainActivity extends BaseActivity {
	private SQLiteOpenHelper openHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
