package hash;

import java.util.HashMap;

public class HashMapEx {
	public static void main(String[] args) {
		HashMap<String, Integer> hashmap = new HashMap<>();
		
		hashmap.put("ABC", 10);
		hashmap.put("BBB", 20);
		hashmap.put("AAA", 30);
		hashmap.put("ABC", 15); // 기존 키에 value인 10 대신 15가 들어간다.
		
		System.out.println(hashmap.isEmpty()); // 비어있는지 확인 - false 
		System.out.println(hashmap.get("ABC")); //ABC의 키 값 출력 - 10 대신 15
		System.out.println(hashmap.containsKey("ABC")); //ABC라는 키가 존재하느냐 - true
		
		System.out.println(hashmap.remove("ABC")); //ABC 라는 것을 삭제
		System.out.println(hashmap.containsKey("ABC")); //없기 때문에 false
		System.out.println(hashmap.size()); // 2
		
		hashmap.clear();
		System.out.println(hashmap.isEmpty()); //비어있기 때문에 true
	
	}
}
