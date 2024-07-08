### 8번째 수업

### 래퍼 클래스

```java
public class WrapperClassMain {
	public static void main(String[] args) {
		Integer newInteger = new Integer(10);
		Integer integerObj = Integer.valueOf(10);
		
		Long longObj = Long.valueOf(100);
		Double doubleObj = Double.valueOf(10.5);
		
		System.out.println("newInteger : " + newInteger);
		System.out.println("integerObj) : " + integerObj);
		System.out.println("longObj : " + longObj);
		System.out.println("doubleObj : " + doubleObj);
		
		System.out.println("내부 값 읽기");
		int intValue = integerObj.intValue();
		
		System.out.println("intValue : " + intValue);
		Long longValue = longObj.longValue();
		System.out.println("longValue : " + longValue);
		
		System.out.println("비교");
		System.out.println("== : " + (newInteger == integerObj));
		System.out.println("equals() : " + newInteger.equals(integerObj));
		
	}
}
```

### 래퍼 클래스 생성 - 박싱(boxing)

- **`기본형`을 `래퍼 클래스`로 변경하는 것을 마치 박스에 
물건을 넣는것 같다고 해서 `박싱(Boxing)`이라고 한다.**
- **`new Integer(10)` 은 사용하면 안된다. 현재까지 작동은 되지만, 
향후 제거할 예정이다**
- **대신에 `Integer.valueOf(10)` 을 사용하면 된다**
    - **내부에서 `new Integer(10)`을 사용해서 객체를 생성하고 돌려준다.**
- **추가로 `Integer.valueOf()` 에는 성능 최적화 기능이 있다.**
    - **개발자들이 주로 사용하는 `-128 ~ 127` 범위의 `Integer` 클래스를
     미리 생성해준다.**
    - **해당 범위의 값을 조회하면 미리 생성된 `Integer` 객체를 반환한다.**
    - **해당 범위의 값이 없으면 `new Integer()`를 호출한다.**
    - **마치 `문자열 풀`과 비슷하게 자주 사용하는 숫자를 미리 
    생성해두고 `재사용`한다.**

### **intValue() - 언박싱(Unboxing)**

- **`래퍼 클래스`에 들어있는 `기본형 값`을 다시 꺼내는 메서드이다.**
- **박스에 들어있는 물건을 꺼내는 것 같다고 
해서 `언박싱(Unboxing)`이라고 한다.**

**비교는 `equals()`사용**

- **`래퍼 클래스`는 객체이기 때문 `==` 비교를 하면 `인스턴스`이 `참조값`을 
비교한다.**
- **`래퍼 클래스`는 내부 값을 비교하도록 `equals()`를 재정해두었다.
따라서 값을 비교하려면 `equals()`를 사용해야 한다.**

**참고로 `래퍼 클래스`는 객체를 그대로 출력해도 
내부에 잇는 값을 문자로 출력하도록 `toString()`재정의했다.**

```java
public class AutoboxingMain1 {

	public static void main(String[] args) {
		// Primitive -> Wrapper
		int value = 7;
		Integer boxedValue = Integer.valueOf(value);
		
		// Wrapper -> Primitive
		int unboxedValue = boxedValue.intValue();
		
		System.out.println("boxedValue : " + boxedValue);
		System.out.println("unboxedvalue : " + unboxedValue);
	}
}
```

---

**`boxing : valueOf()`
`unBoxing : xxxValue()`**

- **개발자들이 오랜기간 개발을 하다 보니 
`기본형`을 `래퍼 클래스`로 변환하거나 또는 `래퍼 클래스`를
`기본형`으로 변환하는 일이 자주 발생했다.**
- **자바 1.5부터 `오토 박싱, 오토 언박싱`을 지원한다.**

---

```java
public class AutoboxingMain2 {

	public static void main(String[] args) {
		// Primitive -> Wrapper
		int value = 7;
		Integer boxedValue = value;
		
		// Wrapper -> Primitive
		int unboxedValue = boxedValue;
		
		System.out.println("boxedValue : " + boxedValue);
		System.out.println("unboxedvalue : " + unboxedValue);
	}
}
```

---

