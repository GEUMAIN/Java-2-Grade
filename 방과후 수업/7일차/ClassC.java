package extends1.super2;

public class ClassC extends ClassB{
	//내 부모가 생성자가 없으면 무조건 기본 생성자를 호출해줘야 오류가 안난다.
	
	public ClassC() {
		super(10, 20); //따라서 무조건 super를 써줘야 오류가 안난다.
		System.out.println("ClassC 생성자");
	}
}
