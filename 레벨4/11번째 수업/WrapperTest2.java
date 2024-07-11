package java_level4.lang.wrapper.test;

public class WrapperTest2 {
	public static void main(String[] args) {
		
		String[] array = {"1.5", "2.5", "3.0"};
		
		// 배열에 입력된 모든 숫자의 합을 구하시오
		// 숫자는 double 형이 입력될 수 있다.
		
		double num = 0;
		
		for (String s : array) {
			double i = Double.parseDouble(s);
			num += i;
		}
		
		System.out.println(num);
	}
}	