- **`오토 박싱`과 `오토 언박싱`은 컴퍼일러가 
개발자 대신 `valueOf(), xxxValue()` 등의 코드를 추가해주는 기능이다.**
- **덕분에 `기본형`과 `래퍼형`을 서로 편리하게 변환할 수 있다.**

---

```java
public class WrapperUtilsMain {
	public static void main(String[] args) {
		
		Integer i1 = Integer.valueOf(10); // 숫자, 래퍼 객체 변환
		Integer i2 = Integer.valueOf("10"); //문자열, 래퍼 객체 변환
		
		int intValue = Integer.parseInt("10"); // 문자열 전용, 기본형 변형
		
		
		//비교
		int compareResult = i1.compareTo(20);
		System.out.println("compareResult : " + compareResult);
		
		//산술 연산
		System.out.println("sum : " + Integer.sum(10, 20));
		System.out.println("min : " + Integer.min(10, 20));
		System.out.println("max : " + Integer.max(10, 20));
	}
}
```

---

**`valueOf()` : 래퍼 타입을 변환한다. 숫자 문자열 모두 지원한다.
`parseInt()` : 문자열을 기본형을 변환한다.
`compareTo()` : 내 값과 인수로 넘어온 값을 비교한다. 
내 값이 크면 1, 같으면 0, 작으면 -1을 반환한다.
`Integer.sum()`, `Integer.min()`, `Integer.max()`: `static` 메서드이다. 
간단한 덧셈, 작은 값, 큰 값 연산을 수행한다.**

---

### 야구 게임 문제 풀어보기

### **문제**

정보문화진흥원 정보 영재 동아리에서 동아리 활동을 하던 영수와 민혁이는 쉬는 시간을 틈타 숫자야구 게임을 하기로 했다.

- 영수는 1에서 9까지의 서로 다른 숫자 세 개로 구성된 세 자리 수를 마음속으로 생각한다. (예: 324)
- 민혁이는 1에서 9까지의 서로 다른 숫자 세 개로 구성된 세 자리 수를 영수에게 묻는다. (예: 123)
- 민혁이가 말한 세 자리 수에 있는 숫자들 중 하나가 영수의 세 자리 수의 동일한 자리에 위치하면 스트라이크 한 번으로 센다. 숫자가 영수의 세 자리 수에 있긴 하나 다른 자리에 위치하면 볼 한 번으로 센다.

예) 영수가 324를 갖고 있으면

- 429는 1 스트라이크 1 볼이다.
- 241은 0 스트라이크 2 볼이다.
- 924는 2 스트라이크 0 볼이다.
- 영수는 민혁이가 말한 수가 몇 스트라이크 몇 볼인지를 답해준다.
- 민혁이가 영수의 세 자리 수를 정확하게 맞추어 3 스트라이크가 되면 게임이 끝난다. 아니라면 민혁이는 새로운 수를 생각해 다시 영수에게 묻는다.

현재 민혁이와 영수는 게임을 하고 있는 도중에 있다. 민혁이가 영수에게 어떤 수들을 물어보았는지, 그리고 각각의 물음에 영수가 어떤 대답을 했는지가 입력으로 주어진다. 이 입력을 바탕으로 여러분은 영수가 생각하고 있을 가능성이 있는 수가 총 몇 개인지를 알아맞혀야 한다.

아래와 같은 경우를 생각해보자.

- 민혁: 123
- 영수: 1 스트라이크 1 볼.
- 민혁: 356
- 영수: 1 스트라이크 0 볼.
- 민혁: 327
- 영수: 2 스트라이크 0 볼.
- 민혁: 489
- 영수: 0 스트라이크 1 볼.

이때 가능한 답은 324와 328, 이렇게 두 가지이다.

영수는 동아리의 규율을 잘 따르는 착한 아이라 민혁이의 물음에 곧이곧대로 정직하게 답한다. 그러므로 영수의 답들에는 모순이 없다.

민혁이의 물음들과 각각의 물음에 대한 영수의 답이 입력으로 주어질 때 영수가 생각하고 있을 가능성이 있는 답의 총 개수를 출력하는 프로그램을 작성하시오.

### **입력**

첫째 줄에는 민혁이가 영수에게 몇 번이나 질문을 했는지를 나타내는 1 이상 100 이하의 자연수 N이 주어진다. 이어지는 N개의 줄에는 각 줄마다 민혁이가 질문한 세 자리 수와 영수가 답한 스트라이크 개수를 나타내는 정수와 볼의 개수를 나타내는 정수, 이렇게 총 세 개의 정수가 빈칸을 사이에 두고 주어진다.

