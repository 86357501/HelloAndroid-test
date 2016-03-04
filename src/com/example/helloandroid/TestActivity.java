package com.example.helloandroid;

import com.example.fragment.ContentFragment;
import com.example.fragment.FriendFragment;
import com.example.fragment.PersonalFragment;
import com.example.fragment.PhoneFragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class TestActivity extends Activity {
	private RadioGroup radioGroup;

	
	private ContentFragment mWeixin;
	private FriendFragment mFriend;
	private PhoneFragment mPhone;
	private PersonalFragment mPersonal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_activity);

		// 初始化控件和声明事件       
		radioGroup = (RadioGroup) findViewById(R.id.tab_menu);
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				FragmentManager fm = getFragmentManager();
				// 开启Fragment事务
				FragmentTransaction transaction = fm.beginTransaction();

				switch (checkedId) {
				case R.id.rbChat:
					if (mWeixin == null) {
						mWeixin = new ContentFragment();
					}
					// 使用当前Fragment的布局替代id_content的控件
					transaction.replace(R.id.id_content, mWeixin);
					break;
				case R.id.rbAddress:
					if (mFriend == null) {
						mFriend = new FriendFragment();
					}
					transaction.replace(R.id.id_content, mFriend);
					break;
				case R.id.rbFind:
					if (mPhone == null) {
						mPhone = new PhoneFragment();
					}
					transaction.replace(R.id.id_content, mPhone);
					break;
				case R.id.rbMe:
					if (mPersonal == null) {
						mPersonal = new PersonalFragment();
					}
					transaction.replace(R.id.id_content, mPersonal);
					break;
				default:
					break;
				}
				// transaction.addToBackStack();
				// 事务提交
				transaction.commit();
			}
		});

		// 设置默认的Fragment
		setDefaultFragment();

	}

	private void setDefaultFragment() {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		mWeixin = new ContentFragment();
		transaction.add(R.id.id_content, mWeixin);
		transaction.commit();
	}
}
