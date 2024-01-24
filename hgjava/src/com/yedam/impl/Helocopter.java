package com.yedam.impl;

public class Helocopter extends Airplane {
	@Override
	public void takeoff() {
		System.out.println("[Helocopter] - 이륙");
	}
	
	@Override
	public void fly() {
		System.out.println("[Helocopter] - 비행");
	}
	@Override
	public void land() {
		System.out.println("[Helocopter] - 착륙");
	}
}
