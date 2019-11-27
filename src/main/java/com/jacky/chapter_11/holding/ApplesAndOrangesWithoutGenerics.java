package com.jacky.chapter_11.holding;

import java.util.ArrayList;

/*
 * 演示不使用泛型，可能产生的程序错误
 */

//定义Apple类，用于创建对象放入容器中
class Apple {
	private static long counter;
	private final long id = counter++;
	
	public long id() {
		return this.id;
	}
}
//定义Orange类，用于创建对象放入容器
class Orange{}


public class ApplesAndOrangesWithoutGenerics {

	public static void main(String[] args) {
		ArrayList apples = new ArrayList();//未使用泛型
		for (int i = 0; i < 3; i++) {
			apples.add(new Apple()); //向ArrayList容器添加Apple对象
		}
		
		apples.add(new Orange());//向ArrayList容器添加Orange对象
		
		for (int i = 0; i < apples.size(); i++) {
			((Apple)apples.get(i)).id();   //编译不会出错，运行会出错
		}

	}

}
