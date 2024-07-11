package java_level4.lang.math.test;

import java.util.Random;

public class LottoGenerator {
	
	public int[] generator() {
		Random r = new Random();
		
		
		int[] arr = new int[6];
		
		for(int i = 0; i< 6; i++) {
			arr[i] = r.nextInt(45) + 1;
			
			for(int j = 0; j < i; j++) {
				if(arr[i] == arr[j]) {
					i--;
				}
			}
		}
		
		return arr;
	}
}

