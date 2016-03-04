package com.example.helloandroid;

import android.content.Intent;
import android.os.Bundle;

public class HouseEditActivity extends TitleActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.house_edit);

		Intent intent = getIntent();
		String title = intent.getStringExtra("title");

		setTitle(title);
		showForwardView(0, false);

	}

}
