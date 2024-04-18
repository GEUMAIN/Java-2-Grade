## 첫 수업 클래스 복습

### 조건

**클래스 2개 생성**

**`ProductOrder`**

**`ProductOrderMain`**

**요구사항**

**`ProductOrder`클래스**

**멤버변수**

**1. `productName` (상품명)**

**2. `price` (가격)**

**3. `quantity` (주문 수량)**

**`ProductOrderMain` 클래스 안에 main() 메서드를 포함하여, 여러 상품의 주문 정보를**

**배열로 관리하고, 그 정보를 출력하고, 최종 결제 금액을 계산하여 출력**

**입력값**

**두부 2000 2**

**김치 5000 1**

**콜라 1500 2**

**출력예시**

**상품명: 두부, 가격: 2000, 수량: 2**

**상품명: 김치, 가격: 5000, 수량: 1**

**상품명: 콜라, 가격: 1500, 수량: 2**

**총 결제 금액: 12000**

### 클래스

public class ProductOrder {
	String productName;
	int price;
	int quantity;
}

### 메인코드

	public static void main(String[] args) {
		ProductOrder[] pro = new ProductOrder[3];
		pro[0] = new ProductOrder();
		pro[1] = new ProductOrder();
		pro[2] = new ProductOrder();
		
		int sum = 0;
		
		pro[0].productName = "두부";
		pro[0].price = 2000;
		pro[0].quantity = 2;
		
		pro[1].productName = "김치";
		pro[1].price = 5000;
		pro[1].quantity = 1;
		
		pro[2].productName = "콜라";
		pro[2].price = 1500;
		pro[2].quantity = 2;
		
		for (int i = 0; i < pro.length; i++) {
			System.out.println("상품명 : " + pro[i].productName + ", 가격 : " + pro[i].price + ", 수량 : " + pro[i].quantity);
			sum = sum + pro[i].price * pro[i].quantity;
		}
		System.out.println("총 결재 금액 : " + sum);
	}

## 객체 지향

**`절차 지향`은 실행 순서를 중시하는 방법이지만**

**`객체 지향`은 객체를 중시하는 방법이다.**

**`절차 지향` - 데이터와 해당 데이터에 대한 처리방식이 분리 되어 있음.**

**`객체 지향` - 데이터와 그 데이터에 대한 행동(메서드)이 하나의 ‘객체’안에 포함되어**

**있다.**

### **예제**

**요구사항**

1. **음악 플레이어를 켜고 끌 수 있어야 한다.**
2. **음악 플레이어의 볼륨을 증가, 감소할 수 있어야 한다.**
3. **음악 플레이어의 상태를 확인할 수 있어야 한다.**

### 위에서부터 실행하는 절차형 코드 예시

	public static void main(String[] args) {
		boolean isOn = false;
		int volume = 0;
		
		// 음악 플레이어 켜기
		isOn = true;
		System.out.println("음악 플레이어를 시작합니다.");
		
		// 볼륨 증가
		volume++;
		System.out.println("현재 볼륨 : " + volume);
		
		// 볼륨 증가
		volume++;
		System.out.println("현재 볼륨 : " + volume);
		
		// 볼륨 감소
		volume--;
		System.out.println("현재 볼륨 : " + volume);
		
		//음악 플레이어 상태
		if(isOn) {
			System.out.println("음악 플레이어 ON, 볼룸 : " + volume);
		}else {
			System.out.println("음악 플레이어 OFF");
		}
		
		//음악 플레이어 끄기
		isOn = false;
		System.out.println("음악 플레이어를 종료합니다.");
	}

### 결과

음악 플레이어를 시작합니다.
현재 볼륨 : 1
현재 볼륨 : 2
현재 볼륨 : 1
음악 플레이어 ON, 볼룸 : 1
음악 플레이어를 종료합니다.

### 메서드 만들어서 활용하기

	public static void main(String[] args) {
		MusicPlayerData data = new MusicPlayerData();
		int sum = 0;
		// 음악 플레이어 켜기
		on(data);
		
		// 볼륨 증가
		volumeUp(data);
		
		// 볼륨 증가
		volumeUp(data);
		
		// 볼륨 감소
		volumeDown(data);
		
		//음악 플레이어 상태
		showStatus(data);
		
		//음악 플레이어 끄기
		off(data);
	}
	
	public static void volumeUp(MusicPlayerData data) {
		data.volume += 1;
		System.out.println("현재 볼륨 : " +  data.volume);
	}
	
	public static void volumeDown(MusicPlayerData data) {
		data.volume -= 1;
		System.out.println("현재 볼륨 : " +  data.volume);
	}
	
	public static void on(MusicPlayerData data) {
		data.isOn = true;
		System.out.println("음악 플레이어를 시작합니다.");
	}
	public static void off(MusicPlayerData data) {
		data.isOn = false;
		System.out.println("음악 플레이어를 종료합니다.");
	}
	
	public static void showStatus(MusicPlayerData data) {
		if(data.isOn) {
			System.out.println("음악 플레이어 ON, 볼룸 : " +  data.volume);
		}else {
			System.out.println("음악 플레이어 OFF");
		}
	}

