package com.example.fragment;

import com.example.helloandroid.DeviceActivity;
import com.example.helloandroid.DoorPhoneActivity;
import com.example.helloandroid.HouseActivity;
import com.example.helloandroid.LoginActivity;
import com.example.helloandroid.MainActivity;
import com.example.helloandroid.R;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class ContentFragment extends Fragment implements OnClickListener {

	private ImageButton ImageButton1;
	private ImageButton ImageButton2;
	private ImageButton ImageButton3;
	private ImageButton ImageButton4;
	private ImageButton ImageButton5;
	private ImageButton ImageButton6;
	private ImageButton ImageButton7;
	private ImageButton ImageButton8;
	private ImageButton ImageButton9;
	private ImageButton ImageButton10;
	private ImageButton ImageButton11;
	private ImageButton ImageButton12;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_content, container, false);

		ImageButton1 = (ImageButton) view.findViewById(R.id.icon1);
		ImageButton1.setOnClickListener(this);
		ImageButton2 = (ImageButton) view.findViewById(R.id.icon2);
		ImageButton2.setOnClickListener(this);
		ImageButton3 = (ImageButton) view.findViewById(R.id.icon3);
		ImageButton3.setOnClickListener(this);
		ImageButton4 = (ImageButton) view.findViewById(R.id.icon4);
		ImageButton4.setOnClickListener(this);
		ImageButton5 = (ImageButton) view.findViewById(R.id.icon5);
		ImageButton5.setOnClickListener(this);
		ImageButton6 = (ImageButton) view.findViewById(R.id.icon6);
		ImageButton6.setOnClickListener(this);
		ImageButton7 = (ImageButton) view.findViewById(R.id.icon7);
		ImageButton7.setOnClickListener(this);
		ImageButton8 = (ImageButton) view.findViewById(R.id.icon8);
		ImageButton8.setOnClickListener(this);
		ImageButton9 = (ImageButton) view.findViewById(R.id.icon9);
		ImageButton9.setOnClickListener(this);
		ImageButton10 = (ImageButton) view.findViewById(R.id.icona);
		ImageButton10.setOnClickListener(this);
		ImageButton11 = (ImageButton) view.findViewById(R.id.iconb);
		ImageButton11.setOnClickListener(this);
		ImageButton12 = (ImageButton) view.findViewById(R.id.iconc);
		ImageButton12.setOnClickListener(this);

		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.icon1:
			Intent intent = new Intent(getActivity(), HouseActivity.class);
			startActivity(intent); 
			break;
		case R.id.icon2:
			Intent intent2 = new Intent(getActivity(), DeviceActivity.class);
			startActivity(intent2); 
			break;
		case R.id.icon3:
			break;
		case R.id.icon4:
			break;
		case R.id.icon5:
			break;
		case R.id.icon6:
			break;
		case R.id.icon7:
			break;
		case R.id.icon8:
			Intent intent8 = new Intent(getActivity(), DoorPhoneActivity.class);
			startActivity(intent8); 
			break;
		case R.id.icon9:
			break;
		case R.id.icona:
			break;
		case R.id.iconb:
			break;
		case R.id.iconc:
			break;

		default:
			break;

		}

	}
}
