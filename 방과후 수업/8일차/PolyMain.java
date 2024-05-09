package poly.basic;

public class PolyMain {
	
	
/*	
1. 객체지향 프로그래밍의 대표적인 특성 : 캡슐화, 상속, 다향성....
2. 다형성은 객체지향 프로그래밍의 꽃이라 불린다.
3. 다향성은 이름 그대로 '다양한 형태','여러 형태'를 뜻한다.
4. 프로그래밍에서 다형성은 한 객체가 여러 타입의 객체로 취급할 수 있ㄴㄴ 능력을 뜻한다.
5. 보통 하나의 객체는 하나의 타입으로 고정되어 있는데 다향성을 사용하면 하나의 객체가 다른 타입으로 사용할 수 있다는 것이다.

다향성 2가지 핷심 여론
1. 다향성 참조
2. 메서드 오버라이딩
	
*/
	
	public static void main(String[] args) {
		//부모 변수가 부모 인서턴스 참조
		System.out.println("Parent -> Parent");
		Parent parent = new Parent();
		parent.parentMethod();
		
		//자식 뱐수가 자식 인스턴스 참조
		System.out.println("Child -> Child");
		Child child = new Child();
		child.parentMethod();
		child.childMethod();
		
		// 부모 변수가 자식 인스턴스 참조(다향성 참조) -> 부모가 자식을 품을 수 있다.
		System.out.println("Parent -> Child");
		Parent poly = new Child();
		poly.parentMethod();
		//poly.childMethod();  자식의 기능은 사용할 수 없다.
		
		//Child child1 = new Parent(); 자식은 부모를 담을 수 없다. 
	}
}
