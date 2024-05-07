## 6번째 수업

### 리팩토링

### 이전 (리팩토링 전)

**숫자로 하면 즉 `매직넘버`로 하면 나중에 이 코드가 무엇인지 알아보기 힘들다.**

### Robot

```java
public class Robot {
	
	private String name;
	
	public Robot(String name) {
		this.name = name;
	}
	
	public void order(int command) {
		if(command == 0) { // 걷기
			System.out.println(name + " walk");
		}else if (command == 1) { //멈추기
			System.out.println(name + " stop");
		}else if(command == 2) { //점프
			System.out.println(name + " jump");
		}else {
			System.out.println(name + " error");
		}
	}
}

```

### Main

```java
public class RobotMain {
	public static void main(String[] args) {
		Robot robot = new Robot("Smith");
		
		robot.order(0);
		robot.order(1);
		robot.order(2);
		
		robot.order(3);
	}
}
```

---

### 이후 (리팩토링 이후)

**`상수화`를 이용하여 좀 더 코드를 알아보기 쉽게 `리팩토링` 해보자.**

**`상수처리`를 해두면 `중복값`이여도 구분 할 수 있다. (예 : 0 == Walk 0 == Stop)**

### Robot

```java
public class Robot {
	
	private String name;
	//우리가 필요한 명령어를 상수화 하기
	public static final int COMMAND_WALK = 0;
	public static final int COMMAND_STOP = 1;
	public static final int COMMAND_JUMP = 2;
	
	
	public Robot(String name) {
		this.name = name;
	}
	
	public void order(int command) {
		if(command == COMMAND_WALK) {
			System.out.println(name + " walk");
		}else if (command == COMMAND_STOP) {
			System.out.println(name + " stop");
		}else if(command == COMMAND_JUMP) {
			System.out.println(name + " jump");
		}else {
			System.out.println(name + " error");
		}
	}
}

```

### Main

```java
public class RobotMain {
	public static void main(String[] args) {
		Robot robot = new Robot("Smith");
		
		robot.order(robot.COMMAND_WALK);
		robot.order(robot.COMMAND_STOP);
		robot.order(robot.COMMAND_JUMP);
		
		robot.order(3);
	}
}

```

---

### 한번 더 발전

**`enum` 사용하여 코드를 좀 더 발전 시켜보자.**

### Robot

```java
public class Robot {
	
	private String name;
	
	public enum Command {
		WALK,
		STOP,
		JUMP,
	};
	
	
	public Robot(String name) {
		this.name = name;
	}
	
	public void order(Robot.Command command) {
		if(command == Command.WALK) {
			System.out.println(name + " walk");
		}else if (command == Command.STOP) {
			System.out.println(name + " stop");
		}else if(command == Command.JUMP) {
			System.out.println(name + " jump");
		}else {
			System.out.println(name + " error");
		}
	}
}
```

### Main

```java
public class RobotMain {
	public static void main(String[] args) {
		Robot robot = new Robot("Smith");
		
		robot.order(Robot.Command.WALK);
		robot.order(Robot.Command.STOP);
		robot.order(Robot.Command.JUMP);
		
		//robot.order(3);
	}
}
```

---

### **추상화의 단계**

**`공통적인 속성`들을 모아서 `추상화`를 해보자.**

### ex1

```java
public class CarMain {
	public static void main(String[] args) {
		ElectricCar electriccar = new ElectricCar();
		electriccar.Move();
		electriccar.charge();
		
		GasCar gascar = new GasCar();
		gascar.Move();
		gascar.fillUp();
		
	}
}
```

---

```java
public class ElectricCar {

	
	public void Move() {
		System.out.println("차를 이동합니다.");
	}
	
	public void charge() {
		System.out.println("충전합니다.");
	}
}
```

---

```java
public class GasCar {
	public void Move() {
		System.out.println("차를 이동합니다.");
	}
	
	public void fillUp() {
		System.out.println("가스를 채웁니다.");
	}
}
```

---

### ex2

**`부모 클래스(슈퍼 클래스)`: 상속을 통해 자신의 필드와 메서드를 다른 클래스에 제공하는 클래스(Car.java)**

**`자식 클래스(자식 클래스)`: 부모 클래스로부터 필드와 메서드를 상속받는 클래스(ElectricCar.java, GasCar.java)

자바는 `다중 상속`을 지원하지 않는다. 
그래서 `extends` 대상은 하나만 선택할 수 있다. (단일 상속)**

```java
public class CarMain {
	public static void main(String[] args) {
		/*
		부모 클래스(슈퍼 클래스): 상속을 통해 자신의 필드와 메서드를 다른 클래스에 제공하는 클래스(Car.java)
		자식 클래스(자식 클래스): 부모 클래스로부터 필드와 메서드를 상속받는 클래스(ElectricCar.java, GasCar.java)
		
		자바는 다중 상속을 지원하지 않는다. 그래서 extends 대상은 하나만 선택할 수 있다. (단일 상속)
		
		자바는 인터페이스의 다중 구현을 사용하면 다중 상속과 같은 기능을 사용할 수 있다.
		*/
		ElectricCar electriccar = new ElectricCar();
		electriccar.Move();
		electriccar.charge();
		
		GasCar gascar = new GasCar();
		gascar.Move();
		gascar.fillUp();
	}
	
}
```

