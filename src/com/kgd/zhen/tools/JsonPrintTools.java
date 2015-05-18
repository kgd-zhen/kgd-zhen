package com.kgd.zhen.tools;

import java.util.HashMap;
import java.util.Vector;


import android.content.Context;

public class JsonPrintTools {

	public Context mContext;
	public HashMap<String,String> HmVarible;
	public Vector<String[]> VecTable;
	public String Templet;
	// 1 模板文件， 2 map数据 ， 3 table 数据集
	// String  HashMap<String,String>  Vector<String[]> vec
	public JsonPrintTools()
	{
		
	}
	public JsonPrintTools(Context context)
	{
		mContext = context;
	}
	
	public byte[] getBytePrint(String templet, HashMap<String, String>hm, Vector<String[]>vec)
	{
		Templet = templet;
		HmVarible = hm;
		VecTable = vec;
		// 解析  Json
		PrintTools print = new PrintTools(mContext);
		String style = print.getTextFromAssets(Templet);
//		JsonParser 
		
		
		
		return null;
	}
}
