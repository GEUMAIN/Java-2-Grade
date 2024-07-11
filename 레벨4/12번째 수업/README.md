### 12번째 수업

### 로또만들기

### 선생님 풀이

```java
public class LottoGeneratorMain {
	public static void main(String[] args) {
		LottoGenerator generator = new LottoGenerator();
		int[] lottoNumbers = generator.generator();
		
		for(int lottoNumber : lottoNumbers) {
			System.out.print(lottoNumber + " ");
		}
	}
}
```

```java
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
```

---

### enum

### 등급에 따른 할인율 구하기

**고객을 3등급로 나누고, 상품 구매시 등급별로 할인을 적용한다. 
할인시 소수점 이하는 버린다.**

1. **`Basic` : 10% 할인**
2. **`Gold` : 20% 할인**
3. **`Diamond` : 30% 할인
회원 등급과 가격을 입력하면 할인 금액을 계산하는 클래스를 만들어보자.
예를 들어 Gold, 10000원을 입력하면 할인 대상 금액인 2000원을 반환한다.**

### 수정 전

```java
public class StringGradeEx0_1 {
	public static void main(String[] args) {
		DiscountService dis = new DiscountService();
		int price = 10000;
		Scanner sc = new Scanner(System.in);
		
		String grade = sc.next();
		
		System.out.println(dis.disCount(grade, price));
	}
}
```

```java
public class DiscountService {
	public int disCount(String grade, int price) {
		
		int discountPercent = 0;
		if(grade.equals("Basic")) {
			discountPercent = 10;
		}else if(grade.equals("Gold")) {
			discountPercent = 20;
		}else if(grade.equals("Diamond")) {
			discountPercent = 30;
		}else {
			System.out.println(grade + ": 할인 X");
		}
		
		return price * discountPercent / 100;
		
		
	}
}
```

---

### 문제점

**단순히 문자열을 입력하는 방식은 오타가 발생하기 쉽고, 존재하지 않는 값이 입력될 수 있는 문제점이 있다!**

**등급에 문자열을 사용하는 위의 방식은 다음과 같은 문제가 있다!**

- **타입 안정성 부족 : 문자열은 오타가 
발생하기 쉽고, 유효하지 않은 값이 입력 될 수 있다.**

- **데이터 일관성 : `"GOLD","gold","Gold"` 등 다양한 
형식으로 입력할 수 있어 일관성이 떨어진다.**

- **`컴파일`시 오류 감지 불가 : 이러한 잘못된 값은
 `컴파일`시 감지되지 않고, `런타임`에서만 문제가
 발견되기 때문에 디버깅이 어렵다!**

```java
public class StringGradeEx0_2 {
	public static void main(String[] args) {
		DiscountService dis = new DiscountService();
		int price = 10000;
		
		//존재하지 않는 등ㄱ브
		int vip = dis.disCount("VIP", price);
		
		System.out.println("VIP : " + vip);
		
		//오타
		int diamond = dis.disCount("DIAMONDD", price);
		
		System.out.println("DIAMOND : " + diamond);
		
		//소문자 입력
		int gold = dis.disCount("gold", price);
		
		System.out.println("GOLD : " + gold);
	}
}
```

---

---

### 문제 수정

**문자열 상수를 사용한 덕분에 전체적으로 코드가 더 명확해졌다.**

---

**`discount()`에 인자를 전달할 때도 `StringGrade`가 제공하는 
문자열 상수를 사용하면 된다.**

---

**만약 실수로 상수의 이름을 잘못 입력하면 `컴파일 시점`에 오류가 발생한다.
따라서 오류를 쉽고 빠르게 찾을 수 있다**.

---

```java
public class StringGrade {
	public static final String BASIC = "BASIC";
	public static final String GOLD = "GOLD";
	public static final String DIAMOND = "DIAMOND";
}
```

---

```java
public class DiscountService {

	public int disCount(String grade, int price) {
		
		int discountPercent = 0;
		if(grade.equals(StringGrade.BASIC)) {
			discountPercent = 10;
		}else if(grade.equals(StringGrade.GOLD)) {
			discountPercent = 20;
		}else if(grade.equals(StringGrade.DIAMOND)) {
			discountPercent = 30;
		}else {
			System.out.println(grade + ": 할인 X");
		}
		
		return price * discountPercent / 100;
		
		
	}
}
```

---

```java
public class StringGradeEx1_1 {
	public static void main(String[] args) {
		int price = 10000;
		
		DiscountService discountService = new DiscountService();
		
		int basic = discountService.disCount(StringGrade.BASIC, price);
		int gold = discountService.disCount(StringGrade.GOLD, price);
		int diamond = discountService.disCount(StringGrade.DIAMOND, price);
		
		System.out.println("Basic :" + basic);
		System.out.println("Gold :" + gold);
		System.out.println("Diamond :" + diamond);
	}
}
```

---

### 문제점

