package java_level4.lang.wrapper.test;

public class WrapperTest3 {
	public static void main(String[] args) {
		
		String str = "100";
		
		// String str을 Integer로 변환해서 출력
		// Integer을 int로 변환해서 출력
		// int를 Integer로 변환해서 출력
		
		
		//String -> Integer 박싱
		Integer integer1 = Integer.valueOf(str);
		System.out.println(integer1);
		
		//Integer -> int 오토언박싱
		int intvalue = integer1;
		System.out.println(intvalue);
		
		//int -> Integer 오토박싱
		Integer integer2 = intvalue;
		System.out.println(integer2);
	}
}	
