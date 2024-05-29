## 11번째 수업

### 다형성

## 복습하기

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/fa97d740-13f6-4ddc-9939-b86bb2c976d6/a3aa3cdd-c193-402a-b56d-f3704b6e08f2/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/fa97d740-13f6-4ddc-9939-b86bb2c976d6/b5220c36-fba2-424b-953f-f99726830a16/Untitled.png)

### K3Car

```java
public class K3Car {
	
	public void startEngine() {
		System.out.println("K3Car.startEngine");
	}
	
	public void offEngine() {
		System.out.println("K3Car.offEngine");
	}
	
	public void pressAccelerator() {
		System.out.println("K3Car.pressAccelerator");
	}
}
```

---

### Model3Car

```java
public class Model3Car {
	
	public void startEngine() {
		System.out.println("Model3Car.startEngine");
	}
	
	public void offEngine() {
		System.out.println("Model3Car.offEngine");
	}
	
	public void pressAccelerator() {
		System.out.println("Model3Car.pressAccelerator");
	}
}
```

---

### Driver

```java
public class Driver {
	
	private K3Car k3Car;
	private Model3Car model3Car;
	
	public void setK3Car(K3Car k3Car) {
		this.k3Car = k3Car;
	}
	
	public void setModel3Car(Model3Car model3Car) {
		this.model3Car = model3Car;
	}
	
	public void Drive() {
		System.out.println("자동차를 운전합니다");
		if(k3Car != null) {
			k3Car.startEngine();
			k3Car.pressAccelerator();
			k3Car.offEngine();
		}else if (model3Car != null) {
			model3Car.startEngine();
			model3Car.offEngine();
			model3Car.pressAccelerator();
		}
	}
}
```

---

### CarMain

```java
public class CarMain {
	public static void main(String[] args) {
		Driver driver = new Driver();
		K3Car k3Car = new K3Car();
		Model3Car model3car = new Model3Car();
		
		driver.setK3Car(k3Car);
		driver.Drive();
		driver.setK3Car(null);
		driver.setModel3Car(model3car);
		driver.Drive();
	}
}
```

---

## 이제 다형성을 이용해 변경해보자

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/fa97d740-13f6-4ddc-9939-b86bb2c976d6/af17e1e0-3629-423e-93c3-ff513c281715/Untitled.png)

**`인터페이스`를 이용하여 차가 늘어날때마다 `코드`를 쓰는 `어려움`을 빼보자**

### Car (인터페이스)

```java
public interface Car {
	
	void startEngine();
	
	void offEngine();
	
	void pressAccelerator();
}
```

---

### K3Car

```java
public class K3Car implements Car{
	
	@Override
	public void startEngine() {
		System.out.println("K3Car.startEngine");
	}
	
	@Override
	public void offEngine() {
		System.out.println("K3Car.offEngine");
	}
	
	@Override
	public void pressAccelerator() {
		System.out.println("K3Car.pressAcceleratorEngine");
	}
	
}

```

---

### Model3Car

```java
public class Model3Car implements Car{
	
	@Override
	public void startEngine() {
		System.out.println("Mpdel3Car.startEngine");
	}
	
	@Override
	public void offEngine() {
		System.out.println("Mpdel3Car.offEngine");
	}
	
	@Override
	public void pressAccelerator() {
		System.out.println("Mpdel3Car.pressAcceleratorEngine");
	}
}
```

---

### Driver

```java
public class Driver {
	
	private Car car;
	
	public void setCar(Car car) {
		System.out.println("자동차를 설정합니다 : " + car);
		this.car = car;
	}
	
	public void Drive() {
		System.out.println("자동차를 운전합니다");
		car.startEngine();
		car.offEngine();
		car.pressAccelerator();
	}
}
```

---

### CarMain

```java
public class CarMain {
	public static void main(String[] args) {
		
		Driver driver = new Driver();
		
		Car k3Car = new K3Car();
		Car model3Car = new Model3Car();
		
		driver.setCar(k3Car);
		driver.Drive();
		driver.setCar(model3Car);
		driver.Drive();
	}
}

```

## 이제 예제를 한 번 풀어보자

---

### 1번 예제

### 다중 메시지 발송

- 한 번에 여러곳에 `메시지`를 발송하는 `프로그램`을 개발하자
- `메인 코드`를 보고 `클래스`를 완성하시오.

### 요구사항

1. `다형성`을 활용해야 한다.
2. `Sender` 인터페이스를 구현하고 사용해야 한다.
3. `EmailSender.java`, `SmsSender.java`, `FaceBpplSender.jav`a 를 구현하시오.

### 실행결과

메일을 발송합니다 : 환영합니다!
SMS를 발송합니다 : 환영합니다!
페이스북에 발송합니다 : 환영합니다!

---

### SendMain

```java
public class SendMain {
	public static void main(String[] args) {
		Sender[] senders = {new EmailSender(), new SmsSender(), new FaceBookSender()};
		
		for (Sender sender : senders) {
			sender.sendMessage("환영합니다!");
		}
	}
}
```

