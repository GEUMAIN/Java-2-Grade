package enumeration.ex0;

public class StringGradeEx0_2 {
	public static void main(String[] args) {
		DiscountService dis = new DiscountService();
		int price = 10000;
		
		//존재하지 않는 등급
		int vip = dis.disCount("VIP", price);
		
		System.out.println("VIP : " + vip);
		
		//오타
		int diamond = dis.disCount("DIAMONDD", price);
		
		System.out.println("DIAMOND : " + diamond);
		
		//소문자 입력
		int gold = dis.disCount("gold", price);
		
		System.out.println("GOLD : " + gold);
	}
}

// 단순히 문자열을 입력하는 방식은 ㅇ타가 발생하기 쉽고, 존재하지 않는 값이 입력될 수 있는 문제점이 있다!

//등급에 문자열을 사용하는 위의 방식은 다음과 같은 문제가 있다!
//	- 타입 안정성 부족 : 문자열은 오타가 발생하기 쉽고, 유효하지 않은 값이 입력 될 수 있다.
//	- 데이터 일관성 : "GOLD","gold","Gold" 등 다양한 형식으로 입력할 수 있어 일관성이 떨어진다.
//	- 컴퍼알시 오류 감지 불가 : 이러한 잘못된 값은 컴파일시 감지되지 않고, 런타임에서만 문제가 발견되기 때문에
//	디버깅이 어렵다!