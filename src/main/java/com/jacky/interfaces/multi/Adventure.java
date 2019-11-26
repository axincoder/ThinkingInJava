package com.jacky.interfaces.multi;

/*
 * 定义三个接口
 */
interface CanFight {
	void fight();
};

interface CanSwim {
	void swim();
}

interface CanFly {
	void fly();
}

/*
 * 定义一个类，这个类有fight()方法的实现
 */
class ActionCharacter {
	public void fight() {
	}
}

/*
 * 定义一个类，继承ActionCharacter，实现CanFight、CanSwim、CanFly
 */
class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly {

	@Override
	public void fly() {
		// TODO Auto-generated method stub
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
	}

	/*
	 * 三个接口，有三个需要实现的方法，但Hero实现了两个即可，因为有一个被其基类ActionCharacter实现
	 */

}

public class Adventure {
	
	public static void t(CanFight x) {
		x.fight();
	}
	public static void u(CanSwim x) {
		x.swim();
	}
	public static void v(CanFly x) {
		x.fly();
	}
	public static void w(ActionCharacter x) {
		x.fight();
	}

	public static void main(String[] args) {
		Hero h = new Hero();
		
		t(h);
		u(h);
		v(h);
		w(h);

	}

}























