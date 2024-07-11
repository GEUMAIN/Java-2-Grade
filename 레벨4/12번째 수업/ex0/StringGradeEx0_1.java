package enumeration.ex0;



public class StringGradeEx0_1 {
	public static void main(String[] args) {
		DiscountService dis = new DiscountService();
		int price = 10000;
		
		
		int basic = dis.disCount("BASIC", price);
		
		int gold = dis.disCount("GOLD", price);
		
		int diamond = dis.disCount("DIAMOND", price);
		
		System.out.println("Basic : " + basic);
		System.out.println("Gold : " + gold);
		System.out.println("Diamond : " + diamond);
	}
}
