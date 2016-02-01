package com.cooleweather.activity;

import com.cooleweather.utils.CommonConstant;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		Log.i(CommonConstant.LOG_TAG,"[当前在:]"+ getClass().getSimpleName()+" 中");
	
	}
	
}
