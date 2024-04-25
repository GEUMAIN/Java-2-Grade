### 패키지

## **패키지**

**쇼핑물 시스템 개발자**

**작은 프로그램 클래스
Order()
User()
Product()**

---

**패키지 주의사항
1. 패키지는 사용하는 경우 항상 코드 첫 줄에 패키지 이름을 적어주어야 한다.**

1. **패키지의 이름과 위치는 `폴더(디렉터리)` 위치와 같아야 한다. (필수)**
2. **패키지의 이름은 모두 소문자를 사용한다. (관례)**
3. **패키지의 이름의 앞 부분에는 일반적으로 
회사와 도메인 이름을 거꾸로 사용한다. (관례)
예: -`com.company.myapp` 과 같이 사용한다. (관례)

- 수 많은 외부 라이브러리가 함께 사용되면 
같은 패키지에 같은 클래스 이름이 존재할 수도 있다.

- 이렇게 도메인 이름을 거꾸로 사용하면 이런 문제를 방지할 수 있다.

- 오픈소스나 라이브러리를 만들어서 
외부에 제공한다면 위의 관례를 꼭 지키는 것이 좋다.

- 내가 만든 애플리케이션을 다른 곳에 공유하지 않고, 직접 배포한다면
보통 문제가 되지 않는다.**

---

**패키지 안에 패키지는**

**하위패키지가 아니고 별개의 패키지이다.**

---

**`Pack`안에 `Data`에서 선언할 때**

**`Pack.a`에 있는 `User`는 완전 별개의 다른 패키지이기 때문에 
경로를 써주거나 경로를 임포트 해줘야한다.**

```java
Data data = new Data();
		User user = new User();
```

```java
Data data = new Data();
		pack.a.User user = new pack.a.User();
```

---

## **요구사항**

**예 : com.sungilshop.com**

**user (패키지)**

**User(클래스)**

```java
package com.sungilshop.user;

public class User {
	String userid;
	String name;
	
}
```

**UserService(클래스)**

**product(패키지)**

**Product(클래스)**

```java
package com.sungilshop.product;

public class Product {
	String productid;
	int price;
}
```

**ProductService(클래스)**

**order(패키지)**

**Order(클래스)**

```java
package com.sungilshop.order;

import com.sungilshop.product.Product;
import com.sungilshop.user.User;

public class Order {
	User user;
	Product product;
	
	public Order(User user, Product product) {
		this.user = user;
		this.product = product;
	}
}
```

**OrderService(클래스)**

```java
package com.sungilshop.order;

import com.sungilshop.product.Product;
import com.sungilshop.user.User;

public class OrderSerivce {
	public void order() {
		User user = new User();
		Product product = new Product();
		Order order = new Order(user, product);
	}
}
```

**OrderHistory(클래스)**

### 접근제어자

## **접근제어자**

- **자바는 접근제어자를 제공한다.**
- **접근 제어자를 사용하면 해당 클래스 외부에서
특정 필드나 메서드에 접근하는 것을 제한할 수 있다.**

---

**예를 들어,**

**스피커에 돌아가는 소프트웨어를 개발한다고 가정해보자.**

**요구사항 - 음량은 절대로 `100`을 초과하면 안된다. → 부폼이 고장난다.**

**스피커는 볼륨증가, 볼륨감소, 현재음량 확인하는 기능만 구현한다.**

- **볼륨은 `10`씩 증가 또는 감소**
- **켤 때는 생성자를 통해 `초기값(초기음량)` 적용할 수 있게 한다.**

**요구사항은 꼭 지켜서 개발한다.**

---

### Speaker

```java
public class Speaker {
	private int volume;
	
	public Speaker(int volume) {
		this.volume = volume;
	}
	
	void volumeUp() {
		if(volume >= 100) {
			System.out.println("음량을 증가할 수 없습니다. 최대 음량입니다.");
		}else {
			volume += 10;
			System.out.println("음량을 10 증가합니다.");
		}
	}
	
	void volumeDown() {
		volume -= 10;
		System.out.println("음량을 10 감소합니다.");
	}
	
	void showVolume() {
		System.out.println("현재 음량 : "+ volume);
	}
}

```

