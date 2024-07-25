### 17번째 수업

### 재네릭스

### **재네릭스란?**

- **클래스나 메서드를 정의할 때 테이블 메개변수로 사용할 수 있는 기능이다.**
- **코드의 재사용성을 높이고, 컴파일 시 타입 체크를 통해 오류를 방지할 수 있다.**

### **장점!!**

- **타입 안정성 : 컴파일 시 타입을 체크하여 잘못된 타입 사용을 방지한다.**
- **코드 재사용성 : 다양한 타입을 하나의 코드로 처리할 수 있다.**
- **가독성 향상 : 코드의 의도를 명확하게 나타낼 수 있다.**

---

### 수정 전

```java
public class GenericsMain {
	public static void main(String[] args) {
		int[] iArray = {1, 2, 3, 4, 5};
		double[] dArray = {1.0, 2.0, 3.0, 4.0, 5.0};
		String[] sArray = {"A", "B", "C", "D", "E"};
		
		printIntArray(iArray);
		printDoubleArray(dArray);
		printStringArray(sArray);
	}
	
	private static void printStringArray(String[] sArray) {
		for(String s : sArray) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
	
	private static void printDoubleArray(double[] dArray) {
		for(double d : dArray) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
	
	private static void printIntArray(int[] iArray){
		for(int i : iArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
```

---

### 수정 후 (재네릭 메서드 생성)

```java
public class GenericsMain {
	public static void main(String[] args) {
		Integer[] iArray = {1, 2, 3, 4, 5};
		Double[] dArray = {1.0, 2.0, 3.0, 4.0, 5.0};
		String[] sArray = {"A", "B", "C", "D", "E"};
		
		//재네릭은 래퍼 클래스만 가능하다
		
		printAnyArray(iArray);
		printAnyArray(dArray);
		printAnyArray(sArray);
	}
	
	// 재네릭 메서드 생성
	// T : Type
	// E : Element
	// K : Key
	// V : Value
	
	private static <T> void printAnyArray(T[] Array) {
		for(T t : Array) {
			System.out.print(t + " ");
		}
		System.out.println();
	}
}
```

---

### 재네릭 클래스란?

- **클래스를 정의 시 타입을 메개변수로 받을 수 있는 클래스를 의미한다.**
- **다양한 타입을 처리할 수 있는 클래스이다.**

### **장점!!**

- **타입 안정성**
- **코드 재사용성**
- **가독성 향상**

---

### 커피숍 만들기

### 재네릭 사용 X

### Number

```java
public class CoffeeByNumber {

	public int waitingNumber;
	
	public CoffeeByNumber(int waitingNumber) {
		this.waitingNumber = waitingNumber;
	}
	
	public void ready() {
		System.out.println("커피 준비 완료 : " + waitingNumber);
	}
}
```

---

### NickName

```java
public class CoffeeByNickname {
	
	public String nickname;
	
	public CoffeeByNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void ready() {
		System.out.println("커피 준비 완료 : " + nickname);
	}
}
```

---

### Main

```java
public class CoffeeMain {
	public static void main(String[] args) {
		
		CoffeeByNumber c1 = new CoffeeByNumber(10);
		c1.ready();
		
		CoffeeByNickname c2 = new CoffeeByNickname("유재석");
		c2.ready();
		
		System.out.println("----------------------");
	}
}
```

---

### 다형성 사용(Object)

```java
public class CoffeeByName {
	public Object name; // Integer, Double, String ...
	
	public CoffeeByName(Object name) {
		this.name = name;
	}
	
	public void ready() {
		System.out.println("커피 준비 완료 : " + name);
	}
}
```

---

```java
		CoffeeByName c3 = new CoffeeByName(11);
		c3.ready();
		
		CoffeeByName c4 = new CoffeeByName("박명수");
		c4.ready();
```

---

### 문제점

```java
int c3Name = (int)c3.name;
		System.out.println("주문한 고객 번호 : " + c3Name);
		
		String c4Name = (String)c4.name;
		System.out.println("주문 고객 이름 : " + c4Name);
```

