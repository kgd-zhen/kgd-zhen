package com.kgd.zhen.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.kgd_zhen.R;
import com.kgd.zhen.db.DBManager;
import com.kgd.zhen.db.UserInfo;

import android.app.Activity;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

public class DBActivity extends Activity{
	private DBManager dbManager;
    private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        listView = (ListView) findViewById(R.id.listView);
        // 初始化DBManager
        dbManager = new DBManager(this);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		dbManager.closeDB();// 释放数据库资源
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.layout.activity_db, menu);
//		getMenuInflater().inflate(R.menu.hello_db, menu);
		return true;
//		return super.onCreateOptionsMenu(menu);
	}
    
	
    public void add(View view)
    {
        ArrayList<UserInfo> users = new ArrayList<UserInfo>();

        UserInfo person1 = new UserInfo("Ella", "abc@gmail.com",22, "lively girl");
        UserInfo person2 = new UserInfo("Jenny", "def@gmail.com",22, "beautiful girl");
        UserInfo person3 = new UserInfo("Jessica", "ghi@gmail.com",23, "sexy girl");
        UserInfo person4 = new UserInfo("Kelly", "abc@163.com",23, "hot baby");
        UserInfo person5 = new UserInfo("Jane", "def@163.com",25, "a pretty woman");

        users.add(person1);
        users.add(person2);
        users.add(person3);
        users.add(person4);
        users.add(person5);

        dbManager.add(users);
    }
    
    public void update(View view)
    {
        // 把Jane的年龄改为30（注意更改的是数据库中的值，要查询才能刷新ListView中显示的结果）
        UserInfo person = new UserInfo();
        person.name = "Jane";
        person.age = 30;
        dbManager.updateAge(person);
    }
    
    public void delete(View view)
    {
        // 删除所有三十岁以上的人（此操作在update之后进行，Jane会被删除（因为她的年龄被改为30））
        // 同样是查询才能查看更改结果
        UserInfo person = new UserInfo();
        person.age = 30;
        dbManager.deleteOldPerson(person);
    }
    
    public void query(View view)
    {
        List<UserInfo> persons = dbManager.query();
        ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (UserInfo person : persons)
        {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("name", person.name);
            map.put("info", person.age + " years old, " + person.info);
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list,
                android.R.layout.simple_list_item_2, new String[] { "name",
                        "info" }, new int[] { android.R.id.text1,
                        android.R.id.text2 });
        listView.setAdapter(adapter);
    }
    
    @SuppressWarnings("deprecation")
    public void queryTheCursor(View view)
    {
        Cursor c = dbManager.queryTheCursor();
        startManagingCursor(c); // 托付给activity根据自己的生命周期去管理Cursor的生命周期
        CursorWrapper cursorWrapper = new CursorWrapper(c)
        {
            @Override
            public String getString(int columnIndex)
            {
                // 将简介前加上年龄
                if (getColumnName(columnIndex).equals("info"))
                {
                    int age = getInt(getColumnIndex("age"));
                    return age + " years old, " + super.getString(columnIndex);
                }
                return super.getString(columnIndex);
            }
        };
        // 确保查询结果中有"_id"列
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2, cursorWrapper,
                new String[] { "name", "info" }, new int[] {
                        android.R.id.text1, android.R.id.text2 });
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
    
}
