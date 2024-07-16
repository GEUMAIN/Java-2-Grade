### 13번째 수업

### enum

```java
public enum Grade {
	BASIC,GOLD,DIAMOND
	// 열거형을 정의할 때는 class 대신에 enum을 사용한다.
	// 원하는 상수의 이름을 나열하면 된다.
	// enum 열거형도 클래스이다.
	// 열거형은 자동으로 java.lang.Enum 을 상속받는다.
}
/*
- 자바는 타임 안전 열거형 패턴 매우 편리하게 사용할 수 있는 열거형(Enum Type)을 제공한다
- enum은 enumeration의 줄임말인데, 번역하면 열거라는 뜻이고, 어떤 항목을 나열한다는 뜻이다.
- 일련의 명명된 상수들의 집합을 정의하는 것을 의미하며, 프로그래밍에서는 이러한 상수들을 사용하여
코드 내에서 미리 정의된 값들의 집합을 나타낸다.
- 쉽게 이야기해서 회원의 등급은 상수로 정의한 BASIC, GOLD, DIAMOND만 사용할 수 있다는 뜻이다.
- 자바의 enum은 타입 안정성을 제공하고, 코드의 가독성을 높이며, 예상 가능한 값들의 집합을 표현하는데 사용한다.
*/
```

---

- **자바는 타입 안전 열거형 패턴 매우 편리하게 
사용할 수 있는 `열거형(Enum Type)`을 제공한다**

---

- **`enum`은 `enumeration`의 줄임말인데, 
번역하면 `열거`라는 뜻이고, 어떤 항목을 나열한다는 뜻이다.**

---

- **일련의 명명된 상수들의 집합을 정의하는 것을 의미하며, 
프로그래밍에서는 이러한 상수들을 사용하여
코드 내에서 미리 정의된 값들의 집합을 나타낸다.**

---

- **쉽게 이야기해서 회원의 등급은 상수로 
정의한 `BASIC, GOLD, DIAMOND`만 사용할 수 있다는 뜻이다.**

---

- **자바의 `enum`은 타입 안정성을 제공하고, 
코드의 가독성을 높이며, 예상 가능한 값들의 집합을 표현하는데 사용한다.**

---

```java
public class EnumRefMain {
	public static void main(String[] args) {
		System.out.println("class BASIC : " + Grade.BASIC.getClass());
		System.out.println("class GOLD : " + Grade.GOLD.getClass());
		System.out.println("class DIAMOND : " + Grade.DIAMOND.getClass());
		
		System.out.println("ref BASIC : " + refValue(Grade.BASIC));
		System.out.println("ref GOLD : " + refValue(Grade.GOLD));
		System.out.println("ref DIAMOND : " + refValue(Grade.DIAMOND));
	}
	
	private static String refValue(Object grade) {
		return Integer.toHexString(System.identityHashCode(grade));
	}
}
```

### 실행결과

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/fa97d740-13f6-4ddc-9939-b86bb2c976d6/d2f95edf-09a5-4bee-886b-a63cc028d725/Untitled.png)

---

- **실행 결과를 보면 상수들이 열거형으로 선언한 타입이 `Grade` 타입을 사용하는 것을 알 수 있다.**
- **그리고 각각의 `인스턴스`들이 서로 다른 것을 확인할 수 있다.**
- **참고로 열거형은 `toString()`을 오버라이딩 하기 때문에 
참조값을 직접 확인할 수 없다.**
- **참고값을 확인하기 위해 `refValue()` 생성한다.**
    - **`identityHashCode(grade)` : 자바가 관리하는 
    객체의 참조값을 숫자로 반환한다.**
    - **`Integer.toHexString()` : 숫자를 16진수로 변환, 
    우리가 일반적으로 확인하는 참고값(16진수)**
- **열거형도 클래스이다. 열거형을 제공하기 
위해 제약이 추가된 클래스라 생각하면 편하다.**

---

```java
public class DiscountService {
	
	public int discount(Grade grade, int price) {
		int discountPercent = 0;
		
		
		// enum switch 변경 가능
		if(grade == Grade.BASIC) {
			discountPercent = 10;
		} else if (grade == Grade.GOLD) {
			discountPercent = 20;
		} else if (grade == Grade.DIAMOND) {
			discountPercent = 30;
		} else {
			System.out.println("할인 X");
		}
		
		return price * discountPercent / 100;
	}
}

```

---

```java
public class EnumEx3_1 {
	public static void main(String[] args) {
		int price = 10000;
		
		DiscountService discountService = new DiscountService();
		int basic = discountService.discount(Grade.BASIC, price);
		int gold = discountService.discount(Grade.GOLD, price);
		int diamond = discountService.discount(Grade.DIAMOND, price);
		
		System.out.println("BASIC : " + basic);
		System.out.println("GOLD : " + gold);
		System.out.println("DIAMOND : " + diamond);
	}
}
```

---

```java
//Grade myGrade = new Grade(); // enum은 객체 생성 불가
//enum은 열거형 내부에서 상수로 지정하는 것 외에 직접 생성이 불가능하다.
//생성할 경우 컴파일 오류가 발생한다.
```

### 열거형의 장점

1. **`타입 안정성 향상` : 얼거형은 사전에 정의된 상수들로만 구성되므로, 
유효하지 않은 값이 입력될 가능성이 없다.
만약 유효하지 않은 값을 입력할 경우 컴파일 오류가 발생한다.**
2. **`간결성 및 일관성` : 열거형을 사용하면 
코드가 더 간결하고 명확해지며, 데이터의 일관성이 보장된다.**
3. **`확장성` : 새로운 회원 등급을 타입을 
추가하고 싶을 때, ENUM에 새로운 상수를 추가하기만 하면 된다.**

