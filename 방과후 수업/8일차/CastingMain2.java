package poly.basic;

public class CastingMain12 {
	public static void main(String[] args) {
		// 다향적 참조
		Parent poly = new Child();
		
		//poly.childMethod();
		
		//일시적 다운캐스팅(부모타입 -> 자식타입)
		((Child)poly).childMethod();
	}
	
}
