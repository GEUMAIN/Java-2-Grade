package poly.basic;

public class CastingMain5 {
	// 다운캐스팅은 잘못하면 심각한 런타임 오류가 발생할 수 있다.
	
	public static void main(String[] args) {
		Parent parent1 = new Parent();
		System.out.println("parent 호출");
		
		call(parent1);
		
		Parent parent2 = new Child();
		System.out.println("parent2 호출");
		
		call(parent2);
		
		
	}
	
	private static void call(Parent parent) { //개발자가 쓸거라 private
		parent.parentMethod();
		if(parent instanceof Child) { //Child를 참조하고 있으면 true 아니면 false
			System.out.println("Child 인스턴스 맞음");
			((Child)parent).childMethod();
		}
	}
	
	/*
	 지금처럼 다운캐스팅을 수행하기 전에 먼저 instanceof를 사용해서 원하는 타입으로 변경이 가능한지
	 확인한 다음에 다운캐스팅을 수행하는 것이 안전하다.
	 
	 참고로 instanceof 키워드는 오른쪽 대상의 자식 타입을 왼쪽에 참조하는 경우에도 true를 반환한다.
	 
	 예)
	 parent instanceof Parent 당연히 true
	 
	 new Parent() instanceof Parent : 당연히 true
	 
	 new Child() instanceof Parent : true
	 
	 new Parent() instanceof Parent
	 Parent p = new Parent() : true
	 
	 new Child() instatnceof Parent 
	 Parent p = new Child() : true
	 
	 new Parent() instanceof Child
	 Child c = new Parent() : false
	*/
}
