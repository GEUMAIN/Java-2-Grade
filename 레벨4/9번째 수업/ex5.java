package java_level4.lang.wrapper.ex;

import java.util.*;

public class ex5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] alphabat = new int[26];
		
		while(N-- > 0) {
			// 단어를 문자 배열로 변환
			char[] word = sc.next().toCharArray();
			//자릿수를 나타내는 변수를 선언하고 초기값으로 1을 할당
			int placeValue = 1;
			
			//단어를 끝에서부터 시작하여 각 문자의 가치를 개선
			
			for(int i = word.length - 1; i >= 0; i--) {
				alphabat[word[i] - 'A'] = alphabat[word[i] - 'A'] + placeValue;
				placeValue *= 10;
			}
			
		}
		// 알파벳의 값을 오름차순으로 정렬
		Arrays.sort(alphabat);
		
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			ans = ans + alphabat[25-i] * (9-i);
		}
		System.out.println(ans);
	}
}
