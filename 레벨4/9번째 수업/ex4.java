package java_level4.lang.wrapper.ex;


import java.util.*;

public class ex4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		Set<String> nohear = new HashSet<>();
		for(int i = 0; i< N; i++) {
			nohear.add(sc.next());
		}
		
		List<String> ans = new ArrayList<>();
		
		for(int i = 0; i< M; i++) {
			String name = sc.next();
			if(nohear.contains(name)) {
				ans.add(name);
			}
		}
		
		Collections.sort(ans);
		
		System.out.println(ans.size());
        for (String name : ans) {
            System.out.println(name);
        }
	}
}
