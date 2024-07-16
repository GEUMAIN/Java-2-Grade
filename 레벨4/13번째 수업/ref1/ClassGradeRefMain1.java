package enumeration.ref1;

public class ClassGradeRefMain1 {
	public static void main(String[] args) {
		int pirce = 10000;
		DiscountService discountService = new DiscountService();
		
		int basic = discountService.discount(ClassGrade.BASIC, pirce);
		
		System.out.println("BASIC : " + basic);
	}
}
