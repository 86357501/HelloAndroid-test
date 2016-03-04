package com.example.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.view.animation.AnimationUtils;

public class SplashActivity extends Activity {
	// 延迟3秒
	private ImageView imageview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

		imageview = (ImageView) findViewById(R.id.imageView1);
		Animation animation = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.alpha);
		animation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				// 使用Handler的postDelayed方法，3秒后执行跳转到MainActivity
				new Handler().post(new Runnable() {
					public void run() {
						goHome();
					}
				});
				
			}
		});
		imageview.setAnimation(animation);
	}

	private void goHome() {
		Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
		startActivity(intent);
		finish();
	}

}
