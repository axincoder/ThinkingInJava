package com.jacky.ThinkingInJava;

class Variable {
	static final int i = 0;
	
	static final int j;
	static {
		j = 0;
	}
}

class Variable2 {
	final int i = 0;
	
	final int j;
	public Variable2() {
		j = 0;
	}
	
	final int k;
	{
		k = 0;
	}
	
}


public class Final {

	public static void main(String[] args) {
		
	}

}
