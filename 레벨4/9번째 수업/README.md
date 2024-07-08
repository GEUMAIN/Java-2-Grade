### 9번째 수업

### 듣보잡 문제 풀어보기

### **문제**

김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.

### **입력**

첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다. 이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다. 이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.

듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.

### **출력**

듣보잡의 수와 그 명단을 사전순으로 출력한다.

### **예제 입력 1**

```
3 4
ohhenrie
charlie
baesangwook
obama
baesangwook
ohhenrie
clinton
```

### **예제 출력 1**

```
2
baesangwook
ohhenrie
```

```jsx
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
			String name =sc.next();
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
```

---

### 단어 수학

### **문제**

민식이는 수학학원에서 단어 수학 문제를 푸는 숙제를 받았다.

단어 수학 문제는 N개의 단어로 이루어져 있으며, 각 단어는 알파벳 대문자로만 이루어져 있다. 이때, 각 알파벳 대문자를 0부터 9까지의 숫자 중 하나로 바꿔서 N개의 수를 합하는 문제이다. 같은 알파벳은 같은 숫자로 바꿔야 하며, 두 개 이상의 알파벳이 같은 숫자로 바뀌어지면 안 된다.

예를 들어, GCF + ACDEB를 계산한다고 할 때, A = 9, B = 4, C = 8, D = 6, E = 5, F = 3, G = 7로 결정한다면, 두 수의 합은 99437이 되어서 최대가 될 것이다.

N개의 단어가 주어졌을 때, 그 수의 합을 최대로 만드는 프로그램을 작성하시오.

### **입력**

첫째 줄에 단어의 개수 N(1 ≤ N ≤ 10)이 주어진다. 둘째 줄부터 N개의 줄에 단어가 한 줄에 하나씩 주어진다. 단어는 알파벳 대문자로만 이루어져있다. 모든 단어에 포함되어 있는 알파벳은 최대 10개이고, 수의 최대 길이는 8이다. 서로 다른 문자는 서로 다른 숫자를 나타낸다.

### **출력**

첫째 줄에 주어진 단어의 합의 최댓값을 출력한다.

### **예제 입력 1**

```
2
AAA
AAA
```

### **예제 출력 1**

```
1998
```

### **예제 입력 2**

```
2
GCF
ACDEB
```

### **예제 출력 2**

```
99437
```

### **예제 입력 3**

```
10
A
B
C
D
E
F
G
H
I
J
```

### **예제 출력 3**

```
45
```

### **예제 입력 4**

```
2
AB
BA
```

### **예제 출력 4**

```
187
```

```jsx
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
```