---

### ENUM 메서드

### 모든 Enum 반환

```java
Grade[] values = Grade.values();
		
		System.out.println("values : " + Arrays.toString(values));
		
		for (Grade value : values) {
			System.out.println("name : " + value.name() + ", ordinal : " + value.ordinal());
		}
```

---

### String → Enum

```java
String input = "GOLD";
		Grade gold = Grade.valueOf(input);
		System.out.println("gold : " + gold); // toString() 오버라이딩 가능
```

---

1. **`Arrays.toString()` : 배열의 참조값이 아니라 배열 
내부의 값을 출력할 때 사용**
2. **`values()` : 모든 ENUM 상수를 퐇마하는 배열을 반환한다.**
3. **`name()` : ENUM 상수의 이름을 문자열로 반환한다.**
4. **`ordinal()` : ENUM 상수의 선언 순서(0부터 시작)을 반환한다.**
5. **`toString()` : ENUM 상수의 이름을 문자열로 반환한다. 
`name()` 메서드와 유사하지만, `toString()`은 직접 오버라이딩 할 수 있다.**

---

### 열거형 최종정리

1. **열거형은 `java.lang.Enum` 를 자동(강제)으로 상속 받는다.**
2. **열거형은 이미 `java.lang.Enum`을 상속 받았기 때문에 추가로 다른 
클래스를 상속 받을 수 없다.**
3. **열거형은 인터페이스를 구현할 수 있다.**
4. **열거형에 추상 메서드를 선언하고 구현할 수 있다.**
    - **이 경우 익명 클래스와 같은 방식을 사용한다.**

---

### Ex2 리팩토링 하기

### 첫번째 리팩토링

```java
public class ClassGrade {
	public static final ClassGrade BASIC = new ClassGrade(10);
	public static final ClassGrade GOLD = new ClassGrade(20);
	public static final ClassGrade DIAMOND = new ClassGrade(30);
	
	private final int discountPercent;
	
	private ClassGrade(int discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	public int getDiscountPercent() {
		return discountPercent;
	}
}

// 상수를 정의할 때 각각의 등급에 따른 할인율이 정해진다.
```

---

```java
public class DiscountService {
	
	public int discount(ClassGrade classGrade, int price) {
		return price * classGrade.getDiscountPercent() / 100;
	}
}
/*
기존의 if문은 완전히 제거되고, 단순한 할인율 계산 로직만 낭았다.
변경된 코드에서는 if문을 사용할 이유가 없다.
단순히 회원등급 안에 있는 getDiscountPercent() 메서드를 호출하면 인수로 넘어온 회원 등급에 할인율을 바로 구할 수 있다.
*/
```

---

```java
public class ClassGradeRefMain1 {
	public static void main(String[] args) {
		int pirce = 10000;
		DiscountService discountService = new DiscountService();
		
		int basic = discountService.discount(ClassGrade.BASIC, pirce);
		
		System.out.println("BASIC : " + basic);
	}
}
```

---

### 두번째 리팩토링 (enum 열거형)

```java
public enum Grade {
	BASIC(10),GOLD(20),DIAMOND(30);
	
	private final int discountPercent;
	
	Grade(int discountPercent){
		this.discountPercent = discountPercent;
	}
	
	public int getDiscountPercent() {
		return discountPercent;
	}
}
```

---

```java
public class DiscountService {
	
	public int discount(Grade grade, int price) {
		return price * grade.getDiscountPercent() / 100;
	}
}
```

---

```java
public class EnumRefMain2 {
	public static void main(String[] args) {
		int price = 10000;
		DiscountService disCountService = new DiscountService();
		
		int basic = disCountService.discount(Grade.BASIC, price);
		System.out.println("BASIC : " + basic);
	}
}

```

---

### 세번째 리팩토링 (캡슐화)

```java
public enum Grade {
	BASIC(10),GOLD(20),DIAMOND(30);
	
	private final int discountPercent;
	
	Grade(int discountPercent){
		this.discountPercent = discountPercent;
	}
	
	public int getDiscountPercent() {
		return discountPercent;
	}
	
	// 추가 - 캡슐화, 불필요한 클래스 삭제
	public int discount(int price) {
		return price * discountPercent / 100;
	}
}

```

---

```java
public class EnumRefMain3 {
	public static void main(String[] args) {
		int pirce = 10000;
		
		System.out.println("BASIC 듭급의 할인 금액 : " + Grade.BASIC.discount(pirce));
		System.out.println("GOLD 듭급의 할인 금액 : " + Grade.GOLD.discount(pirce));
		System.out.println("DIAMOND 듭급의 할인 금액 : " + Grade.DIAMOND.discount(pirce));
	}
}
```

---

```java
public class EnumRefMain3_2 {
	public static void main(String[] args) {
		int pirce = 10000;
		printDiscount(Grade.BASIC, pirce);
		printDiscount(Grade.GOLD, pirce);
		printDiscount(Grade.DIAMOND, pirce);
	}
	
	private static void printDiscount(Grade grade, int price) {
		System.out.println(grade.name() + " 등급의 할인 금액 : " + grade.discount(price));
	}
}
```

---

```java
public class EnumRefMain3_3 {
	public static void main(String[] args) {
		int pirce = 10000;
		Grade[] grades = Grade.values();
		
		for(Grade g : grades) {
			printDiscount(g, pirce);
		}
	}
	
	private static void printDiscount(Grade grade, int price) {
		System.out.println(grade.name() + " 등급의 할인 금액 : " + grade.discount(price));
	}
}

```
