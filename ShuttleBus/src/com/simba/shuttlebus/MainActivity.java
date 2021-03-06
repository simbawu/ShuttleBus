package com.simba.shuttlebus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.os.Bundle;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends FragmentActivity implements TimePickerDialog.OnTimeSetListener {
	private ShuttleBusHolder holder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		holder = new ShuttleBusHolder();
		loadData();
		final TextView tvTime= (TextView) findViewById(R.id.tvTime);
		SimpleDateFormat timeFormater=new SimpleDateFormat("HH:mm", Locale.CHINA);
		String now = timeFormater.format(new Date());
		tvTime.setText(now);
		Button btnGoToMart = (Button) findViewById(R.id.btnGoToMart);
		btnGoToMart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				String userTime = tvTime.getText().toString();
				List<ShuttleBus> availableBus = holder.getAvailableBusesGo(userTime);
//				if (availableBus.size() == 0)
//					return;
				final ShuttleBus[] busArray = new ShuttleBus[availableBus.size()];
				availableBus.toArray(busArray);
				ArrayAdapter<ShuttleBus> adapter = new ArrayAdapter<ShuttleBus>(
						MainActivity.this, android.R.layout.simple_list_item_1,
						busArray);
				
				ListView lvBus = (ListView) findViewById(R.id.lvBuses);
				lvBus.setAdapter(adapter);
				lvBus.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int position, long arg3) {
				    	Intent intent = new Intent(MainActivity.this, ShowBackActivity.class);
				    	intent.putExtra("bus", busArray[position]);
				    	startActivity(intent);
						
					}
					
				});
			}
		});
	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private void loadData() {
		laodDataForMall(R.raw.bus_go);

		
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
	public void showTimePickerDialog(View v) {
	    DialogFragment newFragment = new TimePickerFragment();
	    //newFragment.onAttach(activity)
	    newFragment.show(getSupportFragmentManager(), "timePicker");
	}



	@Override
	public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		String userTime = (Integer.toString(hourOfDay).length()==1 ? ("0" + Integer.toString(hourOfDay)) : Integer.toString(hourOfDay))
				+ ":" + (Integer.toString(minute).length()==1 ? ("0" + Integer.toString(minute)) : Integer.toString(minute));
		TextView tvTime= (TextView) findViewById(R.id.tvTime);
		tvTime.setText(userTime);
	}
	
	
}
