package lang.object;

public class ObjectMain {
	public static void main(String[] args) {
		Child child = new Child();
		child.ChildMethod();
		child.ParentMethod();
		
		// toString() 은 Object 클래스의 메서드
		System.out.println(child.toString());
	}
}
