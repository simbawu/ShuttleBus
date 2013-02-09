package com.simba.shuttlebus;

import java.io.Serializable;

public class ShuttleBus implements Serializable, Comparable<ShuttleBus>{

	private static final long serialVersionUID = 5821146057457384635L;
	private String time;
	private String point;
	private String mallName;
	public String getMallName() {
		return mallName;
	}
	public void setMallName(String mallName) {
		this.mallName = mallName;
	}
	private String type;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return time + ":" + point + "->" + mallName + " (" + type + ")";
	}
	@Override
	public int compareTo(ShuttleBus another) {
		return this.time.compareTo(another.getTime());
	}
	
	
}
