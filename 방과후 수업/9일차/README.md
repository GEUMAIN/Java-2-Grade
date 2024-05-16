## 9번째 수업

### 복습

### 부모

```java
public class Parent {
	public String value = "parent";
	
	public void method() {
		System.out.println("Parent.method");
	}
}
```

---

### 자식

```java
public class Child extends Parent{
	public String value = "child";
	
	@Override
	public void method() {
		System.out.println("Child.method");
	}
}
```

---

### 메인

```java
package poly.overriding;

public class OverrindgMain {
	public static void main(String[] args) {
		
		// 자식 변수가 자식 인스턴스 참조
		Child child = new Child();
		System.out.println("Child -> Child");
		System.out.println("value : " + child.value);
		child.method();
		
		System.out.println();
		
		//부모 변수가 부모 인스턴스 참조
		Parent parent = new Parent();
		System.out.println("Parent -> Parent");
		System.out.println("value : " + parent.value);
		parent.method();
		
		System.out.println();
		
		//부모 변수가 자식 인스턴스를 참조 (다향적 참조)
		// 부모는 자식을 품을 수 있다
		Parent poly = new Child();
		System.out.println("Parent -> Child");
		System.out.println("value : " + poly.value);
		poly.method(); // 메서드 오버라이딩이 되어 있어 오버라이딩 된 메서드가 먼저 우선권을 가져온다 [엄청 중요한 내용!!]
		
	}
}

/*
1. Child 변수는 Child 타입이다.
	-child.vaue, child.method()를 호출하면 인스턴스의 child 타입에서 기능을 찾아 실행한다.
	
2. Parent 변수는 Parent 타입이다.
	-parent.value, parent.method()를 호출하면 인스턴스의 parent 타입에서 기능을 찾아 실행한다.
	
3. Poly 변수는 Parent 타입이다.
	-poly.value, poly.method()를 호출하면 인스턴스의 parent 타입에서 기능을 찾아 실행한다.
		- poly.value : Parent 타입에 있는 value 값을 읽는다.
		- poly.method() : Parent 타입에 있는 method를 실행하려고 한다. 
			하위 타입인 child.method()가 오버라이딩 되어 있는걸 확인한다.
		- 오버라이딩 되어 있는 메서드는 항상 우선권을 가진다.
		- 따라서 Parent.method()가 아니라 Child.method()가 실행된다.
4. 오버라이딩은 부모 타입에서 정의한 기능을 자식 타입에서 재정의하는 것이다.
	만약에 자식에서도 오버라이딩하고 손자에서도 같은 메서드를 오버라이딩을 하면 손자의 오버라이딩 메서드가 우선권을 가진다.
		
		
*/
```

---

1. **`Child` 변수는 `Child` 타입이다.
- `child.vaue`, `child.method()`를 호출하면 인스턴스의 `child` 타입에서 기능을 찾아 실행한다.**
2. **`Parent` 변수는 `Parent` 타입이다.
- `parent.value`, `parent.method()`를 호출하면 인스턴스의 `parent` 타입에서 기능을 찾아 실행한다.**
3. **`Poly` 변수는 `Parent` 타입이다.
-`poly.value`, `poly.method()`를 호출하면 인스턴스의 `parent` 타입에서 기능을 찾아 실행한다.
- `poly.value` : `Parent` 타입에 있는 `value` 값을 읽는다.
- `poly.method()` : `Parent` 타입에 있는 `method`를 실행하려고 한다.
하위 타입인 `child.method()`가 오버라이딩 되어 있는걸 확인한다.
- 오버라이딩 되어 있는 메서드는 항상 우선권을 가진다.
- 따라서 `Parent.method()`가 아니라 `Child.method()`가 실행된다.**
4. **`오버라이딩`은 부모 타입에서 정의한 기능을 
자식 타입에서 `재정의`하는 것이다.
만약에 자식에서도 `오버라이딩`하고 손자에서도 같은 메서드를 `오버라이딩`을 
하면 손자의 `오버라이딩` 메서드가 우선권을 가진다.**

---

### 다향적 참조 사용법(메서드)

### 애니멀

```java
public class Animal {
	
	public void sound() {
		System.out.println("동물 울음 소리");
	}
}
```

---

### 개

```java
public class Dog extends Animal{
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}
```

---

### 고양이

```java
public class Cat extends Animal{
	@Override
	public void sound() {
		System.out.println("냐옹");
	}
}
```

---

### 소

```java
public class Caw extends Animal{
	@Override
	public void sound() {
		System.out.println("옴메");
	}
}

```

---

