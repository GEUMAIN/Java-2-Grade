package java_level4.lang.wrapper.ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ex6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> cost = new ArrayList<>();
		ArrayList<Integer> budget = new ArrayList<>();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		long X = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			cost.add(sc.nextInt());
		}
		
		for (int i = 0; i < M; i++) {
			budget.add(sc.nextInt());
		}
		
		Collections.sort(cost);
		Collections.sort(budget);
		
		if(M > N) {
			for(int i = 0; i <(M-N); i++) {
				budget.remove(0);
			}
		}
		
		int ans = 0;
		
		while(budget.size() > 0 ) {
			if((calc(cost, budget)) <= X) {
				ans = budget.size();
				break;
			}else {
				budget.remove(0);
			}
		}
		System.out.println(ans);
	}
	
	static long calc(ArrayList cost, ArrayList budget) {
		long need = 0;
		for(int i = 0; i<budget.size(); i++) {
			need += ((int)budget.get(i) >= (int)cost.get(i)) ? 0 : (int)cost.get(i) - (int)budget.get(i);
			
			
		}
		return need;
	}
}

