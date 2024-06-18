package java_level4.lang.string;

public class StringComparisonMain {
	//문자열 비교
	public static void main(String[] args) {
		String str1 = "Hello, Java";
		String str2 = "hello, java";
		String str3 = "Hello, World";
		
		System.out.println("str1 equals str2 : " + str1.equals(str2)); //false
		System.out.println("str1 equalsIgnoreCase str2 : " + str1.equalsIgnoreCase(str2)); //대소문자 무시
		System.out.println("'d' compareTo 'a' : " + "d".compareTo("a")); //사전 순 비교 (a : 1 b : 2 ...)
		System.out.println("str1 compareTo str2 : " + str1.compareTo(str2));
		System.out.println("str1 compareToIgnoreCase str2 : " + str1.compareToIgnoreCase(str2)); //대소문자 무시
		System.out.println("str1 starts with 'Hello' : " + str1.startsWith("Hello"));
		System.out.println("str1 ends with 'Java' : " + str1.endsWith("Java"));
	} 
}
