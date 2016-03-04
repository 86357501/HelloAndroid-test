package com.example.mywidget;

import com.example.helloandroid.DoorPhoneGuestActivity;
import com.example.helloandroid.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class BottomPopupWindow extends PopupWindow {

	private View mMenuView;
	private LinearLayout linearLayout;
	private TextView textview;

	public BottomPopupWindow(Context context) {
		super(context);

		// TODO Auto-generated constructor stub
		mMenuView = LayoutInflater.from(context).inflate(R.layout.bottomsend, null, true);
		linearLayout = (LinearLayout)mMenuView.findViewById(R.id.bottom);
		textview = (TextView) mMenuView.findViewById(R.id.cancel);
		textview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dismiss();

			}
		});

		// 设置SelectPicPopupWindow弹出窗体可点击
		this.setFocusable(true);
		this.setOutsideTouchable(true);
		this.setAnimationStyle(R.style.mypopwindow_anim_style);
		this.setContentView(mMenuView);
		this.setHeight(LayoutParams.MATCH_PARENT);
		this.setWidth(LayoutParams.MATCH_PARENT);
		ColorDrawable dw = new ColorDrawable(0xb0000000);     // 设置弹出窗体的背景    
		this.setBackgroundDrawable(dw);
		mMenuView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				int height = mMenuView.findViewById(R.id.bottom_content).getTop();
				int y = (int) event.getY();
				if (event.getAction() == MotionEvent.ACTION_UP) {
					if (y < height) {
						dismiss();
					}
				}
				return true;
			}
		});
	}
}
