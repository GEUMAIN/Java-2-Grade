### 1번째 수업

## java.lang 패키지

**- 자바가 기본으로 제공하는 `라이브러리`(클래스 모음) 중에 가장 기본이 되는 것.
- `lang` = `language`의 줄임말
- 자바 언어를 이루는 가장 기본이 되는 `클래스`를 보관하는 패키지**

---

## java.lang 패키지의 대표적인 클래스들

**1. `Object` : 모든 자바 객체의 부모 클래스
2. `String` : 문자열
3. `Integer`, `Long`, `Double` : 랩퍼 타입, 기본형 데이터 타입을 객체로 만든 것
4. Class : 쿨래스 메타 정보를 담고 있는 Class
5. System : 시스템과 관련된 기본 기능들을 제공
-위에 클래스들은 자바 언어의 기본을 다루기 때문에 반드시 알고 넘어가야 한다!!!**

---

## import 생략 가능

**- `java.lang` 패키지는 모든 자바 애플리케이션의 자동으로 `임포트(import)` 된다.
- 따라서 `임포트 구문`을 사용하지 않아도 된다.**

```java
package lang;

// import java.lang.System;

public class LangMain {
	public static void main(String[] args) {
		
		System.out.println("hello java");
	}
}

```

---

## **Object 클래스**

**- 자바에서 모든 클래스의 최상위 부모 클래스는 `Object` 클래스이다.**

```java
package lang.object;

//public class Parent extends Object{
public class Parent {
	public void ParentMethod() {
		System.out.println("Parent.parentMethod");
	}
}
/*
클래스에 상속 받을 부모 클래스가 없으면 묵시적으로 Object 클래스를 상속 받는다.
- 자바가 extends Object 코드를 넣어주는 것이다.
- extends Object는 생략하는 것을 권장한다.
*/
```

**클래스에 상속 받을 부모 클래스가 없으면 묵시적으로 `Object` 클래스를 상속 받는다.
- 자바가 e`xtends Object` 코드를 넣어주는 것이다.
- `extends Object`는 생략하는 것을 권장한다.**

```java
package lang.object;

public class Child extends Parent{
	public void ChildMethod() {
		System.out.println("Child.childMethod");
	}
}
```

**클래스의 상속 받을 부모 클래스를 명시적으로 지정하면 `Object`를 상속 받지 않는다.**

```java
package lang.object;

public class ObjectMain {
	public static void main(String[] args) {
		Child child = new Child();
		child.ChildMethod();
		child.ParentMethod();
		
		// toString() 은 Object 클래스의 메서드
		System.out.println(child.toString());
	}
}
```

**아버지의 아버지인 `Object`의 `메서드`는 `Child`의 아버지가 상속하고 있어 
사용이 가능하다.**

**자바에서 `Object` 클래스가 최상위 부모 클래스인 이유**

---

## **1. 공통 기능을 제공**

**- `객체`의 정보를 제공하고, 이 `객체`가 다른 객체와 같은지 `비교`하고, 객체가 어떤 
`클래스`로 만들어졌는지 확인하는 기능은 모든 `객체`가 필요로 하는 기능이다. 

이런 기능을 객체를 만들때 마다 항상 새로운 `메서드`를 정의해서 
만들어야 한다면 상당히 번거로울 것이다.**

**- 막상 만든다고 해도 `개발자`마다 서로 다른 이름의 `메서드`를 
만들어서 `일관성`이 없을 것이다.**

**- `개발자`는 모든 객체가 앞서 설명한 `메서드`를 지원한다는 것을 알고 있다, 
따라서 `프로그래밍`이 단순화되고, `일관성`을 갖게 된다.**

---

## 2. 다형성의 기본 구현

**- 부모는 자식을 담을 수 있다. `Object`는 모든 클래스의 `부모 클래스`이다. 따라서 모든 `객체`를 참조할 수 있다.
- 모든 `자바 객체`는 `Object` 타입으로 처리할 수 있으며, 
이는 다양한 타입의 객체를 통합적으로 `관리`할 수 있다.
- `Object`는 모든 객체를 담을 수 있기에 타입이 
다른 객체들을 어딘가에 보관해야 한다면 `Object`에 보관하면 된다.**

---

## **Object의 다형성**

**- `Object`는 모든 클래스의 부모 클래스이다. 
따라서 `Object`는 모든 객체를 참조할 수 있다.**

```java
public class ObjectPolyExample {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Car car = new Car();
		
		action(car);
		action(dog);
	}
	
	private static void action(Object obj) {
		//부모는 자식 메서드를 참조할 수 없다.
		
		//dog.sound(); 컴파일 오류, Object에서 sound()가 없다.
		//car.move();  컴파일 오류, Object에서 move()가 없다.
		
		//객체에 맞는 다운캐스팅 필요
		if (obj instanceof Dog dog) {
			dog.sound();
		}else if (obj instanceof Car car) {
			car.move();
		}
	}
}
```

---

## Object를 활용한 다향성 한계

**- `Object`는 모든 객체를 대상으로 `다형적 참조`를 할 수 있다.
  - 즉, `Object`는 모든 객체의 부모이므로 모든 객체를 담을 수 있다.**

**- `Object`를 통해 전달 받은 객체를 호출하려면 
각 객체에 맞는 `다운캐스팅` 과정이 필요하다.**

  **- `Object`가 세상의 모든 메서드를 알고 있는 것이 아니다.**

**다형성을 제대로 활용하려면 `다형적 참조` + `메서드 오버라이딩`을 통해 사용해야 한다.

`Object`는 모든 객체의 부모이므로 모든 객체를 대상이므로 `다향적 참조`를 할 수 있다.**

**하지만 `Object`에는 `Dog.sound()`, `Car.move()`와
같은 다른 객체의 `메서드`가 정의되어 있지 않다.**

**따라서 `메서드 오버라이딩`을 활용할 수 없다.**

**결국 각 객체의 기능을 호출하려면 `다운캐스팅`을 해야한다.

결론!!
`다향적 참조`는 가능하지만, 
`메서드 오버라이딩`이 안되기 때문에 `다형성`을 활용하기에 한계가 있다!!!!**

---

## Object 배열

**- `Object[]`을 만들면 세상의 모든 객체를 담을 수 있는 배열을 생성할 수 있다.**

```java
public class ObjectPolyExample2 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Car car = new Car();
		Object obj = new Object(); // Object 인스턴스도 만들 수 있다.
		
		Object[] objects = {dog,car,obj};
		
		size(objects);
	}
	
	private static void size(Object[] objects) {
		System.out.println("전달된 객체의 수 : " + objects.length);
	}
}
```

---

## Object가 없다면?

**1. `void action(Object obj)`과 같이 모든 객체를 받을 수 있는 `메서드`를 만들 수 없다.**

**2. `Object[] objects` 처럼 모든 객체를 저장할 수 있는 `배열`을 만들 수 없다.**

**3. `MyObject`와 같은 클래스를 만들고 모든 `클래스`에서 직접 정의한 `MyObject`를 
`상속`받으면 해당 기능을 구현할 수 있지만, 
하나의 `프로젝트`를 넘어 전세계 모든 개발자가 비슷한 `클래스`를 만들 것이고,
서로 호환되지 않는 수많은 `Xxx(땡땡땡)Object`들이 넘쳐날 것이다.**