---

### Sender(인터페이스)

```java
public interface Sender {
	void sendMessage(String message);
}
```

---

### EmailSender

```java
public class EmailSender implements Sender{
	@Override
	public void sendMessage(String message) {
		System.out.println("메일을 발송합니다 : " + message);
	}
}
```

---

### SmsSender

```java
public class SmsSender implements Sender{
	@Override
	public void sendMessage(String message) {
		System.out.println("SMS를 발송합니다 : " + message);
	}
}
```

---

### FaceBookSender

```java
public class FaceBookSender implements Sender{
	@Override
	public void sendMessage(String message) {
		System.out.println("페이스북에 발송합니다 : " + message);
	}
}
```

---

### 2번 예제

## 해당 코드들을 수정해보자

### BEFORE

### KakaoPay

```java
public class KakaoPay {
	
	public boolean pay(int amount) {
		System.out.println("카카오페이 시스템과 연결합니다.");
		System.out.println(amount + "원 결제를 시도합니다.");
		return true;
	}
}
```

---

### NaverPay

```java
public class NaverPay {
	
	public boolean pay(int amount) {
		System.out.println("네이버 시스템과 연결합니다.");
		System.out.println(amount + "원 결제를 시도합니다.");
		return true;
	}
}
```

---

### PayService

```java
public class PayService {
	public void processPay(String option, int amount) {
		boolean result;
		System.out.println("결제를 시작합니다 : option = " + option + ", amount = " + amount);
		if (option.equals("kakao")) {
			
			KakaoPay kakaoPay = new KakaoPay();
			result = kakaoPay.pay(amount);
			
		}else if (option.equals("naver")) {
			
			NaverPay naverPay = new NaverPay();
			result = naverPay.pay(amount);
			
		}else {
			
			System.out.println("결제 수단이 없습니다.");
			result = false;
		}
		
		if (result) {
			System.out.println("결제가 성공했습니다.");
		}else {
			System.out.println("결제에 실패했습니다.");
		}
	}
}
```

---

### PayMain0

```java
public class PayMain0 {
	public static void main(String[] args) {
		
		PayService payService = new PayService();
		
		// kakao 결제
		String payOption1 = "kakao";
		int amount1 = 5000;
		
		payService.processPay(payOption1, amount1);
		
		// naver 결제
		String payOption2 = "naver";
		int amount2 = 10000;
		
		payService.processPay(payOption2, amount2);
		
		// 잘못된 결제수단
		String payOption3 = "apple";
		int amount3 = 15000;
		
		payService.processPay(payOption3, amount3);
	}
}
```

---

### AFTER

### Pay (인터페이스)

```java
public interface Pay {
	boolean pay(int amount);
}
```

---

### KakaoPay

```java
public class KakaoPay implements Pay{
	
	@Override
	public boolean pay(int amount) {
		System.out.println("카카오페이 시스템과 연결합니다.");
		System.out.println(amount + "원 결제를 시도합니다.");
		return true;
	}
}
```

---

### NaverPay

```java
public class NaverPay implements Pay{
	
	@Override
	public boolean pay(int amount) {
		System.out.println("네이버 시스템과 연결합니다.");
		System.out.println(amount + "원 결제를 시도합니다.");
		return true;
	}
}
```

---

### PayService

```java
public class PayService {
	
	public void processPay(String option,int amount) {
		boolean result;
		System.out.println("결제를 시작합니다 : option = " + option + ", amount = " + amount);
		
		Pay pay = PayStore.findPay(option);
		result = pay.pay(amount);
		
		if (result) {
			System.out.println("결제가 성공했습니다.");
		}else {
			System.out.println("결제에 실패했습니다.");
		}
	}
}
```

---

### PayStore

```java
public abstract class PayStore {
	
	//결제 수단이 추가되거나 삭제되는 벼경이 일어나면 수정하는 부분
	public static Pay findPay(String option) {
		if(option.equals("kakao")) {
			return new KakaoPay();
		} else if (option.equals("naver")) {
			return new NaverPay();
		}else {
			return new DefaultPay();
		}
	}
}
```

---

### DefaultPay

```java
public class DefaultPay implements Pay{
	@Override
	public boolean pay(int amount) {
		System.out.println("결제 수단이 없습니다.");
		return false;
	}
}
```

---

### PayMain

```java
public class PayMain1 {
	public static void main(String[] args) {
		
		PayService payService = new PayService();
		
		// kakao 결제
		int amount1 = 5000;
		String payOption1 = "kakao";
		
		payService.processPay(payOption1,amount1);
		
		// naver 결제
		String payOption2 = "naver";
		int amount2 = 10000;
		
		payService.processPay(payOption2, amount2);
		
		// 잘못된 결제수단
		String payOption3 = "apple";
		int amount3 = 15000;
		
		payService.processPay(payOption3, amount3);
	}
}
```
