### 3번째 수업

## Object의 나머지 메서드

1. **`clone()` -> 객체를 복사할 때 사용한다. (잘 사용하지 않는다.)**
2. **`hashCode()` -> `equals()`와 `hasCode()` 종종 함께 사용한다. -> 컬렉션 `프레임워크`때 설명**
3. **`getClass()` -> `Class` 다룰 때 설명**
4. **`notify()`, `notifyAll()`, `wait()` -> `멀티스레드`용 메서드 -> 
`멀티 스레드`에서 설명**

## equals() 메서드를 구현할 때 지켜야 하는 규칙

1. **`반사성`: 객체는 자기 자신과 동등해야 한다. (`x.equals(x)` 는 항상 `true`)**
2. **`대칭성`: 두 객체가 서로에 대해 동일하다고 판단하면,
 이는 `양방향`으로 동일해야 한다.
(`x.equals(y)`가 `true`면 `y.equals(x)`도 `true`)**
3. **`추이성`: 만약 한 객체가 두 번째 객체와 동일하고, 
두 번째 객체가 세 번째 객체와 동일하다면,
첫 번째 객체와 세 번째 객체는 동일해야 한다.**
4. **`일관성`: 두 객체의 상태가 변경되지 않는 한, `equals()` 메소드는 
항상 동일한 값을 반환해야 한다.**
5. **`null`에 대한 비교: 모든 객체는 `null`과 비교했을 때 `false`를 반환해야 한다.**

## Rectangle

---

```java
public class Rectangle {
	private int width;
	private int height;
	
	public Rectangle(int width,int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "Rectangle{" +
				"가로=" + width +
				", 세로=" + height +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Rectangle rectangle = (Rectangle) o;
		return width == rectangle.width && height == rectangle.height;
	}
}
```

---

## RectangleMain

---

```java
public class RectangleMain {
	
	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle(100,20);
		Rectangle rect2 = new Rectangle(100,20);
		
		System.out.println(rect1);
		System.out.println(rect2);
		
		System.out.println(rect1 == rect2);
		System.out.println(rect1.equals(rect2));
	}

}

```

---

## 결과

