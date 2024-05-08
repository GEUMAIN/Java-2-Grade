package extends1.super2;

public class ClassB extends ClassA{
	
	public ClassB(int a) {
		//super() 사용하면 안 됨.
		// super는 한 번만 사용함.
		this(a, 0); //생략 가능
	}
	
	public ClassB(int a, int b) {
		super(); //생략 가능
		System.out.println("ClassB 생성자 a = " + a + ", b = " + b);
	}
}
