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
