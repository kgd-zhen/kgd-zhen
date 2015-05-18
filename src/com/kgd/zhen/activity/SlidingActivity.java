/*
 * Copyright (C) 2012 yueyueniao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kgd.zhen.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

import com.example.kgd_zhen.R;
import com.kgd.zhen.fragment.LeftFragment;
import com.kgd.zhen.fragment.RightFragment;
import com.kgd.zhen.fragment.ViewPageFragment;
import com.kgd.zhen.fragment.ViewPageFragment.MyPageChangeListener;
import com.kgd.zhen.view.SlidingMenu;

public class SlidingActivity extends FragmentActivity{
	SlidingMenu mSlidingMenu;
	LeftFragment leftFragment;
	RightFragment rightFragment;
	ViewPageFragment viewPageFragment;
    public static final String TAG= SlidingActivity.class.getName();
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		// 去掉窗口标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.slide_menu_main);
        Log.d(TAG,"onCreate---init---initListener----");
		init();
		initListener();

	}

	private void init() {
		mSlidingMenu = (SlidingMenu) findViewById(R.id.slidingMenu);
		mSlidingMenu.setLeftView(getLayoutInflater().inflate(
				R.layout.slide_menu_left_frame, null));
		mSlidingMenu.setRightView(getLayoutInflater().inflate(
				R.layout.slide_menu_right_frame, null));
		mSlidingMenu.setCenterView(getLayoutInflater().inflate(
				R.layout.slide_menu_center_frame, null));

		FragmentTransaction t = this.getSupportFragmentManager()
				.beginTransaction();
		leftFragment = new LeftFragment();
		t.replace(R.id.left_frame, leftFragment);

		rightFragment = new RightFragment();
		t.replace(R.id.right_frame, rightFragment);

		viewPageFragment = new ViewPageFragment();
		t.replace(R.id.center_frame, viewPageFragment);
		t.commit();
	}

	private void initListener() {
		viewPageFragment.setMyPageChangeListener(new MyPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				if(viewPageFragment.isFirst()){
					mSlidingMenu.setCanSliding(true,false);
				}else if(viewPageFragment.isEnd()){
					mSlidingMenu.setCanSliding(false,true);
				}else{
					mSlidingMenu.setCanSliding(false,false);
				}
			}
		});
	}

	public void showLeft() {
		mSlidingMenu.showLeftView();
	}

	public void showRight() {
		mSlidingMenu.showRightView();
	}

}
