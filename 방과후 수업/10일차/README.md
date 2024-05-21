## 10번째 수업

### 인터페이스

**클래스 -> 추상 클래스 -> 순수 추상 클래스 -> 인터페이스
즉, `순수 추상 클래스`를 더 편리하게 사용할 수 있도록 
제공하는게 `인터페이스`이다.**

**`순수 추상 클래스` 특징**

1. **`인스턴스` 생성할 수 없다.**
2. **상속시 모든 `메서드`를 `오버라이딩` 해야 한다.**
3. **주로 다형성을 위해 사용된다.**

**`인터페이스` 특징**

1. **앞서 설명한 `순수 추상 클래스`의 특징을 모두 포함한다.**
2. **`인터페이스 메서드`는 모두 `public abstract` 이다.**
3. **메서드에 `public abstract`를 생략할 수 있다. 참고로 생략을 권장한다.**
4. **`인터페이스`는 다중 구현(다중 상속)을 지원한다. (가장 큰 특징)**

---

### 순수 추상 클래스

```java
public abstract class AbstractAnimal {
	public abstract void sound();
	public abstract void move();
}

```

---

### 인터페이스

```java
// 인터페이스
// 인터페이스는 class 대신 interface 키워드를 사용하면 된다.
public interface IntetfaceAnimal {
	public abstract void sound();
	public abstract void move();
}
```

**인터페이스는 `class` 대신 `interface` 키워드를 사용하면 된다.
인터페이스의 메서드는 `public abstract` 를 무조건 사용한다.
그래서 생략이 가능하다.**

**인터페이스의 메서드는 `public abstract` 를 무조건 사용한다.
그래서 생략이 가능하다.**

```java
public interface IntetfaceAnimal1 {
	void sound();
	void move();
	
	public static final double MY_PI = 3.14;
	double you_PI = 3.14;
	
}
```

**인터페이스에서 멤버 변수는 `public static final` 이 모두 포함되었다고 간주한다.
`final`은 변수의값을 한 번 설정하면 수정할 수 없다는 뜻이다.
자바에서 `static final`을 사용해 정적이면서 고칠 수 없는 변수를 상수라고 한고,
관례상 상수는 대문자에 `언더스코어(_)`로 구분한다.
해당 키워드는 생략이 가능하다. (생략 권장)**

**`클래스, 추상 클래스, 인터페이스`는 모두 똑같다.**

- **`클래스, 추상 클래스, 인터페이스`는 프로그램 코드, 메모리 구조상 모두 똑같다.**
- **`인터페이스`는 `순수 추상 클래스`와 비슷하다고 생각하면 된다.**

---

### **상속과 구현**

- **`상속`과 `구현`은 사람이 표현하는 단어만 다를 뿐이지 자바 입장에서는 똑같다.**
- **`일반 상속 구조`와 동일하게 작동한다.**

---

### 인터페이스를 사용해야 하는 이유

- **`순수 추상 클래스`와 `인터페이스`를 비교했을 때 차이점을 느끼기가 어렵다.**
1. **제약 : `순수 추상 클래스`는 시간이 지남에 따라 
필요에 의해 `일반 메서드`가 구현될 수 있고
그런 경우 `순수 추상 클래스`에 `일반 추상 클래스`로 변경될 수 있다.
`인터페이스`는 위와 같은 일을 원천 차단시킬 수 있다.**
2. **다중 구현 : `자바`에서는 `클래스 상속`은 부모 하나만 지정할 수 있다.
빈면에 `인터페이스`는 부모를 여러명 두는 `다중 구현(다중 상속)`이 가능하다.**

---

### 자바가 다중 상속을 지원하지 않는 이유

1. `**다중 상속`을 사용할 경우 두 부모가 같은 `메서드`를 가졌을 때
자식에서 호출한 `메서드`가 어느 부모의 `메서드`인지 알 수 없는 문제가 발생한다. 이것을 `다이아몬드 문제`라 한다.**
2. `**다중 상속`을 사용하면 `클래스 계층 구조`가 매우 복잡해질 수 있다.**

---

### 인터페이스의 다중 구현은 허용한 이유

- `**인터페이스`는 모두 `추상 메서드`로 이루어져 있기 때문이다.**

```java
public interface InterfaceA {
	void methodA();
	void methodCommon();
}
```

```java
public interface InterfaceB {
	void methodB();
	void methodCommon();
}
```

```java
public class Child implements InterfaceA, InterfaceB{
	@Override
	public void methodA() {
		System.out.println("Child.methodA");
	}
	
	@Override
	public void methodB() {
		System.out.println("Child.methodB");
	}
	
	@Override
	public void methodCommon() {
		System.out.println("Child.methodCommon");
	}
}
```

```java
public class InterfaceMain {
	public static void main(String[] args) {
		InterfaceA a = new Child();
		
		a.methodA();
		a.methodCommon();
		
		InterfaceB b = new Child();
		
		b.methodB();
		b.methodCommon();
	}
}
```

### 결과

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/fa97d740-13f6-4ddc-9939-b86bb2c976d6/0148f60a-6bf5-44cb-9cdc-32ada8f83d45/Untitled.png)

---

### 실습해보기

**`sound()`는 추상 클래스로 구현하고
`move()`는 일반 클래스로 구현한다.
`fly()`는 인터페이스로 구현한다.**

---

### 추상 클래스

```java
public abstract class AbstractAnimal {	
	
	public abstract void sound();
	
	public static void move() {
		System.out.println("동물이 이동한다.");
	}
}
```

---

### 인터페이스

```java
public interface Fly {

	void fly();
	
}
```

---

### 개, 새, 닭

```java
public class Dog extends AbstractAnimal{
	
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
	
}
```

```java
public class Bird extends AbstractAnimal implements Fly{

	@Override
	public void sound() {
		System.out.println("짹짹");
	}
	
	@Override
	public void fly() {
		System.out.println("새가 날아간다");
	}
}

```

```java
public class Chicken extends AbstractAnimal implements Fly{

	@Override
	public void sound() {
		System.out.println("꼬꼬댁");
	}
	
	@Override
	public void fly() {
		System.out.println("닭이 날아간다");
	}
}
```

---

### 메인

```java
public class InterfaceMain {
	public static void main(String[] args) {
		
		AbstractAnimal dog = new Dog();
		AbstractAnimal abbird = new Bird();
		AbstractAnimal abchicken = new Chicken();
		
		Fly bird = new Bird();
		Fly chicken = new Chicken();
		
		animalsound(dog);
		animalsound(abchicken);
		animalsound(abbird);
		
		animalfly(chicken);
		animalfly(bird);
		
		dog.move();
		abbird.move();
		abchicken.move();
	}
	
	public static void animalsound(AbstractAnimal animal) {
		animal.sound();
	}
	
	public static void animalfly(Fly fly) {
		fly.fly();
	}
}
```
