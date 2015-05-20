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
package com.kgd.zhen.fragment;

import com.example.kgd_zhen.R;
import com.kgd.zhen.activity.SlidingActivity;
import com.kgd.zhen.activity.Activity_add_user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;



public class LeftFragment extends Fragment {

	public TextView tv_myTask;
	public Context mContext;
	public LeftFragment(Context context)
	{
		mContext = context;
	}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.slide_menu_left, null);
		tv_myTask = (TextView)view.findViewById(R.id.my_question_textview);
		tv_myTask.setOnClickListener(left_listener);
		return view;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	
	OnClickListener left_listener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()){
			case R.id.my_question_textview:
				Log.d("LeftFragment","----onClick --- my_task--");
				System.out.print("--System.out.print--onClick --- my_task--");
				Intent intent = new Intent(mContext,Activity_add_user.class);
				startActivity(intent);
				break;
			default:
				break;
			}
		}
		
	};

}
