package generics;

public class GenericsMain {
	public static void main(String[] args) {
		Integer[] iArray = {1, 2, 3, 4, 5};
		Double[] dArray = {1.0, 2.0, 3.0, 4.0, 5.0};
		String[] sArray = {"A", "B", "C", "D", "E"};
		
		//재네릭은 래퍼 클래스만 가능하다
		
		printAnyArray(iArray);
		printAnyArray(dArray);
		printAnyArray(sArray);
	}
	
	// 재네릭 메서드 생성
	// T : Type
	// E : Element
	// K : Key
	// V : Value
	
	private static <T> void printAnyArray(T[] Array) {
		for(T t : Array) {
			System.out.print(t + " ");
		}
		System.out.println();
	}
}