**해당 코드처럼 쓸 경우** 

```java
c4Name = (String)c3.name;
```

**해당 코드를 쓸 경우 런타임 오류가 생긴다.**

---

### 재네릭 사용 O

```java
public class Coffee <T> {
	public T name;
	
	public Coffee(T name) {
		this.name = name;
	}
	
	public void ready() {
		System.out.println("커피 준비 완료 : " + name);
	}
}
```

---

```java
//재네릭 클래스 사용
		Coffee<Integer> c5 = new Coffee<>(12);
		c5.ready();
		
		int c5Name = c5.name;
		System.out.println("주문 고객 번호 : " + c5Name);
		
		Coffee<String> c6 = new Coffee<>("하하");
		c6.ready();
		
		String c6Name = c6.name;
		System.out.println("주문 고객 이름 : " + c6Name);
```

---

### 사용자 이름과 포인트 적립

```java
public class User {
	public String name;
	
	public User(String name) {
		this.name = name;
	}
	
	public void addPoint() {
		System.out.println(this.name + "님, 포인트 적립되었습니다.");
	}
}
```

---

```java

public class VipUser extends User{
	public VipUser(String name) {
		super("특별한 고객 " + name);
	}
}
```

---

```java
		CoffeeByUser<User> c7 = new CoffeeByUser<>(new User("노홍철"));
		c7.ready();
		
		CoffeeByUser<User> c8 = new CoffeeByUser<>(new VipUser("정형돈"));
		c8.ready();
```

---

### 여러개의 재네릭 사용 (다중 재네릭 타입 메개변수 메서드)

```java
	public static <T> void orderCoffee(T name) {
		System.out.println("커피 준비 완료 : " + name);
		
	}
	
	public static <T, V> void orderCoffee(T name, V coffee) {
		System.out.println(coffee + " 준비 완료 : " + name);
	}
```

---

```java
		orderCoffee("홍길동");
		orderCoffee("장발장", "아메리카노");
```

---

### 문제 풀기

### **문제 1: 다중 타입의 상자 클래스**

다양한 타입의 아이템을 담을 수 있는 상자 클래스를 제네릭스를 사용하여 구현하세요. 이 상자 클래스는 두 가지 타입의 아이템을 담을 수 있어야 합니다. 상자 클래스는 다음 조건을 만족해야 합니다.

**클래스 이름**: Box

**제네릭 타입**: 두 개의 타입 매개변수 T와 U를 가집니다.

**필드**:

첫 번째 아이템을 담는 item1 (타입: T)

두 번째 아이템을 담는 item2 (타입: U)

**생성자**: 두 개의 매개변수를 받아 각각 item1과 item2를 초기화합니다.

**메서드**:

getItem1(): 첫 번째 아이템을 반환합니다.

getItem2(): 두 번째 아이템을 반환합니다.

displayItems(): 두 아이템을 출력합니다.

다음 예제와 같은 코드가 실행될 수 있도록 Box 클래스를 작성하세요.

```java
public class Main {
    public static void main(String[] args) {
        Box<String, Integer> box1 = new Box<>("Apple", 10);
        box1.displayItems();

        Box<Double, Character> box2 = new Box<>(3.14, 'A');
        box2.displayItems();
    }
}
```

출력 예시:

```
Item 1: Apple, Item 2: 10
Item 1: 3.14, Item 2: A
```

### 내 풀이

```java
public class Box <T, U>{
	public T item1;
	public U item2;
	
	public Box(T item1, U item2) {
		this.item1 = item1;
		this.item2 = item2;
	}
	
	public T getItem1() {
		return item1;
	}
	
	public U getItem2() {
		return item2;
	}
	
	public void displayItems() {
		System.out.println("Item 1 : "+ item1 + ", Item 2 : " + item2 );
	}
}
```

---

