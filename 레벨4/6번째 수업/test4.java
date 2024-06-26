package java_level4.lang.string;

import java.util.Scanner;

public class test4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String doc = sc.nextLine();
		String ward = sc.nextLine();
		
		int startidx = 0;
		int cnt = 0;
		
		while(true) {
			//indexOf() : 특정 문자나 문자열이 옆에서부터 처음 발견되는 인덱스를 반환하며
			// 만약 찾지 못한다면 -1을 반환한다
			int findIdx = doc.indexOf(ward,startidx);
			
			if(findIdx < 0 ) {
				break;
			}
			
			startidx = findIdx + ward.length();
			cnt++;
		}
		System.out.println(cnt);
	}
}
