package enumeration.ex2;

public class ClassRefMain {
	public static void main(String[] args) {
		System.out.println("class BASIC : " + ClassGrade.BASIC.getClass());
		System.out.println("class GOLD : " + ClassGrade.GOLD.getClass());
		System.out.println("class DIAMOND : " + ClassGrade.DIAMOND.getClass());
		
		System.out.println("ref BASIC = " + ClassGrade.BASIC);
		System.out.println("ref GOLD = " + ClassGrade.GOLD);
		System.out.println("ref DIAMOND = " + ClassGrade.DIAMOND);
		
		// static이므로 애플리케이션 로딩 시점에 3개의 ClassGrade 인스턴스가 샹성되고,
		// 각각의 상수는 ClassGrade 타입의 서로 다른 인스턴스 참조값을 가진다.
	}
}
