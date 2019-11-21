package com.jacky.ThinkingInJava;

// 基类(含清理方法)
class Shape {
	Shape(int i) {
		System.out.println("Shape constructor");
	}
	void dispose() {
		System.out.println("Shape dispose");
	}
}

// 导出类(继承类基类，同时重写了清理方法dispose()
class Circle extends Shape {
	Circle(int i) {
		super(i);
		System.err.println("Drawing Circle");
	}
	
	void dispose() {
		System.out.println("Erasing Circle");
		super.dispose();
	}
}

public class CADSystem {

}
