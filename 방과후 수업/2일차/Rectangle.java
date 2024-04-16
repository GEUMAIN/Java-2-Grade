package oop.exam;

public class Rectangle {
	int widths;
	int height;
	boolean square;
	
	public void area() {
		System.out.println("넓이 : " + (widths * height));
	}
	
	public void round() {
		System.out.println("둘레 : " + ((widths * 2) + (height * 2)));
	}
	public void realsquare() {
		if(widths == height) {
			square = true;
			if(square) System.out.println("정사각형입니다.");
		}else {
			square = false;
			System.out.println("정사각형 아닙니다.");
		}
	}
}
