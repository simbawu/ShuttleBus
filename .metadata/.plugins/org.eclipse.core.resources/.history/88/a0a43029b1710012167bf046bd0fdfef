package com.simba.shuttlebus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class ShuttleBusHolder {
	private List<ShuttleBus> shuttlebuses;

	public List<ShuttleBus> getShuttlebuses() {
		return shuttlebuses;
	}

	public ShuttleBusHolder() {
		super();
		shuttlebuses = new ArrayList<ShuttleBus>();
		
	}
	
	public void add(String shuttleStr){
		String[] shuttleArray = shuttleStr.split(",");
		ShuttleBus shuttleBus = new ShuttleBus();
		shuttleBus.setTime(shuttleArray[0]);
		shuttleBus.setPoint(shuttleArray[1]);
		shuttleBus.setMallName(shuttleArray[2]);
		shuttleBus.setType(shuttleArray[3]);
		shuttlebuses.add(shuttleBus);
	}
	
	public List<ShuttleBus> getAvailableBusesGo(){
		List<ShuttleBus> availableBuses = new ArrayList<ShuttleBus>();
		SimpleDateFormat timeFormater=new SimpleDateFormat("HH:mm", Locale.CHINA);
		String now = timeFormater.format(new Date());
		for (int i = 0; i < shuttlebuses.size(); i++) {
			if(shuttlebuses.get(i).getTime().compareTo(now) > 0 && shuttlebuses.get(i).getType().equals("G")){
				availableBuses.add(shuttlebuses.get(i));
			}
		}
		Collections.sort(availableBuses);
		return availableBuses;
	}
		
	
}
