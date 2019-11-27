package com.jacky.chapter_11.holding;

import java.util.ArrayList;

public class ApplesAndOrangesWithGenerics {

	public static void main(String[] args) {
		ArrayList<Apple> apples = new ArrayList<Apple>();   //<Apple>就表示使用了泛型
		
		for (int i = 0; i < 3; i++) {
			apples.add(new Apple());  //添加Apple对象，和泛型指定的一致，编译时通过
		}
		
		//apples.add(new Orange());  //因为使用了泛型，是无法添加不同类型的，编译时不通过

		for (int i = 0; i < apples.size(); i++) {
			System.out.println(apples.get(i).id());  //使用泛型以后，取出数据时就不用进行强制类型转换了
		}
		
		for (Apple c : apples) {
			System.out.println(c.id());  //不用类型转换了，泛型真好用吧
		}
	}

}
