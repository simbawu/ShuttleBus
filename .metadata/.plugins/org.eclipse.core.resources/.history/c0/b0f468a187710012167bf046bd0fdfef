package com.simba.shuttlebus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ShuttleBusHolder holder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		holder = new ShuttleBusHolder();
		loadData();
		// final TextView tv = (TextView)findViewById(R.id.tvHelloWorld);
		Button btnGoToMart = (Button) findViewById(R.id.btnGoToMart);
		btnGoToMart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				List<ShuttleBus> availableBus = holder.getAvailableBusesGo();
				if (availableBus.size() == 0)
					return;
				ShuttleBus[] busArray = new ShuttleBus[availableBus.size()];
				busArray = (ShuttleBus[]) availableBus.toArray(busArray);
				ArrayAdapter<ShuttleBus> adapter = new ArrayAdapter<ShuttleBus>(
						MainActivity.this, android.R.layout.simple_list_item_1,
						busArray);
				ListView lvBus = (ListView) findViewById(R.id.lvBuses);
				lvBus.setAdapter(adapter);
				lvBus.setOnItemClickListener(mMessageClickedHandler);
			}
		});
	}
	
	private OnItemClickListener mMessageClickedHandler = new OnItemClickListener() {
	    public void onItemClick(AdapterView parent, View v, int position, long id) {
	    	Log.i("String", String.valueOf(position));
	    	Intent intent = new Intent(MainActivity.this, ShowBackActivity.class);
	    	intent.putExtra("bus", String.valueOf(position));
	    	startActivity(intent);
	    }
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private void loadData() {
		laodDataForMall(R.raw.walmark_bus);
		
	}

	private void laodDataForMall(int id) {
		InputStream is = getResources().openRawResource(id);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String lineString = null;
		try {
			while ((lineString = br.readLine()) != null) {
				
				// tv.setText(lineString);
				holder.add(lineString);

			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
