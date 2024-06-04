package lang.object;

public class Child extends Parent{
	public void ChildMethod() {
		System.out.println("Child.childMethod");
	}
}
/*
클래스의 상속 받을 부모 클래스를 명시적으로 지정하면 Object를 상속 받지 않는다.
*/