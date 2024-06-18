package java_level4.lang.string;

public class StringInfoMain {
	//문자열의 정보 조회
	public static void main(String[] args) {
		
		String str = "Hello. Java!";
		
		System.out.println("문자열의 길이 : " + str.length()); //공백 포함
		System.out.println("문자열이 비어있는지 : " + str.isEmpty());
		System.out.println("문자열이 비어있거나 공백인지1 : " + str.isBlank()); //자바 11 이상
		System.out.println("문자열이 비어있거나 공백인지2 : " + " ".isBlank());
		
		char c = str.charAt(7); //문자열의 7번 인덱스
		
		System.out.println("8번째 인덱스의 문자 : " + c); //공백 포함
	}
}
