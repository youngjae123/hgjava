package com.yedam.impl;

public class Airplane implements Flyer {

	@Override
	public void takeoff() {
		System.out.println("[Airplane] - 이륙.");
	}

	@Override
	public void fly() {
		System.out.println("[Airplane] - 비행.");
	}

	@Override
	public void land() {
		System.out.println("[Airplane] - 착륙.");
	}

}
