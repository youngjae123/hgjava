package com.yedam.impl;

public class FlterExe {
	public static void main(String[] args) {
	Flyer flyer = new Airplane();
	//flyer.takeoff();
	
	flyer = new Helocopter();
	//flyer.takeoff();
	
	flyer = new Seaplane();
	
	Driver driver = new Driver();
	driver.drive(flyer);
}
}