### SpeakerMain

```java
public static void main(String[] args) {
		Speaker speaker = new Speaker(90);
		speaker.showVolume();
		
		speaker.volumeUp();
		speaker.showVolume();
		
		speaker.volumeUp();
		speaker.showVolume();
		
		//필드에 직접 접근
		System.out.println("volume 필드 직접 접근 수정");
		//speaker.volume = 200;
		//speaker.showVolume(); 결과 -> 200
	}
```

---

**접근 제어자 종류**

- **자바는 4가지 종류의 접근제어자를 제공한다.**
    1. `**private` : 모든 외부 호출을 막는다.**
    2. **`default` : 같은 패키지 안에서 호출은 허용한다.**
    3. **`protected` : 같은 패키지 안에서 호출은 허용한다. 
    패키지가 달라도 상속관계의 호출은 허용한다.**
    4. **`public` : 모든 외부 호출을 허용한다.**
    

**접근 힘든 순서**

**`private → default → protected → public`**

---

`**접근 제어자`는 필드와 `메서드, 생성자`에 사용된다.**

`**클래스` 레벨에도 일부 `접근 제어자`만 사용할 수 있다. (`public, default`)**

---

### AccessData

```java
public class AccessData {
	
	public int publicfield;
	int defaultfield;
	private int privatefield;
	
	public void publicMetod() {
		System.out.println("publicMetod 호출 " + publicfield);
	}
	
	void defaultMetod() {
		System.out.println("defaultMetod 호출 " + defaultfield);
	}
	
	private void privateMetod() {
		System.out.println("privateMetod 호출 " + privatefield);
	}
	
	public void innerAccess() {
		System.out.println("내부 호출");
		publicfield = 100;
		defaultfield = 200;
		privatefield = 300;
		
		publicMetod();
		defaultMetod();
		privateMetod();
	}
}
```

### AccessInnerMain

```java
public static void main(String[] args) {
		AccessData data = new AccessData();
		
		// public
		data.publicfield = 1;
		data.publicMetod();
		
		//default - 같은 패키지니까 호출이 가능
		data.defaultfield = 2;
		data.defaultMetod();
		 
		//private - 다른 클래스에서 호출 불가
		//data.privatefield = 3;
		//data.privateMethod();
		
		data.innerAccess(); //private로 막아놨어도 내부에서 private를 호출해서 할 수 있는 public메서드가 있다면 호출할 수 있다.
	}
```

### AccessOuterMain

```java
public static void main(String[] args) {
		AccessData data = new AccessData();
		
		// public
		data.publicfield = 1;
		data.publicMetod();
		
		//default - 같은 패키지니까 호출이 가능
		//data.defaultfield = 2;
		//data.defaultMetod();
		 
		//private - 다른 클래스에서 호출 불가
		//data.privatefield = 3;
		//data.privateMethod();
		
		data.innerAccess(); //private로 막아놨어도 내부에서 private를 호출해서 할 수 있는 public메서드가 있다면 호출할 수 있다.
	}
```

---

### 제공할 것과 제공하지 않을 것을 적절하게 사용한 캡슐

```java
public class BankAccount {
	private int balance;
	
	public BankAccount() {
		balance = 0;
	}
	
	public void deposit(int amount) {
		if (isAmountValid(amount)) {
			balance += amount;
		}else {
			System.out.println("유효하지 않은 금액입니다.");
		}
	}
	
	public void withdraw(int amount) {
		if(isAmountValid(amount) && balance - amount > 0) {
			balance -= amount;
		}else {
			System.out.println("유효하지 않은 금액이거나 잔액이 부족합니다");
		}
	}
	
	public int getBalance() {
		return balance;
	}
	
	private boolean isAmountValid(int amount) {
		return amount > 0;
	}
}
```

### 출력하기

```java
public static void main(String[] args) {
		BankAccount account = new BankAccount();
		
		account.deposit(10000);
		account.withdraw(3000);
		System.out.println("잔액 : "+ account.getBalance());
		
		account.deposit(-1999);
		account.withdraw(10000);
	}
```

---
