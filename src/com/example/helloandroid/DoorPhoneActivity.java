package com.example.helloandroid;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.example.mywidget.XCDropDownListView;
import com.example.mywidget.XCDropDownListView.OnOKClickListener;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DoorPhoneActivity extends TitleActivity {
	private ImageView image1;
	private ImageView image2;
	private ImageView image3;
	private ImageView image4;
	private ImageView image5;
	private ImageButton image6;
	private TextView textview;
	private LinearLayout linearlayout;
	XCDropDownListView dropDownListView;
	private ArrayList<String> list;
	private int[] pic;
	private int index = 0;
	
	private SensorManager sensorManager;
	private List<Sensor> sensors;
	private Sensor sensor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doorphone);
		setTitle("手机开门");
		showForwardView(0, false);
		image1 = (ImageView) findViewById(R.id.doorleft);
		image2 = (ImageView) findViewById(R.id.doorright);
		image3 = (ImageView) findViewById(R.id.erweima);
		image4 = (ImageView) findViewById(R.id.leftarrow);
		image5 = (ImageView) findViewById(R.id.rightarrow);
		image6 = (ImageButton) findViewById(R.id.dpguest);
		textview = (TextView) findViewById(R.id.dptextview);

		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		sensors = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
		if(sensors.size()>0)
			sensor = sensors.get(0);
		else
			Toast.makeText(DoorPhoneActivity.this, "no have sensor", Toast.LENGTH_SHORT).show();
		sensorManager.registerListener(new ShakeSensorListener(), sensor, SensorManager.SENSOR_DELAY_GAME);

		linearlayout = (LinearLayout) findViewById(R.id.opendoor);
		linearlayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				DisplayMetrics dm = new DisplayMetrics();
				getWindowManager().getDefaultDisplay().getMetrics(dm);
				Animation translateAnimation1 = new TranslateAnimation(0, -dm.widthPixels / 2, 0, 0);
				translateAnimation1.setDuration(2000);// 设置动画持续时间为3秒
				Animation translateAnimation2 = new TranslateAnimation(0, dm.widthPixels / 2, 0, 0);
				translateAnimation2.setDuration(2000);// 设置动画持续时间为3秒
				image1.startAnimation(translateAnimation1);
				image2.startAnimation(translateAnimation2);

			}
		});
		dropDownListView = (XCDropDownListView) findViewById(R.id.drop_down_list_view);
		list = new ArrayList<String>();
		pic = new int[] { R.drawable.test2w1, R.drawable.test2w2, R.drawable.test2w3 };
		for (int i = 0; i < 16; i++) {
			list.add("下拉列表项" + (i + 1));
		}

		textview.setText(list.get(index).toString());

		dropDownListView.setItemsData(list);
		dropDownListView.setOnClickListener(new OnOKClickListener() {

			@Override
			public void onOKClick(int position) {
				// TODO Auto-generated method stub
				image3.setImageResource(pic[position % 3]);
				textview.setText(list.get(position).toString());
				index = position;
			}
		});

		image4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (--index == -1)
					index = 15;
				image3.setImageResource(pic[index % 3]);
				textview.setText(list.get(index).toString());
				dropDownListView.setEdittext(list.get(index).toString());
			}
		});
		image5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (++index == 16)
					index = 0;
				image3.setImageResource(pic[index % 3]);
				textview.setText(list.get(index).toString());
				dropDownListView.setEdittext(list.get(index).toString());
			}
		});

		image6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DoorPhoneActivity.this, DoorPhoneGuestActivity.class);
				startActivity(intent);
			}
		});
	}

	private class ShakeSensorListener implements SensorEventListener {
		private static final int ACCELERATE_VALUE = 18;

		public void onSensorChanged(SensorEvent event) {

			float[] values = event.values;

			/**
			 * 一般在这三个方向的重力加速度达到20就达到了摇晃手机的状态 x : x轴方向的重力加速度，向右为正 y :
			 * y轴方向的重力加速度，向前为正 z : z轴方向的重力加速度，向上为正
			 */
			float x = Math.abs(values[0]);
			float y = Math.abs(values[1]);
			float z = Math.abs(values[2]);


			if (x >= ACCELERATE_VALUE || y >= ACCELERATE_VALUE || z >= ACCELERATE_VALUE) {

				DisplayMetrics dm = new DisplayMetrics();
				getWindowManager().getDefaultDisplay().getMetrics(dm);
				Animation translateAnimation1 = new TranslateAnimation(0, -dm.widthPixels / 2, 0, 0);
				translateAnimation1.setDuration(2000);// 设置动画持续时间为3秒
				Animation translateAnimation2 = new TranslateAnimation(0, dm.widthPixels / 2, 0, 0);
				translateAnimation2.setDuration(2000);// 设置动画持续时间为3秒
				image1.startAnimation(translateAnimation1);
				image2.startAnimation(translateAnimation2);

			}

		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}


	}
}