### 메인

```java
public class AnimalSoundMain1 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		Caw caw = new Caw();
		
		soundAnimal(dog);
		soundAnimal(cat);
		soundAnimal(caw);
		
	}
	
	
	public static void soundAnimal(Animal animal) {
		System.out.println("동물소리 테스트 시작");
		animal.sound();
		System.out.println("동물소리 테스트 종료");
	}
}
```

**위 코드의 핵심은 `Animal animal` 부분이다**

- **다향적 참조 덕분에 `animal` 뱐수는 자식인 `dog, cat, caw`의 
인스턴스를 참조할 수 있다.**
- **메서드 오버라이딩 부분에 `animal.sound()`를 호출해도 `Dog.sound()`, `Cat.sound()`, `Caw.sound()`와 같이 각 인스턴스의
메서드를 호출할 수 있다.**

---

### 다향적 참조 사용법(반복문)

```java
public class AnimalSoundMain2 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		Cow cow = new Cow();
		
		Animal A[] = {dog,cat,cow};
		
		for (int i = 0; i < 3; i++) {
			System.out.println("동물소리 테스트 시작");
			A[i].sound();
			System.out.println("동물소리 테스트 종료");
		}
	}
}
```

---

### 다향적 참조 사용법 (더 줄이기)

```java
public class AnimalSoundMain3 {
	public static void main(String[] args) {
		Animal[] animals = {new Dog(), new Cat(), new Cow()};
		
		for(Animal animal : animals) {
			soundAnimal(animal);
		}
	}
	
	public static void soundAnimal(Animal animal) {
		System.out.println("동물소리 테스트 시작");
		animal.sound();
		System.out.println("동물소리 테스트 종료");
	}
}
/*
 2가지 문제점
 1. Animal 클래스를 생성할 수 있는 문제
 2. Animal 클래스를 상속 받는 곳에서 sound() 메서드 오버라이딩 하지 않을 가능성
 */
```

**사용자에 따라 `치명적인 오류`가 생길 수 있다 
( 예 : 돼지를 만들었을 때 오버라이딩을 안했을 경우 )**

**`Animal` 클래스를 `인스턴스`화 시킬 수 있는 점도 문제가 생길 수 있다.**

**그래서 이 2가지를 막아보자.**

### 추상 클래스, 메서드 개념

### **추상 클래스**

- **동물과 같이 부모 클래스는 제공하지만, 실제 생성되면 안되는 클래스를 추상 클래스라 한다.**
- **`추상 클래스`는 이름 그대로 추상적인 개념을 제공하는 클래스이다. 따라서 실체인 `인스턴스`가 존재하지 않는다.**
- **`상속`을 목적으로 사용되고, `부모 클래스` 역할을 담당한다.**
- **`추상 클래스`는 클래스를 선언할 때 옆에 추상이라는 의미의 `abstract`키워드를 붙여주면 됟다.**
- **`추상 클래스`는 기존 클래스와 완전히 같다. 다만 `new Animal()`과 같이 
인스턴스를 생성하지 못하는 제약이 추가된 것이다.**

### **추상 메서드**

- **`부모 클래스`를 상속 받는 `자식 클래스`가 반드시 `오버라이딩` 해야 하는 
메서드를 부모 클래스에서 정의할 수 있다.**
- **이것을 `추상 메서드`라 한다.**
- **`추상 메서드`는 말 그대로 추상적인 개념을 제공하는 메서드이다. 따라서 실체가 존재하지 않고, `메서드 바디`가 없다.**
- **`public abstract void sound();`**
- **`추상 메서드`는 선언할 때 메서드 앞에 `abstract` 키워드를 붙여주면 된다.**
- **`추상 메서드`가 하나라도 있는 클래스는 `추상 클래스`로 선언해야 한다.**
- **바디가 구현되어 있지 않기 때문에 불러오면 안되게 때문에 오류를 띄운다.**

```java
public abstract class Animal {
	
	//추상 메서드
	public abstract void sound(); 
	
	public void move() {
		System.out.println("동물이 움직인다.");
	}
}
```

`**abstract`키워드를 붙여준다.**

```java
public class Dog extends Animal{
	
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}
```

`**오버라이딩` 하기 전에는 `extends`를 써도 오류가 뜬다.**

```java
public class AbstractMain {
	public static void main(String[] args) {
		
		
		//추상 클래스 생성
		//Animal animal = new Animal(); : 불가
		Dog dog = new Dog();
		Cat cat = new Cat();
		Cow cow = new Cow();
		
		cat.sound();
		cat.move();
	}
}
```
