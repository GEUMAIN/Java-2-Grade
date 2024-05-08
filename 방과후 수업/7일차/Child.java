package extends1.super1;

public class Child extends Parent{
	public String value = "child";
	
	@Override
	public void hello() {
		System.out.println("child.hello");
	}
	
	public void call() {
		System.err.println("자식의 값: "+ this.value); // this는 생략 가능
		System.out.println("부모의 값: " + super.value);
		
		this.hello(); //this는 생략 가능
		super.hello(); 
	}
}
