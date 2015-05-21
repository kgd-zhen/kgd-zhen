package com.kgd.zhen.activity;

import com.example.kgd_zhen.R;
import com.kgd.zhen.bean.zhen_userBean;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Activity_add_user extends BaseActivity implements OnClickListener {

	private Button btn_cancel;
	private Button btn_ok;
	private EditText et_name;
	private EditText et_Ename;
	private EditText et_email;
	private EditText et_pwd;
	private EditText et_phone;
	private EditText et_address;
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId())
		{
			case R.id.btn_cancel:
				break;
			case R.id.btn_ok :
				doOk();
				break;
		}
		super.onClick(v);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_user);
//		setContentView(R.layout.activity_db);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	private void initView()
	{
		btn_cancel = (Button)findViewById(R.id.btn_cancel);
		btn_ok = (Button)findViewById(R.id.btn_ok);
		et_name = (EditText)findViewById(R.id.et_name);
		et_Ename = (EditText)findViewById(R.id.et_eName);
		et_email = (EditText)findViewById(R.id.et_email);
		et_pwd = (EditText)findViewById(R.id.et_pwd);
		et_phone = (EditText)findViewById(R.id.et_phone);
		et_address = (EditText)findViewById(R.id.et_address);
	}
	private void doOk()
	{
		zhen_userBean userBean = new zhen_userBean();
		userBean.setName(et_name.getText().toString());
		userBean.seteName(et_Ename.getText().toString());
		userBean.setEmail(et_email.getText().toString());
		userBean.setPwd(et_pwd.getText().toString());
		userBean.setPhone(et_phone.getText().toString());
		userBean.setAddress(et_address.getText().toString());
		//TODO insert current userBean
		
		
	}
}
