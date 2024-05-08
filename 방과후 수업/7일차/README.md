## 7번째 수업

**부모와 자식의 필드명이 같거나 메서드 오버라이딩 되어 있으면, 
자식에서 부모의 필드나 메서드를 호출할 수 없다.**

**이 때 `super` 키워드를 사용하면 부모를 참조할 수 있다.**

**`super` : 이름 그대로 부모 클래스에 대한 참조를 나타낸다.**

---

### **super 기능 실습**

### 부모

```java
public class Parent {
	public String value = "Parent";
	
	public void hello() {
		System.out.println("Parent.hello");
	}
}
```

---

### 자식

```java
public class Child extends Parent{
	public String value = "child";
	
	@Override
	public void hello() {
		System.out.println("child.hello");
	}
	
	public void call() {
		System.err.println("자식의 값: "+ this.value); // this는 생략 가능
		System.out.println("부모의 값: " + super.value);
		
		this.hello(); //this는 생략 가능
		super.hello(); 
	}
}
```

---

### 메인

```java
public class Super1Main {
	public static void main(String[] args) {
		Child child = new Child();
		child.call();
	}
}
```

### 결과

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/fa97d740-13f6-4ddc-9939-b86bb2c976d6/59e0e3de-4337-4167-ad59-360c8925fcfb/Untitled.png)

---

**`super` - 생성자
상속관계의 인스턴스를 생성하면 결국 
메모리 내부에는 자식과 부모 클래스가 각각 만들어진다.**

**`Child`를 만들면 부모인 `Parent` 까지 함께 만드러지는 것이다.
따라서 각각의 생성자도 모두 호출되어야 한다.**

**`상속 관계`를 사용하면 자식 클래스의 
생성자에서 부모 클래스의 생성자를 반드시 호출해야 한다.(규칙)**

**`상속 관계`에서 부모인 생성자를 호출할 때는 `super()`를 사용하면 된다**.

---

### super를 가지고 생성자 확인하기

1. **`상속 관계`의 생성자 호출은 결론적으로 부모에서 자식 순서로 실행된다.
따라서 부모의 데이터를 먼저 초기화하고, 
그 다음에 자식의 데이터를 초기화한다.**
2. **`상속 괸계`에서 자식 클래스의 생성자 
첫 줄에 반드시 `super(…)`를 호출해야 한다.
단, 기본 생성자 `( super() )`인 경우 생략할 수 있다.**

---

### ClassA

```java
public class ClassA {
	
	public ClassA() {
		System.out.println("ClassA의 생성자");
	} 
}
```

---

### ClassB

```java
public class ClassB extends ClassA{
	
	public ClassB(int a) {
		//super() 사용하면 안 됨.
		// super는 한 번만 사용함.
		this(a, 0); //생략 가능
	}
	
	public ClassB(int a, int b) {
		super(); //생략 가능
		System.out.println("ClassB 생성자 a = " + a + ", b = " + b);
	}
}
```

---

### ClassC

```java
public class ClassC extends ClassB{
	//내 부모가 생성자가 없으면 무조건 기본 생성자를 호출해줘야 오류가 안난다.
	
	public ClassC() {
		super(10, 20); //따라서 무조건 super를 써줘야 오류가 안난다.
		System.out.println("ClassC 생성자");
	}
}
```

---

### 메인

```java
public class Super2Main {
	public static void main(String[] args) {
		
		ClassC classc = new ClassC();
		
		ClassB classb = new ClassB(5);
		
	}
}

```

### 결과

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/fa97d740-13f6-4ddc-9939-b86bb2c976d6/e7ec6709-59c6-4300-b70a-8ff3427d9484/Untitled.png)

---

### 알고 있어야 하는 것

**클래스와 메서드에 사용되는 `final`**

1. **클래스에 `final`
a. 상속 끝!
b. `final`로 선언된 클래스는 확장할 수 없다. 다른 클래스가 `final`로
선언된 클래스를 상속받을 수 없다.
c. `public final class MyFinalClass() { … }`**
2. **메서드에 `final`
a. 오버라이딩 끝!
b. `final`로 선언된 메서드는 오버라이딩 될 수 없다. 
상속받은 서브 클래스에서 이 메서드를 변경할 수 없다.
c. `public final void MyFinalMethod() { … }`**

---

### 문제 풀기

상속 상품

쇼핑물의 판매 상품을 보자.

- Book, Album, Movie 이렇게 3가지 상품을 클래스로 만들자.
- 코드 중복이 없게 상속 관계를 사용하자. 
부모 클래스는 item이라는 이름을 사용하자.
- 공통 속성 : name, price
    - Book : 저자(author), isbn( isbn )
    - Album : 아티스트 ( artist )
    - Movie : 감독 (director ), 배우 : (actor)

ShopMain.java

실행 결과

이름:JAVA, 가격:10000

- 저자:han, isbn:12345

이름:앨범1, 가격:15000

- 아티스트:seo

이름:영화1, 가격:18000

- 감독:감독1, 배우:배우1

상품 가격의 합: 43000

### item

```java
public class item {
	
	private String name;
	private int price;
	
	public item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	void print() {
		System.out.println("이름 : "+ name + ", 가격 : " + price);
	}
	
	public int getPrice() {
		return price;
	}
}
```

### Book

```java
	private String author;
	private String isbn;
	
	
	public Book(String name, int price, String c, String d) {
		super(name,price);
		this.author = c;
		this.isbn = d;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("- 저자 : " + author + ", isbn : " + isbn);
	}
	
}
```

### Movie

```java
public class Movie extends item{
	public String director;
	public String actor;
	
	public Movie(String name, int price, String c, String d) {
		super(name,price);
		director = c;
		actor = d;
		
	}

	@Override
	public void print() {
		super.print();
		System.out.println("- 감독 : " + director + ", 배우 : " + actor);
	}
	

}

```

### Album

```java
public class Album extends item{
	public String artist;
	
	public Album(String name, int price, String c) {
		super(name, price);
		artist = c;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("- 아티스트 : " + artist);
	}
}
```