```java
public class StringGradeEx1_2 {
	public static void main(String[] args) {
		int price = 10000;
		
		DiscountService discountService = new DiscountService();
		
		int vip = discountService.disCount("VIP", price);
		
		System.out.println("VIP : " + vip);
		
		//오타
		int diamond = discountService.disCount("DIAMONDD", price);
		
		System.out.println("DIAMOND : " + diamond);
		
		//소문자 입력
		int gold = discountService.disCount("gold", price);
		
		System.out.println("GOLD : " + gold);
	}
}
```

**문자열 상수를 사용해도 지금까지 발생한 
근본적인 문제들을 해결 할 수 없다.**

---

**왜냐하면 `String` 타입은 어떤 문자열이든 입력할 수 있기 때문이다.
어떤 개발자가 실수로 `StringGrade`에 있는 문자열 상수를 사용하지 않고, 위 처럼 직접 문자열을 사용해도 막을 수 있는 방법이 없다.**

---

**사용해야 하는 문자열 상수가 어디에 있는지 
`discount()`를 호출하는 개발자는 알기 어렵다.**

---

### 문제 수정2 (타입 안전 열거형 패턴)

앞서 본 `String`처럼 아무 문자열이나 다 사용할 수 있는 것이 아니고, 
우리가 나열할`BASIC, GOLD, DIAMOND`만 사용하게 할 것이다.
-> 타입 안전 열거형 패턴

---

```java
public class ClassGrade {
	public static final ClassGrade BASIC = new ClassGrade();
	public static final ClassGrade GOLD = new ClassGrade();
	public static final ClassGrade DIAMOND = new ClassGrade();
}
```

---

```java
public class ClassRefMain {
	public static void main(String[] args) {
		System.out.println("class BASIC : " + ClassGrade.BASIC.getClass());
		System.out.println("class GOLD : " + ClassGrade.GOLD.getClass());
		System.out.println("class DIAMOND : " + ClassGrade.DIAMOND.getClass());
		
		System.out.println("ref BASIC = " + ClassGrade.BASIC);
		System.out.println("ref GOLD = " + ClassGrade.GOLD);
		System.out.println("ref DIAMOND = " + ClassGrade.DIAMOND);
		
		// static이므로 애플리케이션 로딩 시점에 3개의 ClassGrade 인스턴스가 샹성되고,
		// 각각의 상수는 ClassGrade 타입의 서로 다른 인스턴스 참조값을 가진다.
	}
}
```

**`static`이므로 애플리케이션 로딩 시점에 3개의 `ClassGrade` 인스턴스가 샹성되고, 각각의 상수는 `ClassGrade` 타입의 서로 다른 
인스턴스 참조값을 가진다.**

---

```java
public class DiscountService {

	public int disCount(ClassGrade classGrade, int price) {
		
		int discountPercent = 0;
		if(classGrade == classGrade.BASIC) {
			discountPercent = 10;
		}else if(classGrade == classGrade.GOLD) {
			discountPercent = 20;
		}else if(classGrade == classGrade.DIAMOND) {
			discountPercent = 30;
		}else {
			System.out.println("할인 X");
		}
		
		return price * discountPercent / 100;
		
		
	}
}
```

---

```java
public class ClassGradeEx2_1 {
	public static void main(String[] args) {
		int price = 10000;
		
		DiscountService discountService = new DiscountService();
		int basic = discountService.disCount(ClassGrade.BASIC, price);
		int gold = discountService.disCount(ClassGrade.GOLD, price);
		int diamond = discountService.disCount(ClassGrade.DIAMOND, price);
		
		System.out.println("basic : " + basic);
		System.out.println("gold : " + gold);
		System.out.println("diamond : " + diamond);
	}
}

```

---

### 문제 수정3 (생성자 Private 처리)

```java
public class ClassGrade {
	public static final ClassGrade BASIC = new ClassGrade();
	public static final ClassGrade GOLD = new ClassGrade();
	public static final ClassGrade DIAMOND = new ClassGrade();
	
	private ClassGrade() {
		
	};
}
```

```java
public class ClassGradeEx2_2 {
	public static void main(String[] args) {
		int price = 10000;
		
		DiscountService discountService = new DiscountService();
		
		/*
		ClassGrade newClassGrade = new ClassGrade(); //생성자를 Private 처리 해서 막기
		int result = discountService.disCount(newClassGrade, price);
		System.out.println("newClassGrade 등급의 할인 금액 : " + result);
		*/
	}
}
```

### 타입 안전 열거형 패턴(Type-Safe Enum Pattern) 장점

---

- **`타입 안정성 향상` : 정해진 객체만 사용할 수 있기 때문에 
잘못된 값을 입력하는 문제를 근본적으로 방지할 수 있다.**
- **`데이터 일관성` : 정해진 객체만 사용하므로 데이터의 
일관성이 보장된다**.

---

### 단점

---

- **많은 코드를 작성해야 한다.**
- **생성자를 `private` 처리 해줘야 한다.**

---

**이 단점을 보완하기 위해 자바는 `Enum` 기능을 제공해준다.**

```java
public enum Grade {
	BASIC,GOLD,DIAMOND
}
```
