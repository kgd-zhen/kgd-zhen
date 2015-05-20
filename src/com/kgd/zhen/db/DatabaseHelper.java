package com.kgd.zhen.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String TAG = "database";
    // 数据库版本号
    private static final int DATABASE_VERSION = 1;
    // 数据库名
    private static final String DATABASE_NAME = "zhen.db";
    public final static String DATABSE_TABLE0 = "zhen_user";// 用户表
    // 数据表名
    public static final String TABLE_NAME = "user";
	
	// sql
    private final static String DATABASE_CREATE0 = "create table " + DATABSE_TABLE0 + " (name VARCHAR(32),ename VARCHAR(32),pwd VARCHAR(32),phone VARCHAR(32),email VARCHAR(32),address VARCHAR(100),company VARCHAR(32),qq VARCHAR(32),note VARCHAR(32),reserve VARCHAR(32))";
	
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version, DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);
        // SQLiteOpenHelper的构造函数参数：
        // context：上下文环境
        // name：数据库名字
        // factory：游标工厂（可选）
        // version：数据库模型版本号
	}

    @Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
        // 每次打开数据库之后首先被执行
        Log.d(TAG, "DatabaseHelper onOpen");
	}

	public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        // 数据库实际被创建是在getWritableDatabase()或getReadableDatabase()方法调用时
        Log.d(TAG, "DatabaseHelper Constructor");
        // CursorFactory设置为null,使用系统默认的工厂类
    }
	
 // 继承SQLiteOpenHelper类,必须要覆写的三个方法：onCreate(),onUpgrade(),onOpen()
	@Override
	public void onCreate(SQLiteDatabase db) {
        // 调用时间：数据库第一次创建时onCreate()方法会被调用

        // onCreate方法有一个 SQLiteDatabase对象作为参数，根据需要对这个对象填充表和初始化数据
        // 这个方法中主要完成创建数据库后对数据库的操作

        Log.d(TAG, "DatabaseHelper onCreate");
        
        db.execSQL(DATABASE_CREATE0);
        
        // 构建创建表的SQL语句（可以从SQLite Expert工具的DDL粘贴过来加进StringBuffer中）
        StringBuffer sBuffer = new StringBuffer();

        sBuffer.append("CREATE TABLE [" + TABLE_NAME + "] (");
        sBuffer.append("[_id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sBuffer.append("[name] TEXT,");
        sBuffer.append("[email] TEXT,");
        sBuffer.append("[age] INTEGER,");
        sBuffer.append("[info] TEXT)");

        // 执行创建表的SQL语句
        db.execSQL(sBuffer.toString());

        // 即便程序修改重新运行，只要数据库已经创建过，就不会再进入这个onCreate方法
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
        // 调用时间：如果DATABASE_VERSION值被改为别的数,系统发现现有数据库版本不同,即会调用onUpgrade

        // onUpgrade方法的三个参数，一个 SQLiteDatabase对象，一个旧的版本号和一个新的版本号
        // 这样就可以把一个数据库从旧的模型转变到新的模型
        // 这个方法中主要完成更改数据库版本的操作

        Log.d(TAG, "DatabaseHelper onUpgrade");
        db.execSQL("DROP TABLE IF EXISTS " + DATABSE_TABLE0);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
        // 上述做法简单来说就是，通过检查常量值来决定如何，升级时删除旧表，然后调用onCreate来创建新表
        // 一般在实际项目中是不能这么做的，正确的做法是在更新数据表结构时，还要考虑用户存放于数据库中的数据不丢失
	}
	
	public void insert(SQLiteDatabase db, String sql) {

			db.execSQL(sql);
			System.out.println("插入成功！！");
	}

}
