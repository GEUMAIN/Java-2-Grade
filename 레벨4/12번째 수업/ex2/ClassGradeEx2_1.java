package enumeration.ex2;

public class ClassGradeEx2_1 {
	public static void main(String[] args) {
		int price = 10000;
		
		DiscountService discountService = new DiscountService();
		int basic = discountService.disCount(ClassGrade.BASIC, price);
		int gold = discountService.disCount(ClassGrade.GOLD, price);
		int diamond = discountService.disCount(ClassGrade.DIAMOND, price);
		
		System.out.println("basic : " + basic);
		System.out.println("gold : " + gold);
		System.out.println("diamond : " + diamond);
	}
}