**각각의 기능을 메서드로 만든 덕분에 각각의 기능이 모듈화가 되었다.
따라서 다음과 같은 장점이 생긴다.**

**1. `중복제거` : 로직 중복이 제거되었다.
같은 로직이 필요하면 해당 메서드를 여러번 호출하면 된다.**

**2. `변경 영향 범위` : 기능을 수정할 때 해당 메서드 내부만 변경하면 된다.**

**3. `메서드` 이름 추가 : 메서드 이름을 통해 코드를 좀 더 쉽게 이해할 수 있다.**

### **모듈화 - 레고블록을 생각하자!!**

**레고에서 필요한 블럭을 가져다 꼽아서 사용할 수 있듯이**

**여기서는 음악 플레이어의 기능이 필요하면 해당 기능을 메서드 호출만으로 손쉽게 사용할 수 있다.**

**이제 음악 플레이어와 관련된 메서드를 조립해서 프로그램을 작성할 수 있다.**

### 멤버 변수와 메서드를 합쳐보자 ( 객체 지향 )

	public class MusicPlayer {
	boolean isOn;
	int volume;
	
	public void volumeUp() {
		volume += 1;
		System.out.println("현재 볼륨 : " +  volume);
	}
	
	public void volumeDown() {
		volume -= 1;
		System.out.println("현재 볼륨 : " +  volume);
	}
	
	public void on() {
		isOn = true;
		System.out.println("음악 플레이어를 시작합니다.");
	}
	public void off() {
		isOn = false;
		System.out.println("음악 플레이어를 종료합니다.");
	}
	
	public void showStatus() {
		if(isOn) {
			System.out.println("음악 플레이어 ON, 볼룸 : " + volume);
		}else {
			System.out.println("음악 플레이어 OFF");
		}
	}
}

	public static void main(String[] args) {
		MusicPlayer player = new MusicPlayer();
		// 음악 플레이어 켜기
		player.on();
		
		// 볼륨 증가
		player.volumeUp();
		
		// 볼륨 증가
		player.volumeUp();
		
		// 볼륨 감소
		player.volumeDown();
		
		//음악 플레이어 상태
		player.showStatus();
		
		//음악 플레이어 끄기
		player.off();
	}

**`객체 지향`에 아주 종요한 언어 : 캡슐화**

**`MusicPlayer`를 보면 음악 플레이어를 구성하기 위한
속성과 기능이 마치 하나의 갭슐에 쌓여있는 것 같다.**

**이렇게 속성과(`필드, 멤버변수`)과 기능(`메서드`)을 하나로 묶어서
필요한 기능을 메서드를 통해 외부에 제공하는 것을
캡슐화라고 한다.**

**요즘에 아주 중요한 보안에 유리해지기도 한다.**

### 문제

**사각형의 넓이를 구하시오.
사각형의 둘레 길이를 구하시오.
정사각형인지 여부를 확인하시오.

객체지향으로 만들어보자.**

	public class Rectangle {
	int widths;
	int height;
	boolean square;
	
	public void area() {
		System.out.println("넓이 : " + (widths * height));
	}
	
	public void round() {
		System.out.println("둘레 : " + ((widths * 2) + (height * 2)));
	}
	public void realsquare() {
		if(widths == height) {
			square = true;
			if(square) System.out.println("정사각형입니다.");
		}else {
			square = false;
			System.out.println("정사각형 아닙니다.");
		}
	}
}

	public static void main(String[] args) {
		Rectangle rect = new Rectangle();
		
		rect.height = 5;
		rect.widths = 5;
		
		rect.area();
		rect.round();
		rect.realsquare();
	}

### 결과

### 가로 세로가 같을 시

넓이 : 25
둘레 : 20
정사각형입니다.

### 가로 세로가 다를 시

넓이 : 35
둘레 : 24
정사각형 아닙니다.
