package com.yedam.classes.abstracts;

public class AnimalExe {
	public static void main(String[] args) {
		
		Animal animal = null; // new Animal()
		animal = new Bird("제비");
		animal.eat();
		animal.sleep();
		Bird bird = new Bird("참새");
		bird.eat();
		bird.sleep();
		
		Dog dog = new Dog();
		
		Bird[] birds = new Bird[5];
//		birds[0] = dog;
		
		Animal[] animals = new Animal[10];
		animals[0] = bird;
		animals[1] = dog;
		
	}
}
