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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity {
	private RadioGroup radioGroup;
	private RadioButton radioButton1;
	private RadioButton radioButton2;
	private RadioButton radioButton3;
	private RadioButton radioButton4;
	
	private ContentFragment mWeixin;
	private FriendFragment mFriend;
	private PhoneFragment mPhone;
	private PersonalFragment mPersonal;
	FragmentManager fManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_activity);

		fManager = getFragmentManager();

		// 初始化控件和声明事件
		radioButton1 = (RadioButton) findViewById(R.id.rbChat);
		radioButton2 = (RadioButton) findViewById(R.id.rbAddress);
		radioButton3 = (RadioButton) findViewById(R.id.rbFind);
		radioButton4 = (RadioButton) findViewById(R.id.rbMe);

        Drawable tDrawable = getResources().getDrawable(R.drawable.main_navigation_1);
        tDrawable.setBounds(0, 0, 70, 60);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        radioButton1.setCompoundDrawables(null, tDrawable, null, null);//只放左边
        tDrawable = getResources().getDrawable(R.drawable.main_navigation_2);
        tDrawable.setBounds(0, 0, 40, 60);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        radioButton2.setCompoundDrawables(null, tDrawable, null, null);//只放左边		
        tDrawable = getResources().getDrawable(R.drawable.main_navigation_3);
        tDrawable.setBounds(0, 0, 70, 60);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        radioButton3.setCompoundDrawables(null, tDrawable, null, null);//只放左边		
        tDrawable = getResources().getDrawable(R.drawable.main_navigation_4);
        tDrawable.setBounds(0, 0, 50, 60);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        radioButton4.setCompoundDrawables(null, tDrawable, null, null);//只放左边		
        
		radioGroup = (RadioGroup) findViewById(R.id.tab_menu);
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				// 开启Fragment事务
				FragmentTransaction transaction = fManager.beginTransaction();
				hideFragments(transaction);
				
				switch (checkedId) {
				case R.id.rbChat:
					if (mWeixin == null) {
						mWeixin = new ContentFragment();
						transaction.add(R.id.id_content, mWeixin);
					}
					else{
						transaction.show(mWeixin);  
					}
					
					break;
				case R.id.rbAddress:
					if (mFriend == null) {
						mFriend = new FriendFragment();
						transaction.add(R.id.id_content, mFriend);
					}
					else
						transaction.show(mFriend);  
					break;
				case R.id.rbFind:
					if (mPhone == null) {
						mPhone = new PhoneFragment();
						transaction.add(R.id.id_content, mPhone);
					}
					else
						transaction.show(mPhone); 
					
					break;
				case R.id.rbMe:
					if (mPersonal == null) {
						mPersonal = new PersonalFragment();
						transaction.add(R.id.id_content, mPersonal);
					}
					else
						transaction.show(mPersonal);
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
		setDefaultFragment(fManager);

	}

	protected void hideFragments(FragmentTransaction transaction) {
		// TODO Auto-generated method stub
        if (mWeixin != null) {  
            transaction.hide(mWeixin);  
        }  
        if (mFriend != null) {  
            transaction.hide(mFriend);  
        }  
        if (mPersonal != null) {  
            transaction.hide(mPersonal);  
        }
        if (mPhone != null) {  
            transaction.hide(mPhone);  
        }
	}

	private void setDefaultFragment(FragmentManager fManager) {
		FragmentTransaction transaction = fManager.beginTransaction();
		mWeixin = new ContentFragment();
		transaction.add(R.id.id_content, mWeixin);
		transaction.commit();
	}
}
