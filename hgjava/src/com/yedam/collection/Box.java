package com.yedam.collection;

public class Box<T> {
	T obj;
	
	void setObj(T obj) {
		this.obj = obj;
	}
	T getObj() {
		return obj;
	}
}
