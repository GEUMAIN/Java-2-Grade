package enumeration.ex1;

public class StringGradeEx1_2 {
	public static void main(String[] args) {
		int price = 10000;
		
		DiscountService discountService = new DiscountService();
		
		int vip = discountService.disCount("VIP", price);
		
		System.out.println("VIP : " + vip);
		
		//오타
		int diamond = discountService.disCount("DIAMONDD", price);
		
		System.out.println("DIAMOND : " + diamond);
		
		//소문자 입력
		int gold = discountService.disCount("gold", price);
		
		System.out.println("GOLD : " + gold);
	}
}
// 문자열 상수를 사용해도 지금까지 발생한 근본적인 문제들을 해결 할 수 없다.
// 왜냐하면 String 타입은 어떤 문자열이든 입력할 수 있기 때문이다.
// 어떤 개발자가 실수로 StringGrade에 있는 마자열 상수를 사용하지 않고, 위 처럼 직접 문자열을 사용해도
// 막을 수 있는 방법이 없다.
// 사용해야 하는 문자열 상수가 어디에 있는지 discount()를 호출하는 개발자는 알기 어렵다.
