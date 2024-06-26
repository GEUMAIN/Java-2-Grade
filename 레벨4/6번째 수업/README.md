### 6번째 수업

### String 문제 풀어보기 정답

### 대소문자 바꾸기

```java
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
```

---

### 애너그램 만들기

---

```java
public class test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		
		int[] cntA = getAlphabetCnt(a);
		int[]  cntB = getAlphabetCnt(b);
		
		int ans = 0;
		for(int i = 0; i<26; i++) {
			ans += Math.abs(cntA[i] - cntB[i]);
			
		}
		System.out.println(ans);
	}
	
	public static int[] getAlphabetCnt(String str) {
		int[] alphabetCnt = new int[26];
		for(int i = 0; i<str.length(); i++) {
			alphabetCnt[str.charAt(i) - 'a']++;
		}
		
		return alphabetCnt;
	}
}
```

---

### 단어 공부

---

```java
public class test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next().toUpperCase();
		
		int[] cnt = new int[26];
		
		for (int i = 0; i <str.length(); i++) {
			cnt[str.charAt(i) - 'A']++;
		}
		
		int maxCnt = 0;
		char maxAlphabet = '?';
		
		for(int i = 0; i < 26; i++) {
			if(cnt[i] > maxCnt) {
				maxCnt = cnt[i];
				maxAlphabet = (char)('A' + i);
			}else if(cnt[i] == maxCnt) {
				maxAlphabet = '?';
			}
		}
		
		System.out.println(maxAlphabet);
	}
}
```

---

### 문서 검색

---

```java
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
```

---

### 소금 폭탄

---

```java
public class test5 {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        String[] current = sc.next().split(":");
	        String[] target = sc.next().split(":");

	        int currentHour = Integer.parseInt(current[0]);
	        int currentMinute = Integer.parseInt(current[1]);
	        int currentSecond = Integer.parseInt(current[2]);

	        int targetHour = Integer.parseInt(target[0]);
	        int targetMinute = Integer.parseInt(target[1]);
	        int targetSecond = Integer.parseInt(target[2]);

	        //현재 시간
	        int currentSecondAmount = currentHour * 3600 + currentMinute * 60 + currentSecond;
	        //목표 시간
	        int targetSecondAmount = targetHour * 3600 + targetMinute * 60 + targetSecond;

	        //현재 시간으로부터 목표시간까지의 필요한 시간
	        int needSecondAmount = targetSecondAmount - currentSecondAmount;
	        if(needSecondAmount <= 0) needSecondAmount += 24 * 3600;

	        int needHour = needSecondAmount / 3600;
	        int needMinute = (needSecondAmount % 3600) / 60;
	        int needSecond = needSecondAmount % 60;

	        System.out.printf("%02d:%02d:%02d", needHour, needMinute, needSecond);
	    }
}
```
