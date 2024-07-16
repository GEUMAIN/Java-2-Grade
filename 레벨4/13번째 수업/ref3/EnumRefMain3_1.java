package enumeration.ref3;

public class EnumRefMain3_1 {
	public static void main(String[] args) {
		int pirce = 10000;
		
		System.out.println("BASIC 듭급의 할인 금액 : " + Grade.BASIC.discount(pirce));
		System.out.println("GOLD 듭급의 할인 금액 : " + Grade.GOLD.discount(pirce));
		System.out.println("DIAMOND 듭급의 할인 금액 : " + Grade.DIAMOND.discount(pirce));
	}
}
