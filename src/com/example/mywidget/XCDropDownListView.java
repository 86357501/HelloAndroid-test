package com.example.mywidget;

import java.util.ArrayList;

import com.example.helloandroid.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
/**
 * 下拉列表框控件
 * 
 * @author caizhiming
 *
 */
public class XCDropDownListView extends LinearLayout implements OnItemClickListener {

	public static interface OnOKClickListener {
		public void onOKClick(int position);
	}

	// 生命接口对象
	private OnOKClickListener mClickListener;
	private TextView editText;
	private PopupWindow popupWindow = null;
	private ArrayList<String> dataList = new ArrayList<String>();
	private View mView;

	public XCDropDownListView(Context context) {
		this(context, null);
		// TODO Auto-generated constructor stub
	}

	public XCDropDownListView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
	}

	public XCDropDownListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		initView();
	}

	public void initView() {
		LayoutInflater layoutInflater;
		layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mView = layoutInflater.inflate(R.layout.dropdownlist_view, this, true);
		editText = (TextView) mView.findViewById(R.id.dptext);
		this.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (popupWindow == null) {
					showPopWindow(editText);
				} else {
					closePopWindow();
				}
			}
		});
	}

	/**
	 * 打开下拉列表弹窗
	 * 
	 * @param view
	 */
	private void showPopWindow(View view) {
		// 加载popupWindow的布局文件
		LayoutInflater layoutInflater;
		layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View contentView = layoutInflater.inflate(R.layout.dropdownlist_popupwindow, null, true);
		ListView listView = (ListView) contentView.findViewById(R.id.dplistview);
		listView.setAdapter(new XCDropDownListAdapter(getContext(), dataList));
		listView.setOnItemClickListener(this);
		popupWindow = new PopupWindow(contentView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		// popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.transparent));
		popupWindow.setOutsideTouchable(true);
		popupWindow.showAsDropDown(view);
		// popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		editText.setText(dataList.get(position).toString());
		closePopWindow();
	     if (this.mClickListener != null) {  
             this.mClickListener.onOKClick(position);  
         }  
	}

	 public void setOnClickListener(final OnOKClickListener clickListener) {  
	        this.mClickListener = clickListener;  
	    }  
	/**
	 * 关闭下拉列表弹窗
	 */
	private void closePopWindow() {
		popupWindow.dismiss();
		popupWindow = null;
	}

	/**
	 * 设置数据
	 * 
	 * @param list
	 */
	public void setItemsData(ArrayList<String> list) {
		dataList = list;
		editText.setText(list.get(0).toString());
	}

	public void setEdittext(String string) {
		editText.setText(string);
	}

	/**
	 * 数据适配器
	 * 
	 * @author caizhiming
	 *
	 */
	class XCDropDownListAdapter extends BaseAdapter {

		Context mContext;
		ArrayList<String> mData;
		LayoutInflater inflater;

		public XCDropDownListAdapter(Context ctx, ArrayList<String> data) {
			mContext = ctx;
			mData = data;
			inflater = LayoutInflater.from(mContext);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mData.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			// 自定义视图
/*			ListItemView listItemView = null;
			if (convertView == null) {
				// 获取list_item布局文件的视图
				convertView = inflater.inflate(R.layout.dropdown_list_item, null);

				listItemView = new ListItemView();
				// 获取控件对象
				listItemView.tv = (TextView) convertView.findViewById(R.id.tv);

				listItemView.layout = (LinearLayout) convertView.findViewById(R.id.layout_container);
				// 设置控件集到convertView
				convertView.setTag(listItemView);
			} else {
				listItemView = (ListItemView) convertView.getTag();
			}

			// 设置数据
			listItemView.tv.setText(mData.get(position).toString());
			final String text = mData.get(position).toString();
			listItemView.layout.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					editText.setText(text);
					closePopWindow();
				}
			});*/
	        if (convertView == null) {  
	        	convertView = inflater.inflate(R.layout.dropdown_list_item, null);  
	        }  
	        TextView text = (TextView) convertView.findViewById(R.id.tv);  
	        text.setText(mData.get(position).toString());  
			return convertView;
		}

	}

/*	private static class ListItemView {
		TextView tv;
		LinearLayout layout;
	}*/

}
