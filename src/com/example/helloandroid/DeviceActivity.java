package com.example.helloandroid;

import java.util.ArrayList;
import java.util.List;

import com.example.mywidget.MySpinner;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html.ImageGetter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class DeviceActivity extends TitleActivity {

	private MySpinner spinner1;
	private MySpinner spinner2;
	private MySpinner spinner3;
	private ArrayList<String> list = new ArrayList<String>();
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.device_activity);
		setTitle("设备管理");
		showForwardView(R.string.title_random2, true);
		showQR(true);

		list.add("设备类型");
		list.add("消防栓");
		list.add("路灯");
		list.add("随便什么都可以");

		spinner1 = (MySpinner) findViewById(R.id.device_type);
		spinner2 = (MySpinner) findViewById(R.id.device_status);
		spinner3 = (MySpinner) findViewById(R.id.device_maintenance);
		spinner1.setItemsData(list);
		spinner2.setItemsData(list);
		spinner3.setItemsData(list);

	}

	@Override
	protected void onForward(View forwardView) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(DeviceActivity.this, HouseEditActivity.class);
		intent.putExtra("title", "新增设备");
		startActivityForResult(intent, 1);
	}
}
