package com.jacky.ThinkingInJava;

// 基类中定义了两个名称相同，但是参数列表不同的方法（多态）
class Homer {
	char doh(char c) {
		System.out.println("doh(char)");
		return 'd';
	}
	
	float doh(float f) {
		System.out.println("doh(float)");
		return 1.0f;
	}
}

class MilHouse {}

class Bart extends Homer {
	// 继承了基类，同时又增加了一个名称相同，参数列表不同的方法
	// 到这个时候，doh方法就有了三个不同形式的参数列表了，也就是三个不同的方法
	//注意：这里是不可以使用@override，基类中没有相同的方法（返回值、方法名、参数列表都相同）
	void doh(MilHouse m) {
		System.out.println("doh(MilHouse)");
	}
	
	//这里可以使用@override，因为基类中有相同的方法（返回值、方法名、参数列表都相同），因此可以重载
	@Override
	char doh(char x) {
		System.out.println("doh(char)-@override");
		return 'x';
	}
}

public class Hide {
	final int b;
	final String k;
	
	public Hide(int b) {
		this.b = b;
		this.k = "hello";
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bart b = new Bart();
		
		b.doh(1);
		b.doh('x');
		b.doh(1.0f);
		b.doh(new MilHouse());

	}
}
