package java_level4.lang.string;

import java.util.Scanner;

public class test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String answer = sc.next();
		
		String userask = sc.next();
		
		char c;
		char u;
		boolean cheak = true;
		
		int cnt = 0;
		
		for(int i = 0; i < userask.length(); i++) { //0
				u = userask.charAt(i); //x
				
				for(int j = 0; j < answer.length(); j++) { 
					c = answer.charAt(j);
					if(c == u) {
						cheak = false;
						cnt ++;
					}
				}
				if(cheak) {
					cnt++;
				}
		}
		
		System.out.println(cnt);
	}
}
