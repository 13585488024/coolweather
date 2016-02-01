package com.cooleweather.db.dao;

import java.util.ArrayList;
import java.util.List;

import com.cooleweather.db.create.CooleatherDB;
import com.cooleweather.model.CityModel;
import com.cooleweather.model.CountyModel;
import com.cooleweather.model.ProvinceModel;
import com.cooleweather.utils.CommonConstant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class CooleatherDao {
	private SQLiteDatabase db;
	private static CooleatherDao cooleatherDB;
	
	
	/**
	 * 创建数据库
	 * @param context
	 */
	private CooleatherDao(Context context){
		CooleatherDB cooleatherDB=new CooleatherDB(context, CommonConstant.DB_NAME, null, CommonConstant.DB_VERSION);
		db=cooleatherDB.getWritableDatabase();
	}
	
	/**
	 * 获取CooleatherDao 实例
	 * @param context
	 * @return
	 */
	public synchronized static CooleatherDao getInstance(Context context){
		if(null == cooleatherDB){
			cooleatherDB=new CooleatherDao(context);
		}
		return cooleatherDB; 
	}
	
	/**
	 * 新增province表数据
	 * @param provinceModel
	 */
	public void saveProvince(ProvinceModel provinceModel){
		if(null != provinceModel){
			ContentValues contentValues=new ContentValues();
			contentValues.put("PROVINCE_NAME", provinceModel.getProvingName());
			contentValues.put("PROVINCE_CODE", provinceModel.getProvingCode());
			db.insert(CommonConstant.DB_TABLE_NAME_PROVINCE, null, contentValues);
		}
	}
	
	/**
	 * 新增City表数据
	 * @param cityModel
	 */
	public void saveCity(CityModel cityModel){
		if(null != cityModel){
			ContentValues contentValues=new ContentValues();
			contentValues.put("CITY_NAME", cityModel.getCityName());
			contentValues.put("CITY_CODE", cityModel.getCityCode());
			contentValues.put("PROVINCE_ID", cityModel.getProvinceId());
			db.insert(CommonConstant.DB_TABLE_NAME_CITY, null, contentValues);
		}
	}
	
	/**
	 * 新增County表数据
	 * @param countyModel
	 */
	public void saveCounty(CountyModel countyModel){
		if(null != countyModel){
			ContentValues contentValues=new ContentValues();
			contentValues.put("COUNTY_NAME", countyModel.getCountyName());
			contentValues.put("COUNTY_CODE", countyModel.getCountyCode());
			contentValues.put("CITY_ID", countyModel.getCityId());
			db.insert(CommonConstant.DB_TABLE_NAME_COUNTY, null, contentValues);
		}
		
	}
	
	/**
	 *   获取省份
	 * @return
	 */
	public List<ProvinceModel> findAllProvinceModels(){
		List<ProvinceModel> pLis=new ArrayList<ProvinceModel>();
		Cursor cursor=db.query(CommonConstant.DB_TABLE_NAME_PROVINCE, null, null, null, null, null, null);
		pLis=mapProvinceModels(cursor);
		return null == pLis || 0>pLis.size() ? null : pLis;
	}
	
	/**
	 * 获取城市
	 * @return
	 */
	public List<CityModel> findAllCutyModels(Integer pId){
		List<CityModel> mList=new ArrayList<CityModel>();
		String[] params=new String[]{String.valueOf(pId)};
		Cursor cursor=db.query(CommonConstant.DB_TABLE_NAME_CITY, null, "PROVINCE_ID=?", params , null, null, null);
		mList=mapCityModels(cursor);
		return null == mList || 0>mList.size() ? null : mList; 
	}
	
	/**
	 * 获取县
	 * @param cId
	 * @return
	 */
	public List<CountyModel> findAllCountyModels(Integer cId){
		List<CountyModel> cList=new ArrayList<CountyModel>();
		String[] params=new String[]{String.valueOf(cId)};
		Cursor c=db.query(CommonConstant.DB_TABLE_NAME_COUNTY, null, "CITY_ID=?", params , null, null, null);
		cList=mapCountyModels(c);
		return null == cList || 0>cList.size() ? null : cList;
	}
	
	
	/**
	 * 映射Province数据到 ProvinceModel实体中
	 * @param c 游标
	 * @return
	 */
	private List<ProvinceModel> mapProvinceModels(Cursor c){
		if(null == c){
			return null;
		}
		List<ProvinceModel> pList=new ArrayList<ProvinceModel>();
		if(c.moveToFirst()){
			do{
				ProvinceModel provinceModel=new ProvinceModel();
				provinceModel.setProvingId(c.getInt(c.getColumnIndex("PROVINCE_ID")));
				provinceModel.setProvingName(c.getString(c.getColumnIndex("PROVINCE_NAME")));
				provinceModel.setProvingCode(c.getString(c.getColumnIndex("PROVINCE_CODE")));
				pList.add(provinceModel);
			}while(c.moveToNext());
		}
		return pList;
	}
	
	/**
	 * 映射City数据到 CityModel实体中
	 * @param c 游标
	 * @return
	 */
	private List<CityModel> mapCityModels(Cursor c){
		if(null == c){
			return null;
		}
		List<CityModel> mList=new ArrayList<CityModel>();
		if(c.moveToFirst()){
			do{
				CityModel cityModel=new CityModel();
				cityModel.setCrtyId(c.getInt(c.getColumnIndex("CITY_ID")));
				cityModel.setCityName(c.getString(c.getColumnIndex("CITY_NAME")));
				cityModel.setCityCode(c.getString(c.getColumnIndex("CITY_CODE")));
				cityModel.setProvinceId(c.getInt(c.getColumnIndex("PROVINCE_ID")));
				mList.add(cityModel);
			}while(c.moveToNext());
		}
		return mList;
	}
	
	/**
	 * 映射County表数据到CountyModel实体中
	 * @param c
	 * @return
	 */
	private List<CountyModel> mapCountyModels(Cursor c){
		if(null == c){
			return null;
		}
		List<CountyModel> mList=new ArrayList<CountyModel>();
		if(c.moveToFirst()){
			do{
				CountyModel countyModel=new CountyModel();
				countyModel.setCountyId(c.getInt(c.getColumnIndex("COUNTY_ID")));
				countyModel.setCountyName(c.getString(c.getColumnIndex("COUNTY_NAME")));
				countyModel.setCountyCode(c.getString(c.getColumnIndex("COUNTY_CODE")));
				countyModel.setCountyId(c.getInt(c.getColumnIndex("CITY_ID")));
				mList.add(countyModel);
			}while(c.moveToNext());
		}
		return mList;
	}
	
}