### **출력**

첫 줄에 영수가 생각하고 있을 가능성이 있는 답의 총 개수를 출력한다.

### **예제 입력 1**

```
4
123 1 1
356 1 0
327 2 0
489 0 1
```

### **예제 출력 1**

```
2
```

---

```java
public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 몇 번 시도할 것인가?
        int[][] q = new int[N][3];  // 시도한숫자, 스트라이크갯수, 볼갯수
        for (int i = 0; i < N; i++) {
            q[i][0] = sc.nextInt();
            q[i][1] = sc.nextInt();
            q[i][2] = sc.nextInt();
        }

        int ans = 0;
        // 삼중 for문으로 모든 값을 체크함. 단, 123~987 중에 중복없는것!!
        for (int x=1; x<=9; x++)
            for (int y=1; y<=9; y++)
                for (int z=1; z<=9; z++) {
                    // 중복은 검사를 제외
                    if (x == y || y == z || x == z) continue;

                    boolean chk = true;
                    for (int i=0; i<N; i++) {
                        int qx = q[i][0] / 100;  // 백의 자리
                        int qy = (q[i][0] / 10) % 10;  // 십의 자리
                        int qz = q[i][0] % 10;  // 일의 자리

                        int strike = 0;
                        int ball = 0;

                        if (x == qx) strike++;
                        else if (x == qy || x == qz) ball++;
                        if (y == qy) strike++;
                        else if (y == qz || y == qx) ball++;
                        if (z == qz) strike++;
                        else if (z == qy || z == qx) ball++;

                        // 입력받은 스트라이크와 볼의 결과와 다른 경우는 답이 될 수 없음
                        if (strike != q[i][1] || ball != q[i][2]) {
                            chk = false;
                            break;
                        }
                    }
                    if (chk) ans++;
                }
        System.out.println(ans);
    }
```

---

### 먹을 것인가 먹힐 것인가 문제 풀어보기

### **문제**

심해에는 두 종류의 생명체 A와 B가 존재한다. A는 B를 먹는다. A는 자기보다 크기가 작은 먹이만 먹을 수 있다. 예를 들어, A의 크기가 {8, 1, 7, 3, 1}이고, B의 크기가 {3, 6, 1}인 경우에 A가 B를 먹을 수 있는 쌍의 개수는 7가지가 있다. 8-3, 8-6, 8-1, 7-3, 7-6, 7-1, 3-1.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/fa97d740-13f6-4ddc-9939-b86bb2c976d6/74377f5f-9559-4cea-8a8d-fe2c9abae92e/Untitled.png)

!https://cloud9june.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F09d6be13-d25c-43c8-9dc9-a75c57177bd3%2F39a89f22-d917-4988-8dda-21fa5487c6f6%2FUntitled.png?table=block&id=f7efddb4-c1e8-4068-9216-25f51ac57743&spaceId=09d6be13-d25c-43c8-9dc9-a75c57177bd3&width=520&userId=&cache=v2

[data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7)

두 생명체 A와 B의 크기가 주어졌을 때, A의 크기가 B보다 큰 쌍이 몇 개나 있는지 구하는 프로그램을 작성하시오.

### **입력**

첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의 첫째 줄에는 A의 수 N과 B의 수 M이 주어진다. 둘째 줄에는 A의 크기가 모두 주어지며, 셋째 줄에는 B의 크기가 모두 주어진다. 크기는 양의 정수이다. (1 ≤ N, M ≤ 20,000)

### **출력**

각 테스트 케이스마다, A가 B보다 큰 쌍의 개수를 출력한다.

### **예제 입력 1**

```
2
5 3
8 1 7 3 1
3 6 1
3 4
2 13 7
103 11 290 215
```

### **예제 출력 1**

```
7
1
```

```jsx
public class ex3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[] a = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			
			int[] b = new int[m];
			for(int i = 0; i < m; i++) {
				b[i] = sc.nextInt();
			}
			
			Arrays.sort(a);
			Arrays.sort(b);
			
			int ans = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(b[j] < a[i]) {
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
		
	}
}
```
