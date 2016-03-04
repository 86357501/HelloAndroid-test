package com.example.helloandroid;

import android.app.Application;

public class MyApp extends Application {
	public String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		//setSex("��");
	}
}
