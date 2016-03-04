/**
 * 
 */
package com.example.helloandroid;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.content.Intent;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

/**
 * @author Administrator
 *
 */
public class HouseActivity extends TitleActivity {

	private EditText editText;
	private ListView listview;
	private TextView textView;
	ArrayList<HashMap<String, String>> list = null;
	HashMap<String, String> map = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.house_activity);

		setTitle("信息维护");
		showForwardView(R.string.title_random1, true);
		listview = (ListView) findViewById(R.id.mylistview);
		textView = (TextView) findViewById(R.id.mytextview);
		editText = (EditText) findViewById(R.id.house_search);
		editText.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				// TODO Auto-generated method stub
				if (actionId == EditorInfo.IME_ACTION_DONE
						|| (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
					if (editText.getText().toString().equals("5200")) {
						listview.setVisibility(View.VISIBLE);
						textView.setVisibility(View.INVISIBLE);
						list = new ArrayList<HashMap<String, String>>();
						for (int i = 1; i < 4; i++) {
							map = new HashMap<String, String>();
							map.put("number", i + ".");
							map.put("id", "5200");
							map.put("type", "一室一厅");
							map.put("high", "3楼");
							map.put("area", "50平");
							map.put("who", "王尼玛、王妮美");
							map.put("addr", "襄阳大道55号六栋301室");
							list.add(map);
						}
						SimpleAdapter adapter = new SimpleAdapter(HouseActivity.this, list, R.layout.list_item_house,
								new String[] { "number", "id", "type", "who", "area", "high", "addr" },
								new int[] { R.id.house_number, R.id.house_id, R.id.house_type, R.id.house_who,
										R.id.house_area, R.id.house_high, R.id.house_address });

						listview.setAdapter(adapter);
						listview.setOnItemClickListener(new OnItemClickListener() {
							public void onItemClick(android.widget.AdapterView<?> parent, View view, int position, long id) {
								Intent intent = new Intent(HouseActivity.this, HouseEditActivity.class);
								intent.putExtra("title", "修改房产");
								startActivityForResult(intent, 2);
							};
						});
					}
					else{
						textView.setVisibility(View.VISIBLE);
						listview.setVisibility(View.INVISIBLE);
						textView.setText("查询失败！");
					}
					return true;
				} else
					return false;
			}
		});

	}
	
	@Override
	protected void onForward(View forwardView) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(HouseActivity.this, HouseEditActivity.class);
		intent.putExtra("title", "新增房产");
		startActivityForResult(intent, 1);
	}

}
