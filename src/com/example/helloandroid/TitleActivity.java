package com.example.helloandroid;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class TitleActivity extends Activity {

	private TextView mTitleTextView;
	private ImageButton mBackwardbButton;
	private Button mButtonRadom;
	private FrameLayout mContentLayout;
	private ImageButton qr_code;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setupViews();
	}

	private void setupViews() {
		super.setContentView(R.layout.title_activity);
		mTitleTextView = (TextView) findViewById(R.id.title_text);
		mContentLayout = (FrameLayout) findViewById(R.id.layout_content);
		qr_code = (ImageButton)findViewById(R.id.qr_code);
		qr_code.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				qrDetect(v);
			}
		});
		mBackwardbButton = (ImageButton) findViewById(R.id.button_backward);
		mBackwardbButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackward(v);
			}
		});
		mButtonRadom = (Button) findViewById(R.id.button_random);
		mButtonRadom.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				onForward(v);
			}

		});
	}
	
	
    protected void qrDetect(View v) {
		// TODO Auto-generated method stub
    	Toast.makeText(this, "二维码扫描", Toast.LENGTH_SHORT).show();
	}

	/**
     * 返回按钮点击后触发
     * @param backwardView
     */
    protected void onBackward(View backwardView) {
        finish();
    }
 
    /**
     * 提交按钮点击后触发
     * @param forwardView
     */
    protected void onForward(View forwardView) {
        Toast.makeText(this, "点击提交", Toast.LENGTH_SHORT).show();
    }
	/**
	 * 是否显示返回按钮
	 * 
	 * @param backwardResid
	 *            文字
	 * @param show
	 *            true则显示
	 */
	protected void showBackwardView(boolean show) {
		if (mBackwardbButton != null) {
			if (show) {
				mBackwardbButton.setVisibility(View.VISIBLE);
			} else {
				mBackwardbButton.setVisibility(View.INVISIBLE);
			}
		} // else ignored
	}

	/**
	 * 提供是否显示右边按钮
	 * 
	 * @param forwardResId
	 *            文字
	 * @param show
	 *            true则显示
	 */
	protected void showQR(boolean show) {
		if (qr_code != null) {
			if (show) {
				qr_code.setVisibility(View.VISIBLE);
			} else {
				qr_code.setVisibility(View.INVISIBLE);
			}
		} // else ignored
	}
	/**
	 * 提供是否显示右边按钮
	 * 
	 * @param forwardResId
	 *            文字
	 * @param show
	 *            true则显示
	 */
	protected void showForwardView(int forwardResId, boolean show) {
		if (mButtonRadom != null) {
			if (show) {
				mButtonRadom.setVisibility(View.VISIBLE);
				mButtonRadom.setText(forwardResId);
			} else {
				mButtonRadom.setVisibility(View.INVISIBLE);
			}
		} // else ignored
	}
	// 设置标题内容
	@Override
	public void setTitle(int titleId) {
		mTitleTextView.setText(titleId);
	}

	// 设置标题内容
	@Override
	public void setTitle(CharSequence title) {
		mTitleTextView.setText(title);
	}

	// 设置标题文字颜色
	@Override
	public void setTitleColor(int textColor) {
		mTitleTextView.setTextColor(textColor);
	}

	// 取出FrameLayout并调用父类removeAllViews()方法
	@Override
	public void setContentView(int layoutResID) {
		mContentLayout.removeAllViews();
		View.inflate(this, layoutResID, mContentLayout);
		onContentChanged();
	}

	@Override
	public void setContentView(View view) {
		mContentLayout.removeAllViews();
		mContentLayout.addView(view);
		onContentChanged();
	}

	@Override
	public void setContentView(View view, LayoutParams params) {
		mContentLayout.removeAllViews();
		mContentLayout.addView(view, params);
		onContentChanged();
	}
}
