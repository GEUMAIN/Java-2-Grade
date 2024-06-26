package java_level4.lang.string;

import java.util.Scanner;

public class test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String answer = sc.next();
		
		char[] userask = answer.toCharArray();
		
		for(int i=0; i<answer.length(); i++) {
			if('a' <= userask[i] && userask[i] <= 'z') {
				userask[i] = (char)('A' + userask[i] - 'a');
			} else {
				userask[i] = (char)('a' + userask[i] - 'A');
			}
		}
		System.out.println(userask);
	}
}
