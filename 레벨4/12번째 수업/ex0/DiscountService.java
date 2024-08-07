package enumeration.ex0;

public class DiscountService {
	public int disCount(String grade, int price) {
		
		int discountPercent = 0;
		if(grade.equals("Basic")) {
			discountPercent = 10;
		}else if(grade.equals("Gold")) {
			discountPercent = 20;
		}else if(grade.equals("Diamond")) {
			discountPercent = 30;
		}else {
			System.out.println(grade + ": 할인 X");
		}
		
		return price * discountPercent / 100;
		
		
	}
}
/*
 고객을 3등급로 나누고, 상품 구매시 등급별로 할인을 적용한다. 할인시 소수점 이하는 버린다.
 1. Basic : 10% 할인
 2. Gold : 20% 할인
 3. Diamond : 30% 할인
 회원 등급과 가격을 입력하면 할인 금액을 계산하는 클래스를 만들어보자.
 예를 들어 Gold, 10000원을 입력하면 할인 대상 금액인 2000원을 반환한다.
*/