package com.jacky.interfaces.multi;

interface I1 {
	void f();
}
interface I2 {
	int f(int i);
}
interface I3 {
	int f();
}

class C {
	public int f() {
		return 1;
	}
}

class C2 implements I1, I2 {
	public void f() {}
	
	public int f(int i) {
		return 1;
	}
}

class C3 extends C implements I2 {
	public int f(int i) {
		return 1;
	}
}

class C4 extends C implements I3 {
	/*
	 * 继承关系：
	 * 1、C：public int f()
	 * 2、I3:int f();
	 */
	public int f() {
		System.out.println("C4");
		return 1;
	}
}

class C5 extends C implements I1 {
	/*
	 * 这种继承、实现的方式是有问题的，原因为：
	 * 1、C中有方法：public int f()
	 * 2、I1中有接口：void f();
	 */
}


public class InterfaceCollision {
	public static void main(String[] args) {
		C c1 = new C();
		C2 c2 = new C2();
		C3 c3 = new C3();
		C4 c4 = new C4();

	}
}












