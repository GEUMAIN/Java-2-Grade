package poly.basic;

public class CastingMain3 {
	public static void main(String[] args) {
		
		Child child = new Child();
		Parent parent1 = (Parent) child; //업캐스팅
		Parent parent2 = child; //압캐스팅은 생략이 가능함.
		
		parent1.parentMethod();
		parent2.parentMethod();
	}
	
}
