package com.kgd.zhen.activity;


import com.example.kgd_zhen.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kgd.zhen.bean.JsonBean;
import com.kgd.zhen.tools.PrintTools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	
	private Button btnLogin;
	private EditText edit1;
	private EditText edit2;
	private static final String user="kgd.zhen@gmail.com";
	private static final String pwd="kgd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //        requestWindowFeature(Window.FEATURE_NO_TITLE);// û�б���
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_temp);
        initActivity();
    }
    
    /**
     * 初始化
     */
    private void initActivity()
    {
    	btnLogin = (Button)findViewById(R.id.button1);
    	btnLogin.setOnClickListener(this);
    	
    	edit1 = (EditText)findViewById(R.id.editText1);
    	edit1.addTextChangedListener(textWatcher);
    	edit2 = (EditText)findViewById(R.id.editText2);
    }

    private TextWatcher textWatcher = new TextWatcher() {

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
//			edit1.set
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}  
    	
    };
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId())
		{
			case R.id.button1:
				//TODO handle login
//				testJson();

//				if(login())
				if(true)
				{
//					Intent intent = new Intent(this, ActivityTemp.class);
//					startActivity(intent);	
					Intent intent = new Intent(this, SlidingActivity.class);
					startActivity(intent);
//					Intent intent = new Intent(this, DBActivity.class);
//					startActivity(intent);
				}				
			default:
				break;
		}
		
	}
    
	public boolean login()
	{
		boolean result = false;
		String edit1Value =edit1.getText().toString();
		String edit2Value =edit2.getText().toString();
        if (edit1Value.equals("") || edit1Value.equals(R.string.login_user)) {
            showToastPromopt("�û�����Ϊ�գ�");
            result = false;
        } else if (edit2Value.equals("")||edit2Value.equals(R.string.login_pwd)) {
            showToastPromopt("���벻��Ϊ�գ�");
            result = false;
        }
		if(edit1.getText().equals(user) && edit2.getText().equals(pwd))
		{
			showToastPromopt("��¼�ɹ���");
			result = true;
		}
		return result;
//		return true;
	}
	
    /**
     * ��ʾ�û������ʾ��Ϣ
     */
    public void showToastPromopt(String showText){
        Toast.makeText(this,showText,Toast.LENGTH_SHORT).show();
    }
    
    public void testJson()
    {
    	showToastPromopt("beging parse json file");
		PrintTools print = new PrintTools(this);
		String json = print.getTextFromAssets("test.json");
		
		Gson gson = new Gson();  
//		java.lang.reflect.Type type = new TypeToken<test2Bean>() {}.getType();  
//		test2Bean jsonBean = gson.fromJson(json, type);
		java.lang.reflect.Type type = new TypeToken<JsonBean>() {}.getType();  
		JsonBean jsonBean = gson.fromJson(json, type);
		Log.d("---parse json------------\n",jsonBean.toString());
    }
}
