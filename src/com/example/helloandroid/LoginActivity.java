package com.example.helloandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	private EditText userName, password;
	private SharedPreferences sp;
	private Editor ed;
	private Button btn_login;
	private static final String TAG = "LoginActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.login);


		sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
		ed = sp.edit();
		userName = (EditText) findViewById(R.id.et_zh);
		password = (EditText) findViewById(R.id.et_mima);
		btn_login = (Button) findViewById(R.id.btn_login);

        Drawable tDrawable = getResources().getDrawable(R.drawable.ic_login_02);
        tDrawable.setBounds(10, 0, 60, 50);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        userName.setCompoundDrawables(tDrawable, null, null, null);//只放左边
        tDrawable = getResources().getDrawable(R.drawable.ic_login_03);
        tDrawable.setBounds(10, 0, 60, 50);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        password.setCompoundDrawables(tDrawable, null, null, null);//只放左边
        
		if (sp.contains("NOFIRST")) {
			if (sp.getString("USER", "").equals("admin") && sp.getString("PSWD", "").equals("admin")) {
				Intent intent = new Intent(LoginActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			} else
				userName.setText(sp.getString("USER", ""));
		} else {
			ed.putBoolean("NOFIRST", true);
			ed.commit();
		}

		btn_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(TAG, ".............");
				String userNameValue, passWordValue;
				userNameValue = userName.getText().toString();
				passWordValue = password.getText().toString();
				if (userNameValue.equals("admin") && passWordValue.equals("admin")) {
					ed.putString("USER", userNameValue);
					ed.putString("PSWD", passWordValue);
					ed.commit();
					String test = sp.getString("USER", "");
					Log.i(TAG, test+".....");
					Intent intent = new Intent(LoginActivity.this, MainActivity.class);
					startActivity(intent);
					finish();
				} else {
					ed.putString("USER", userNameValue);
					ed.commit();
					Toast.makeText(LoginActivity.this, "用户名或密码错误，请重新登录", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
}
