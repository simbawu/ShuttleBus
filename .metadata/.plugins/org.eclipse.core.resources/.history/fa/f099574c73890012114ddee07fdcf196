package com.simba.shuttlebus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ShowBackActivity extends Activity {

	private ShuttleBusHolder holder = new ShuttleBusHolder();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_back);
		laodBusReturnData();
		ShuttleBus busToGo = (ShuttleBus)getIntent().getSerializableExtra("bus");
//		TextView tv = (TextView)findViewById(R.id.test);
//		tv.setText(busToGo.toString());
		List<ShuttleBus> busReturn = holder.getBusesByTimeStop(busToGo.getTime(), busToGo.getMallName());
		if (busReturn.size() == 0)
			return;
		final ShuttleBus[] busArray = new ShuttleBus[busReturn.size()];
		busReturn.toArray(busArray);
		ArrayAdapter<ShuttleBus> adapter = new ArrayAdapter<ShuttleBus>(
				ShowBackActivity.this, android.R.layout.simple_list_item_1,
				busArray);
		ListView lvBus = (ListView) findViewById(R.id.lvBusReturn);
		lvBus.setAdapter(adapter);
	}

	private void laodBusReturnData() {
		InputStream is = getResources().openRawResource(R.raw.bus_return);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String lineString = null;
		try {
			while ((lineString = br.readLine()) != null) {
				holder.add(lineString);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_show_back, menu);
		return true;
	}

}
