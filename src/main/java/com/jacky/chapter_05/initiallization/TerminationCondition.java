package com.jacky.chapter_05.initiallization;

class Book {
	boolean checkedOut = false;
	
	public Book(boolean checkOut) {
		this.checkedOut = checkOut;
	}
	
	void checkIn() {
		this.checkedOut = false;
	}
	

	protected void finalize() {
		if (checkedOut)
			System.out.println("Error: checked out");
	}
}

public class TerminationCondition {
	
	public static void main(String[] args) {
		Book novel = new Book(true);
		novel.checkIn();
		new Book(true);
		System.gc();
	}

}
