package com.jacky.ThinkingInJava;

import java.util.Arrays;
import java.util.Random;


class Bath {
	private String s = "Happy1";
	
//	public Bath() {
//		this.s = "Happy2";
//	}
//	
	@Override
	public String toString() {
		
		return this.s;
	}
}

class Art {
	public Art() {
		System.out.println("Art Constructor.");
	}
}

class Drwaing extends Art{
	private String name;
	
	public Drwaing(String name) {
		this.name = name;
		System.out.println("Drwaint Constructor.");
	}
}

class Cartoon extends Drwaing {
	
	public Cartoon() {
		super("jj");
		System.out.println("Cartoon Constructor.");
	}
}

/**
 * Hello world!
 *
 */
public class App 
{
	enum Color {
		RED("红色", 1), GREEN("绿色", 2), BLUE("蓝色", 3);
		
		private String name;
		private int index;
		
		private Color(String name, int index) {
			this.name = name;
			this.index = index;
		}
	}
	
    public static void main( String[] args )
    {
//    	Random rand = new Random(2);
//       int[] a = new int[ rand.nextInt(20) ];
//       
//       System.out.println(" length of a = " + a.length );
//       
//       System.out.println( Arrays.toString(a) );
    	
//    	Color color = Color.GREEN;   	
//    	System.out.println(color.name);
//    	System.out.println(color.index);
    	
    	Bath bath = new Bath();
    	
    	System.out.println(bath.toString());
    }
}
