package com.cooleweather.db.create;


import com.cooleweather.utils.CommonConstant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CooleatherDB extends SQLiteOpenHelper {
	
	public CooleatherDB(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		// TODO Auto-generated method stub
		// 创建数据库
		StringBuffer dbSql=new StringBuffer();
		dbSql=createProvinceInfo();
		sqLiteDatabase.execSQL(dbSql.toString());
		dbSql=createCityInfo();
		sqLiteDatabase.execSQL(dbSql.toString());
		dbSql=createCountyInfo();
		sqLiteDatabase.execSQL(dbSql.toString());
		Log.i(CommonConstant.LOG_TAG, "[Create DB Success。]");
	}	

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	private StringBuffer createProvinceInfo(){
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("create table province(");
		stringBuffer.append("PROVINCE_ID INTEGER primary key autoincrement");
		stringBuffer.append(",PROVINCE_NAME text");
		stringBuffer.append(",PROVINCE_CODE text)");
		return stringBuffer;
		
	}

	private StringBuffer createCityInfo(){
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("create table City(");
		stringBuffer.append("CITY_ID INTEGER primary key autoincrement");
		stringBuffer.append(",CITY_NAME text");
		stringBuffer.append(",CITY_CODE text");
		stringBuffer.append(",PROVINCE_ID INTEGER)");
		return stringBuffer;
		
	}

	private StringBuffer createCountyInfo(){
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("create table County(");
		stringBuffer.append("COUNTY_ID INTEGER primary key autoincrement");
		stringBuffer.append(",COUNTY_NAME text");
		stringBuffer.append(",COUNTY_CODE text");
		stringBuffer.append(",CITY_ID INTEGER)");
		return stringBuffer;
	}
	
	
}
