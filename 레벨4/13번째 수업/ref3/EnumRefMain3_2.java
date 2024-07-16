package enumeration.ref3;

public class EnumRefMain3_2 {
	public static void main(String[] args) {
		int pirce = 10000;
		printDiscount(Grade.BASIC, pirce);
		printDiscount(Grade.GOLD, pirce);
		printDiscount(Grade.DIAMOND, pirce);
	}
	
	private static void printDiscount(Grade grade, int price) {
		System.out.println(grade.name() + " 등급의 할인 금액 : " + grade.discount(price));
	}
}
