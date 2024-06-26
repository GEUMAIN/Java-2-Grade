package java_level4.lang.wrapper;

public class AutoboxingMain2 {

	public static void main(String[] args) {
		// Primitive -> Wrapper
		int value = 7;
		Integer boxedValue = value;
		
		// Wrapper -> Primitive
		int unboxedValue = boxedValue;
		
		System.out.println("boxedValue : " + boxedValue);
		System.out.println("unboxedvalue : " + unboxedValue);
	}
}
/*
- 오토 박싱과 오토 언박싱은 컴퍼일러가 개발자 대신 valueOf, xxxValue() 등의 코드를 추가해주는 기능이다.
- 덕분에 깁노형과 래퍼형을 서로 편리하게 변환할 수 있다.
*/