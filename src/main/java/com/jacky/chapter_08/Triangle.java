package com.jacky.chapter_08;

public class Triangle extends Shape {
	@Override
	public void draw() {
		System.out.println("Triangel.draw()");
	}
	
	@Override
	public void erase() {
		System.out.println("Triangle.erase()");
	}
}