![깃헙.PNG](https://prod-files-secure.s3.us-west-2.amazonaws.com/fa97d740-13f6-4ddc-9939-b86bb2c976d6/c8893f0b-6369-4e69-83d6-2b2433f900d8/%EA%B9%83%ED%97%99.png)

---

## 기본형, 참조형

### 기본형과 참조형의 공유

1. **`기본형`: 하나의 값을 여러 변수에서 절대로 공유하지 않는다.**
2. **`참조형`: 하나의 객체를 참조값을 통해 여러 변수에서 공유할 수 있다.**

### 기본형

![깃헙2.PNG](https://prod-files-secure.s3.us-west-2.amazonaws.com/fa97d740-13f6-4ddc-9939-b86bb2c976d6/462dfb2d-0baf-4cd0-842c-d2deef7d1161/%EA%B9%83%ED%97%992.png)

---

```java
public class PrimitiveMain {
	
	public static void main(String[] args) {
		
		int a = 10;
		int b = a;
		System.out.println("a = "+ a);
		System.out.println("b = "+ b);
		
		b = 20;
		System.out.println("20 -> b");
		System.out.println("a = "+ a);
		System.out.println("b = "+ b);
	}
}

```

---

![깃헙3.PNG](https://prod-files-secure.s3.us-west-2.amazonaws.com/fa97d740-13f6-4ddc-9939-b86bb2c976d6/593fc1c5-813f-40b2-9db4-aa2050780a8a/%EA%B9%83%ED%97%993.png)

---

### 참조형

![깃헙5.PNG](https://prod-files-secure.s3.us-west-2.amazonaws.com/fa97d740-13f6-4ddc-9939-b86bb2c976d6/a4b6bbb7-76b0-413e-a9e1-5a0688da0016/%EA%B9%83%ED%97%995.png)

---

## Address

```java
public class Address {
	private String value;
	
	public Address(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Address{" +
				"value=" + value + '\'' +
				'}';
	}
	
	
}

```

---

## RefMain1_1

---

```java
public class RefMain1_1 {
	public static void main(String[] args) {
		Address a = new Address("서울");
		Address b = a;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		b.setValue("부산");
		System.out.println("부산 -> b");
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
}

```

---

![깃헙4.PNG](https://prod-files-secure.s3.us-west-2.amazonaws.com/fa97d740-13f6-4ddc-9939-b86bb2c976d6/83299e6d-4224-4f13-8f2a-860d6b124454/%EA%B9%83%ED%97%994.png)

**`참조형 변수`들은 같은 `참조값`을 통해 같은 `인스턴스`를 참조할 수 있다.
`b = a` 라고 하면 `a`에 있는 `참조값(주소값) x001`을 복사해서 `b`에 전달한다.**

- **자바에서 모든 값 `대입(=)`은 가지고 있는 값을 복사해서 전달한다.**

**`참조값`을 복사해서 전달하므로 결과적으로 a, b는 값은 `x001` 인스턴스를 참조한다.**

---

### 사이드 이펙트

---

![깃헙6.PNG](https://prod-files-secure.s3.us-west-2.amazonaws.com/fa97d740-13f6-4ddc-9939-b86bb2c976d6/874d9bbb-d201-4bf7-bc72-e5b74c652dc4/%EA%B9%83%ED%97%996.png)

---

**`사이드 이펙트`는 `프로그래밍`에서 어떤 계산이 주된 작업 외에 추가적인 부수 효과를 일으키는 것을 말한다.
위에 코드로 풀어보면, 개발자는 b의 주소값을 서울에서 
부산으로 변경할 의도로 값 변경을 시도했다.**

**다만 `a, b`는 같은 `인스턴스`를 참조하기 때문에 
`a`의 값도 함께 부산으로 변경되어 버렸다.**

**이렇게 주된 작업 외에 `추가적인 부수 효과`를 
일으키는 것을 `사이드 이펙트`라고 한다.**

**`프로그래밍`에 `사이드 이펙트`는 보통 부정적인 의미로 사용되는데,
`사이드 이펙트`는 `프로그램`의 특정 부분에서 발생한 
변경이 의도치 않게 다른 부분에 영향을 미치기 때문이다.**

**이로 인해 `디버깅`이 어려워지고 `코드의 안정성`이 저하된다.**

---

### 사이드 이펙트 해결 방안

---

![깃헙7.PNG](https://prod-files-secure.s3.us-west-2.amazonaws.com/fa97d740-13f6-4ddc-9939-b86bb2c976d6/9c501fbf-5e15-4c75-aaed-e909e029677a/%EA%B9%83%ED%97%997.png)

---

**a와 b가 처음부터 서로 다른 `인스턴스`를 `참조`하게 만들면 된다.**

**지금까지 발생한 모든 문제는 `같은 객체(인스턴스)`를 `변수 a, b`가 함께 `공유`하기 때문에 발생한다.
따라서 객체를 공유하지 않으면 문제가 해결된다.
다만 하나의 객체를 여러 변수가 공유하지 않도록 강제로 막을 수 있는 방법이 `없다`는 것이 문제다.**

### 예시

---

```java
public class RefMain1_3 {
	public static void main(String[] args) {
		Address a = new Address("서울");
		Address b = a;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		change(b,"부산");
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
	
	private static void change(Address address, String changeAddress) {
		System.out.println("주소 값을 변경합니다 -> " + changeAddress);
		address.setValue(changeAddress);
	}
}
```

---

**이럴시 `사이드 이펙트`를 찾기 더욱 힘들어진다.**

**이를 해결하기 위해 `불변 객체`를 만들어서 `오류`가 뜨게 만들 수 있다.**

---

### 불변 객체 필요성

- **공유하면 안되는 객체를 여러 변수에서 공유했기 때문에 `문제가 발생`한다.**
- **하지만 앞서 살펴 보았듯이 객체의 공유를 막을 수 있는 방법은 없다.**
- **그런데 `사이드 이펙트`의 더 근본적인 원인을 고려해보면, 객체를 공유하는 것 자체는 문제가 아니었다.**
- **객체를 공유한다고 바로 `사이드 이펙트`가 발생하지는 않기 때문이다.**
- **문제의 직접적인 원인은 공유된 `객체의 값`을 변경한 것에 있다.**

---

```java
public class ImmutableAddress {
	
	private final String value;

	public ImmutableAddress(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ImmutableAddress {"
				+ "value=" + value + '\'' +
				"}";
	}	
}
```

**내부 값이 변경 되면 안된다. 따라서 `value`의 필드를 `final`로 선언했다.
값을 변경할 수 있는 `setValue()`를 제거했다.
이 `클래스`는 `생성자`를 통해서만 값을 `설정`할 수 있고, 
이 후에는 값을 변경하는 것이 불가능하다.**

**`불변 클래스`를 만드는 방법은 아주 단순하다.
어떻게든 `필드 값`을 변경할 수 없게 `클래스`를 설계하면 된다.**

---

```java
public class RefMain2 {
	public static void main(String[] args) {
		ImmutableAddress a = new ImmutableAddress("서울");
		ImmutableAddress b = a;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		b = new ImmutableAddress("부산");
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
}
```
