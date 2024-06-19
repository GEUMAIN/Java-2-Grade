### 5번째 수업

### String

### Change 메서드

```java
public class StringChangeMain1 {
    public static void main(String[] args) {
        String str = "Hello, Java! Welcome to Java";

        System.out.println("인덱스 7부터의 나머지 문자열 : " + str.substring(7));
        System.out.println("인덱스 7부터 12까지의 부분 문자열 : " + str.substring(7, 12));
        System.out.println("문자열 결합 : " + str.concat("!!!"));
        System.out.println("'Java'를 'Worlod'로 대체 : " + str.replace("Java", "World"));
        System.out.println("첫 번째 'Java'를 'World'로 대체 : " + str.replaceFirst("Java", "World"));
    }
}
```

---

```java
public class StringChangeMain2 {
    public static void main(String[] args) {
        String str = "Java Programming ";

        System.out.println("소문자로 변환 : " + str.toLowerCase());
        System.out.println("대문자로 변환 : " + str.toUpperCase());
        System.out.println("공백 제거(trim) : " + str.trim());
        System.out.println("공백 제거(strip) : " + str.strip());
        System.out.println("앞 공백 제거 : " + str.stripLeading());
        System.out.println("뒤 공백 제거 : " + str.stripTrailing());
    }
}
```

---

### SplitJoin 메서드

```java
public class StringSplitJoinMain {
    public static void main(String[] args) {
        String str = "Apple,Banana,Orange";

        //split() //문자열 나누기
        String[] splitstr = str.split(",");

        for(String s : splitstr) {
            System.out.println(s);
        }

        //Join
        String joinedStr = String.join("-", "A", "B", "C");
        System.out.println("연결된 문자열 : " + joinedStr);

        //문자열 배열 연결
        String result = String.join("-", splitstr);
        System.out.println("result : " + result);
    }
}
```

---

### Utils 메서드

```java
public class StringUtilsMain1 {
	public static void main(String[] args) {
		
		int num = 100;
		boolean bool = true;
		Object obj = new Object();
		String str = "Hello, Java";
		
		String numString = String.valueOf(num);
		System.out.println("숫자의 문자열 값: " + numString);
		
		String boolString = String.valueOf(bool);
		System.out.println("불리언의 문자열 값:" + boolString);
		
		String objString = String.valueOf(obj);
		System.out.println("객체의 문자열 값:" + objString);
		
		String numString2 = num + "";
		System.out.println("빈문자열 + num: " + numString2);
		
		char[] strCharArray = str.toCharArray();
		
		System.out.println("문자열을 문자 배열로 변환 : " + strCharArray);
		
		for(char c : strCharArray) {
			System.out.print(c);
		}
		
		
	}
}
```

---

```java
public class StringUtilsMain2 {
	public static void main(String[] args) {
		
		int num = 100;
		boolean bool = true;
		String str = "Hello, Java";
		
		//format 메서드
		String format1 = String.format("num : %d, bool : %b, str: %s",num,bool,str);
		
		System.out.println(format1);
		
		String format2 = String.format("숫자 : %.2f",10.1234);
		
		System.out.println(format2);
		
		//printf
		System.out.printf("숫자 : %.2f",10.1234);
	}
}
```

---

### String 문제 풀어보기

### 에너그램 만들기

### **문제**

두 영어 단어가 철자의 순서를 뒤바꾸어 같아질 수 있을 때, 그러한 두 단어를 서로 애너그램 관계에 있다고 한다. 
예를 들면 occurs 라는 영어 단어와 succor 는 서로 애너그램 관계에 있는데, occurs의 각 문자들의 순서를 잘 바꾸면 succor이 되기 때문이다.

한 편, dared와 bread는 서로 애너그램 관계에 있지 않다. 
하지만 dared에서 맨 앞의 d를 제거하고, bread에서 제일 앞의 b를 제거하면, ared와 read라는 서로 애너그램 관계에 있는 단어가 남게 된다.

두 개의 영어 단어가 주어졌을 때, 

두 단어가 서로 애너그램 관계에 있도록 만들기 위해서 제거해야 하는 최소 개수의 문자 수를 구하는 프로그램을 작성하시오. 

문자를 제거할 때에는 아무 위치에 있는 문자든지 제거할 수 있다.

---

### **입력**

첫째 줄과 둘째 줄에 영어 단어가 소문자로 주어진다. 각각의 길이는 1,000자를 넘지 않으며, 적어도 한 글자로 이루어진 단어가 주어진다.

---

### **출력**

첫째 줄에 답을 출력한다.

---

### **예제 입력1**

```java
aabbcc
xxyybb
```

### **예제 출력1**

```java
8
```

---

### 미완성

```java
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

```
