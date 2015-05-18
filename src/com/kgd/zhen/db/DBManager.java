package com.kgd.zhen.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBManager {
	public static final String TAG = "DBManager"; 
	private DatabaseHelper helper;
	private SQLiteDatabase 	db;
	
	public DBManager(Context context)
	{
		Log.d(TAG, "DBManager()");
		helper = new DatabaseHelper(context);
        // 因为getWritableDatabase内部调用了mContext.openOrCreateDatabase(mName, 0,
        // mFactory);
        // 所以要确保context已初始化,我们可以把实例化DBManager的步骤放在Activity的onCreate里
        db = helper.getWritableDatabase();
	}
	
	
    /**
     * add user
     * 
     * @param user
     */
    public void add(List<UserInfo> users)
    {
        Log.d(TAG, "DBManager --> add");
        // 采用事务处理，确保数据完整性
        db.beginTransaction(); // 开始事务
        try
        {
            for (UserInfo user : users)
            {
                db.execSQL("INSERT INTO " + DatabaseHelper.TABLE_NAME
                        + " VALUES(null, ?, ?, ?, ?)", new Object[] { user.name,
                        user.email, user.age, user.info });
                // 带两个参数的execSQL()方法，采用占位符参数？，把参数值放在后面，顺序对应
                // 一个参数的execSQL()方法中，用户输入特殊字符时需要转义
                // 使用占位符有效区分了这种情况
            }
            db.setTransactionSuccessful(); // 设置事务成功完成
        }
        finally
        {
            db.endTransaction(); // 结束事务
        }
    }
	
	
    /**
     * update user's age
     * 
     * @param person
     */
    public void updateAge(UserInfo user)
    {
        Log.d(TAG, "DBManager --> updateAge");
        ContentValues cv = new ContentValues();
        cv.put("age", user.age);
        db.update(DatabaseHelper.TABLE_NAME, cv, "name = ?",
                new String[] { user.name });
    }
	
    /**
     * delete user
     * 
     * @param user
     */
    public void deleteOldPerson(UserInfo user)
    {
        Log.d(TAG, "DBManager --> deleteOldPerson");
        db.delete(DatabaseHelper.TABLE_NAME, "age >= ?",
                new String[] { String.valueOf(user.age) });
    }

    /**
     * query all users, return list
     * 
     * @return List<Person>
     */
    public List<UserInfo> query()
    {
        Log.d(TAG, "DBManager --> query");
        ArrayList<UserInfo> persons = new ArrayList<UserInfo>();
        Cursor c = queryTheCursor();
        while (c.moveToNext())
        {
            UserInfo user = new UserInfo();
            user._id = c.getInt(c.getColumnIndex("_id"));
            user.name = c.getString(c.getColumnIndex("name"));
            user.email = c.getString(c.getColumnIndex("email"));
            user.age = c.getInt(c.getColumnIndex("age"));
            user.info = c.getString(c.getColumnIndex("info"));
            persons.add(user);
        }
        c.close();
        return persons;
    }
	
    /**
     * query all persons, return cursor
     * 
     * @return Cursor
     */
    public Cursor queryTheCursor()
    {
        Log.d(TAG, "DBManager --> queryTheCursor");
        Cursor c = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME,
                null);
        return c;
    }
	
    /**
     * close database
     */
    public void closeDB()
    {
        Log.d(TAG, "DBManager --> closeDB");
        // 释放数据库资源
        db.close();
    }
	
}
