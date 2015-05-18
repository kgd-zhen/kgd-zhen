package com.kgd.zhen.activity;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

//import com.lidroid.xutils.ViewUtils;
public class BaseActivity extends Activity implements OnClickListener {

	public void showToast(String str) {
		Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	}

//	public void initViewUtils(Activity activity) {
//		ViewUtils.inject(activity);
//	}

	@Override
	protected void onDestroy() {
		System.out.println("回收内存");
		System.gc();
		System.out.println("回收完成");
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
