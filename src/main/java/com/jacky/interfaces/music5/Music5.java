package com.jacky.interfaces.music5;

import com.jacky.ThinkingInJava.Note;

interface Instrument {
	int VALUE = 5;    // static & final
	
	void play(Note n);// Automatically public
	void adjust();
}

class Wind implements Instrument {

	@Override
	public void play(Note n) {
		System.out.println(this + ".play() " + n);
		
	}

	public String toString() {
		return "Wind";
	}
	
	@Override
	public void adjust() {
		System.out.println(this + ".adjust()");
		
	}
	
}


class Percussion implements Instrument {

	@Override
	public void play(Note n) {
		System.out.println(this + ".play() " + n);
		
	}
	
	public String toString() {
		return "Percussion";
	}

	@Override
	public void adjust() {
		System.out.println(this + ".adjust() ");
		
	}
	
}


class Stringed implements Instrument {

	@Override
	public void play(Note n) {
		System.out.println(this + ".play() " + n);
		
	}
	
	public String toString() {
		return "Stringed";
	}

	@Override
	public void adjust() {
		System.out.println(this + ".adjust()");
		
	}
	
}

class Brass extends Wind {
	public String toString() {
		return "Brass";
	}
}


class Woodwind extends Wind {
	public String toString() {
		return "Woodwind";
	}
}

public class Music5 {
	static void tune(Instrument i) {
		i.play(Note.MIDDLE_C);
	}
	
	static void tuneAll(Instrument[] e) {
		for (Instrument i : e) {
			tune(i);
		}
	}
	
	public static void main(String[] args) {
		Instrument[] orchestra = {
				new Wind(),
				new Percussion(),
				new Stringed(),
				new Brass(),
				new Woodwind()
		};
		
		tuneAll(orchestra);
	}
}







