package com.example.helloandroid;

import com.example.mywidget.BottomPopupWindow;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class DoorPhoneGuestActivity extends TitleActivity{ 

	
	private Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doorphoneguest);
		setTitle("访客通行证");
		showForwardView(0, false);
		button = (Button)findViewById(R.id.dpsend);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				BottomPopupWindow bottomPopupWindow = new BottomPopupWindow(DoorPhoneGuestActivity.this);
				bottomPopupWindow.showAtLocation(DoorPhoneGuestActivity.this.findViewById(R.id.dpguest),Gravity.BOTTOM, 0,0);			
			}
		});
		
	}
}