```java
public class Main {
	public static void main(String[] args) {
		Box<String, Integer> box1 = new Box<>("Apple", 10);
        box1.displayItems();

        Box<Double, Character> box2 = new Box<>(3.14, 'A');
        box2.displayItems();
	}
}
```

---

### 문제 2: 사용자와 상품 관리 클래스

사용자와 상품 정보를 저장하고 관리하는 제네릭 클래스를 구현하세요. 이 클래스는 다음 조건을 만족해야 합니다.

1. **클래스 이름**: `Manager`
2. **제네릭 타입**: 두 개의 타입 매개변수 `U`와 `P`를 가집니다. `U`는 사용자(User) 타입, `P`는 상품(Product) 타입입니다.
3. **필드**:
    - 사용자 정보를 담는 `user` (타입: `U`)
    - 상품 정보를 담는 `product` (타입: `P`)
4. **생성자**: 사용자와 상품을 매개변수로 받아 각각 `user`와 `product`를 초기화합니다.
5. **메서드**:
    - `getUser()`: 사용자 정보를 반환합니다.
    - `getProduct()`: 상품 정보를 반환합니다.
    - `displayInfo()`: 사용자와 상품 정보를 출력합니다.

다음 예제와 같은 코드가 실행될 수 있도록 `Manager` 클래스를 작성하세요.

```java
public class Main {
    public static void main(String[] args) {
        User user = new User("John Doe");
        Product product = new Product("Laptop", 1500);

        Manager<User, Product> manager = new Manager<>(user, product);
        manager.displayInfo();
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
```

출력 예시:

```
User: John Doe
Product: Laptop, Price: 1500.0
```

### 내 풀이

```java
public class Manager <U, P>{
	public U user;
	public P product;
	
	public Manager(U user, P product) {
		this.user = user;
		this.product = product;
	}
	
	public U getUser() {
		return user;
	}
	
	public P getProduct() {
		return product;
	}
	
	public void displayInfo() {
		System.out.println("User: " + getUser());
		System.out.println("Product: " + getUser() + ", Price: " + getProduct());
	}
}

```

---

```java
public class Main {
    public static void main(String[] args) {
        User user = new User("John Doe");
        Product product = new Product("Laptop", 1500);

        Manager<User, Product> manager = new Manager<>(user, product);
        manager.displayInfo();
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
```

---

---

### **문제 3: 커피 주문 관리 클래스**

커피 주문을 관리하는 제네릭 클래스를 구현하세요. 이 클래스는 다음 조건을 만족해야 합니다.

**클래스 이름**: CoffeeOrder

**제네릭 타입**: 하나의 타입 매개변수 T를 가집니다.

**필드**:

주문자 정보를 담는 customer (타입: T)

커피 이름을 담는 coffeeName (타입: String)

**생성자**: 주문자와 커피 이름을 매개변수로 받아 각각 customer와 coffeeName을 초기화합니다.

**메서드**:

getCustomer(): 주문자 정보를 반환합니다.

getCoffeeName(): 커피 이름을 반환합니다.

displayOrder(): 주문자와 커피 이름을 출력합니다.

다음 예제와 같은 코드가 실행될 수 있도록 CoffeeOrder 클래스를 작성하세요.

```java
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice");
        CoffeeOrder<Customer> order = new CoffeeOrder<>(customer, "Espresso");
        order.displayOrder();
    }
}

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

출력 예시:

```
Customer: Alice
Coffee: Espresso
```

### 내 풀이

```java
public class CoffeeOrder <T>{
	public T customer;
	public String coffeeName;
	
	public CoffeeOrder(T customer, String coffeeName) {
		this.coffeeName = coffeeName;
		this.customer = customer;
	}
	
	public String getCoffeeName() {
		return coffeeName;
	}
	
	public T getCustomer() {
		return customer;
	}
	
	public void displayOrder() {
		
	}
}
```

---

```java
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice");
        CoffeeOrder<Customer> order = new CoffeeOrder<>(customer, "Espresso");
        order.displayOrder();
    }
}

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

---
