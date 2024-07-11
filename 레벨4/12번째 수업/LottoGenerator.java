package java_level4.lang.math.test;

import java.util.Random;

public class LottoGenerator {
	private final Random random = new Random();
	private int[] arr;
	private int cnt;
	
	/*public int[] generator() {
		
		
		for(int i = 0; i< 6; i++) {
			arr[i] = random.nextInt(45) + 1;
			
			for(int j = 0; j < i; j++) {
				if(arr[i] == arr[j]) {
					i--;
				}
			}
		}
		
		return arr;
	}*/
	
	public int[] generator() {
		arr = new int[6];
		cnt = 0;
		while(cnt < 6) {
			int number = random.nextInt(45) + 1;
			
			if(isUnique(number)) {
				arr[cnt] = number;
				cnt++;
			}
			
			
		}
		
		return arr;
	}
	
	private boolean isUnique(int number) {
		for(int i = 0; i < cnt; i++) {
			if(arr[i] == number) {
				return false;
			}
		}
		return true;
	}
}