---

```java
public class ElectricCar extends Car{
	/*
	전기차 ElectricCar extends Car를 이용해서 부모클래스인 Car를 상속 받는다.
	상속 덕분에 ElectricCar에서도 move()를 사용할 수 있다.
	*/
	public void charge() {
		System.out.println("충전합니다.");
	}
}
```

---

```java
public class GasCar extends Car{
	public void fillUp() {
		System.out.println("가스를 채웁니다.");
	}
}
```

---

### ex3

```java
public class CarMain {
	
	public static void main(String[] args) {
		ElectricCar electriccar = new ElectricCar();
		electriccar.Move();
		electriccar.charge();
		electriccar.OpenDoor();
		
		GasCar gascar = new GasCar();
		gascar.Move();
		gascar.fillUp();
		gascar.OpenDoor();
	}
	
}
```

---

```java
public class ElectricCar extends Car{
	public void charge() {
		System.out.println("충전합니다.");
	}
}

```

---

```java
public class GasCar extends Car{
	public void fillUp() {
		System.out.println("가스를 채웁니다.");
	}
}

```

---

### 오버라이딩

**`오버라이딩` 기능을 이용하여 전기차가 조용하고 빠르게 이동한다고 바꿔주자**

**메서드 `오버라이딩` 조건**

1. **`메서드 이름`: 이름이 같아야 한다.**
2. **`메서드 매개변수(파라미터)`: 타입, 순서, 개수가 같아야 한다.**
3. **`반환 타입`: 반환 타입이 같아야 한다. 
단 반환 타입이 하위 클래스 타입일 수 있다.**
4. **`접근 제어자`: 오버라이딩 메서드의 
`접근 제어자`는 상위 클래스의 메서드보다 더 제한적이어서는 안된다.**

**- 상위 클래스 메서드가 `protected`로 선언되어 있으면, 
하위 클래스에서는 `public` 또는 `protected`로 오버라이드 할 수있지만, `private`, `default`로 오버라이드 할 수 없다.**

5. `**예외`: `오버라이팅 메서드`는 상위 클래스의 메서드보다 더 많은 체크 예외를 `throws` 로 선언할 수 없다. 
하지만 `더 적거나 같은 수의 예외`, 
또는 `하위 타입의 예외`는 선언할 수 있다. (추후)** 

6. `**static, final, private`: 메서드 오버라이딩 될 수 없다.
- `static`은 클래스 레벨에서 작동하므로 
인스턴스 레벨에서 사용하는 `오버라이딩`이 의미가 없다. 
쉽게 이야기해서 그냥 클래스 이름을 통해 필요한 곳에 직접 접근하면 된다.

-`final` 메서드는 재정의를 금지한다. 상수는 값을 변경할 수 없다.

-`private` 메서드는 해당 클래스내에서만 접근 가능하기 때문에 하위 클래스에서 보이지 않는다.
생성자는 오버라이딩 할 수 없다.**

---

### 오버라이딩 기능을 이용한 전기차

```java
public class Car {
	public void Move() {
		System.out.println("차를 이동합니다.");
		
	}
	
	public void OpenDoor(){
		System.out.println("문을 엽니다.");
	}
}
```

---

```java
public class GasCar extends Car{
	public void fillUp() {
		System.out.println("가스를 채웁니다.");
	}
}

```

---

```java
public class ElectricCar extends Car{
	
	
	@Override 
	public void Move() {
		System.out.println("전기차를 빠르고 조용하게 이동합니다.");
	}
	
	public void charge() {
		System.out.println("충전합니다.");
	}
}
```

---

```java
public class CarMain {
	
	public static void main(String[] args) {
		ElectricCar electriccar = new ElectricCar();
		electriccar.Move();
		electriccar.charge();
		electriccar.OpenDoor();
		
		GasCar gascar = new GasCar();
		gascar.Move();
		gascar.fillUp();
		gascar.OpenDoor();
	}
	
}
```

---

```java
public class Car {
	public void Move() {
		System.out.println("차를 이동합니다.");
		
	}
	
	public void OpenDoor(){
		System.out.println("문을 엽니다.");
	}
}
```

---

### 오버라이딩 기능을 이용한 부모 자식 관계

```java
public class Parent {
	
	public int publicvalue;
	protected int protectedvalue;
	int defaultvalue;
	private int privatevalue;
	
	public void printParent() {
		
		System.out.println("== Parent 메서드 내부 ==");
		System.out.println("public : " + publicvalue);
		System.out.println("protected : " + protectedvalue);
		System.out.println("default : " + defaultvalue);
		System.out.println("private : " + privatevalue);
	}
}
```

---

```java
public class Child extends Parent{
	
	public void call() {
		publicvalue = 1;
		protectedvalue = 1;
		//defaultvalue = 1; 다른 패키지 접근 풀가
		//privatevalue = 1; // private 다른 클래스 접근 불가
		
		printParent();
	}
}
```

---

```java
public class ExtendsAccessMain {
	public static void main(String[] args) {
		Child child = new Child();
		child.call();
	}
}
```
