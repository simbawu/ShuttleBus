package com.simba.shuttlebus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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
	
	public List<ShuttleBus> getAvailableBusesGo(String time){
		List<ShuttleBus> availableBuses = new ArrayList<ShuttleBus>();
//		SimpleDateFormat timeFormater=new SimpleDateFormat("HH:mm", Locale.CHINA);
//		String now = timeFormater.format(new Date());
		for (int i = 0; i < shuttlebuses.size(); i++) {
			if(shuttlebuses.get(i).getTime().compareTo(time) > 0){
				availableBuses.add(shuttlebuses.get(i));
			}
		}
		Collections.sort(availableBuses);
		return availableBuses;
	}
	
	public List<ShuttleBus> getBusesByTimeStop(String timeStr, String stop){
		List<ShuttleBus> availableBuses = new ArrayList<ShuttleBus>();
		for (int i = 0; i < shuttlebuses.size(); i++) {
			if(shuttlebuses.get(i).getTime().compareTo(timeStr) > 0 && shuttlebuses.get(i).getPoint().equals(stop)){
				availableBuses.add(shuttlebuses.get(i));
			}
		}
		Collections.sort(availableBuses);
		return availableBuses;
	}
		
	
}
