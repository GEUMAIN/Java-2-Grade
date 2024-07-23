### 15번째 수업

### 복습

### enum

### Java Enum (열거형)

- **`Enum`은 상수의 집합을 정의하는데 사용되는 
특별한 `Java`의 타입이다.**
- **열거형은 월, 요일, 방향 등과 같은 미리 
정의된 상수의 집합을 표현하는데 사용할 수 있다.**

### 예제

- **달: JAN, FEB, MAR ...**
- **옷 사이즈 : S, M, L, XL ...**
- **운영체제 : win10, win11, mac0S, linus ...**
- **해상도 : HD, FHD, QUD, UHD ...**

### 장점

- **타입 안정성 : `Enum`은 컴파일 타임에 타입 안정성을 제공한다.**
- **가독성 : `Enum`은 코드의 가독성과 유지 보수성을 향상시킨다.**
- **미리 정의된 상수 : 상수의 집합을 정의하는데 이상적이며, 
코드의 명확성을 높여준다.**

---

```java
public class ReviewEnum {
	
	public static void main(String[] args) {
		Resolution resolution = Resolution.HD;
		System.out.println("resolution : " + resolution);
		
		resolution = Resolution.FHD;
		System.out.println("resolutuon : " + resolution);
		
		System.out.print("동영상 녹화 품질 : ");
		switch (resolution){
			case HD:
				System.out.println("일반 화질");
				break;
			case FHD:
				System.out.println("고화질");
				break;
			case UHD:
				System.out.println("초고화질");
				break;
		}
		
		resolution = resolution.valueOf("UHD");
		System.out.println("resolutuon : " + resolution);
		
		System.out.println("------------------------");
		
		for(Resolution myRes : Resolution.values()) {
			System.out.println(myRes.name() + " : " + myRes.ordinal());
		}
		
		System.out.println("------------------------");
		
		for(Resolution myRes : Resolution.values()) {
			System.out.println(myRes.name() + " : " + myRes.getWidth());
		}
	}
}

enum Resolution {
	HD(1280),
	FHD(1920),
	UHD(3840);
	
	private final int width;
	
	Resolution(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return width;
	}
	
	
}
```

---

### extend(상속)

### 문제

## 클래스를 이용하여 햄버거를 자동으로 만드는 프로그램을 작성하시오.

---

### 조건

- 햄버거의 종류는 햄버거, 치즈버거, 새우버거 3가지
- 각 버거는 각각의 클래스로 생성
- 버거 이름을 담기 위한 `name` 변수 정의
- 재료 정보를 표시하는 `cook()` 메소드 정의
- 공통 부분은 상속 및 메소드 오버라이딩으로 처리

## 각 버거의 재료 정보

---

### 햄버거

- 양상추
- 패티
- 피클

### 치즈버거

- 양상추
- 패티
- 피클
- **치즈**

### **새우버거**

양상추

패티

피클

**새우**

### **출력코드 및 결과 화면**

```java
public class HamburgerMain {
    public static void main(String[] args) {
        HamBurger[] hamBurgers = new HamBurger[3];
        hamBurgers[0] = new HamBurger();
        hamBurgers[1] = new CheeseBurger();
        hamBurgers[2] = new ShrimpBurger();

        System.out.println("주문하신 메뉴를 만듭니다.");
        System.out.println("-------------");
        for (HamBurger hamBurger : hamBurgers) {
            hamBurger.cook();
            System.out.println("-------------");
        }
        System.out.println("메뉴 준비가 완료되었습니다.");
    }
}
```

```
주문하신 메뉴를 만듭니다.
-------------
햄버거를 만듭니다.
빵 사이에 들어가는 재료는?
> 양상추
+ 패티
+ 피클
-------------
치즈버거를 만듭니다.
빵 사이에 들어가는 재료는?
> 양상추
+ 패티
+ 피클
+ 치즈
-------------
새우버거를 만듭니다.
빵 사이에 들어가는 재료는?
> 양상추
+ 패티
+ 피클
+ 새우
-------------
메뉴 준비가 완료되었습니다.
```

### 작성할 클래스

1. `HamBurger` 
2. `CheeseBurger` 
3. `ShrimpBurger`

---

### 풀이

### Main

```java
public class HamBurgerMain {
	public static void main(String[] args) {
        HamBurger[] hamBurgers = new HamBurger[3];
        hamBurgers[0] = new HamBurger();
        hamBurgers[1] = new CheeseBurger();
        hamBurgers[2] = new ShrimpBurger();

        System.out.println("주문하신 메뉴를 만듭니다.");
        System.out.println("-------------");
        for (HamBurger hamBurger : hamBurgers) {
            hamBurger.cook();
            System.out.println("-------------");
        }
        System.out.println("메뉴 준비가 완료되었습니다.");
    }
}

```

---

### HamBurger

```java
public class HamBurger {
	public String name;
	
	HamBurger(){
		this.name = "햄버거";
	}
	
	public HamBurger(String name) {
		this.name = name;
	}
	
	public void cook() {
		System.out.println(name + "를 만듭니다.");
		System.out.println("빵 사이에 들어가는 재료는?");
		System.out.println("> 양상추");
		System.out.println("+ 패티");
		System.out.println("+ 피클");
	};
}
```

---

### ChessBurger

```java
public class CheeseBurger extends HamBurger{
	
	CheeseBurger(){
		super("치즈버거");
	}
	
	@Override
	public void cook() {
		super.cook();
		System.out.println("+ 치즈");
	}
}
```

---

### ShrimpBurger

```java
public class ShrimpBurger extends HamBurger{
	
	ShrimpBurger(){
		super("새우버거");
	}
	
	@Override
	public void cook() {
		super.cook();
		System.out.println("+ 새우");
	}
}

```

---

### 추상 클래스

```java
public class ReviewAbstractClass {
	public static void main(String[] args) {
		//Camera camera = new Camera(); 추상 클래스는 인스턴스화 할 수 없다
		Camera factoryCam = new FactoryCam();
		factoryCam.showMainFeature();
		Camera speedCam = new SpeedCam();
		speedCam.showMainFeature();
		/*
		FactoryCam factoryCam = new FactoryCam();
		factoryCam.showMainFeature();
		SpeedCam speedCam = new SpeedCam();
		speedCam.showMainFeature();
		*/
	}
}

```

```java
public abstract class Camera {
	public void takePicture() {
		System.out.println("사진을 촬영합니다.");
	}
	
	public void recordVideo() {
		System.out.println("동영상을 녹화합니다.");
	}
	
	public abstract void showMainFeature(); // 추상메서드 - 하위클래스에서 구현해야 하는 메서드
	
}
```

```java
public class FactoryCam extends Camera{
	
	@Override
	public void showMainFeature() {
		System.out.println("화재 감지");
	}
}
```

```java
public class SpeedCam extends Camera{
	@Override
	public void showMainFeature() {
		System.out.println("속도 측정, 번호 인식");
	}
}
```

---

### 인터페이스

### 문제

### 문제: 인터페이스와 추상 클래스를 사용하여 카메라 시스템 구현

다음 조건을 만족하는 카메라 시스템을 구현하세요. 모든 코드는 하나의 파일에 작성할 필요는 없으며, 패키지 구조를 고려하여 작성하세요.

### 조건

1. **추상 클래스 Camera**
    - 패키지: `abs.camera`
    - **메소드**
        - `takePicture()`: 사진을 촬영합니다. (구현)
        - `recordVideo()`: 동영상을 녹화합니다. (구현)
        - `showMainFeature()`: 카메라의 주요 기능을 출력합니다. (추상 메소드)
2. **인터페이스 Detectable**
    - 패키지: `abs.detector`
    - **메소드**
        - `detect()`: 감지 기능을 수행합니다. (추상 메소드)
3. **인터페이스 Reportable**
    - 패키지: `abs.reporter`
    - **메소드**
        - `report()`: 신고 기능을 수행합니다. (추상 메소드)
4. **구현 클래스 FactoryCam**
    - 패키지: `abs.camera`
    - `Camera` 추상 클래스를 상속받고, `Detectable`과 `Reportable` 인터페이스를 구현합니다.
    - **추가 메소드**
        - `setDetector(Detectable detector)`: 감지기 객체를 설정합니다.
        - `setReporter(Reportable reporter)`: 리포터 객체를 설정합니다.
    - `showMainFeature()` 메소드는 "화재 감지"를 출력합니다.
    - `detect()` 메소드는 설정된 감지기의 `detect()` 메소드를 호출합니다.
    - `report()` 메소드는 설정된 리포터의 `report()` 메소드를 호출합니다.
5. **구현 클래스 SpeedCam**
    - 패키지: `cab.camera`
    - `Camera` 추상 클래스를 상속받습니다.
    - **추가 메소드**
        - `setDetector(Detectable detector)`: 감지기 객체를 설정합니다.
        - `setReporter(Reportable reporter)`: 리포터 객체를 설정합니다.
    - `showMainFeature()` 메소드는 "속도 측정, 번호 인식"을 출력합니다.
    - `detect()` 메소드는 설정된 감지기의 `detect()` 메소드를 호출합니다.
    - `report()` 메소드는 설정된 리포터의 `report()` 메소드를 호출합니다.
6. **구현 클래스 AccidentDetector**
    - 패키지: `chap_08.detector`
    - `Detectable` 인터페이스를 구현합니다.
    - `detect()` 메소드는 "교통 사고를 감지합니다."를 출력합니다.
7. **구현 클래스 AdvancedFireDetector**
    - 패키지: `chap_08.detector`
    - `Detectable` 인터페이스를 구현합니다.
    - `detect()` 메소드는 "향상된 성능으로 화재를 감지합니다."를 출력합니다.
8. **구현 클래스 FireDetector**
    - 패키지: `chap_08.detector`
    - `Detectable` 인터페이스를 구현합니다.
    - `detect()` 메소드는 "일반 성능으로 화재를 감지합니다."를 출력합니다.
9. **구현 클래스 NormalReporter**
    - 패키지: `chap_08.reporter`
    - `Reportable` 인터페이스를 구현합니다.
    - `report()` 메소드는 "일반 화재 신고를 진행합니다."를 출력합니다.
10. **구현 클래스 VideoReporter**
    - 패키지: `chap_08.reporter`
    - `Reportable` 인터페이스를 구현합니다.
    - `report()` 메소드는 "직전 30초 영상과 함께 신고를 진행합니다."를 출력합니다.
11. **메인 클래스**
    - 패키지: `chap_08`
    - 클래스 이름: `_02_Interface`
    - **메소드**
        - `main(String[] args)`: 다음과 같은 작업을 수행합니다.
            - `NormalReporter`와 `VideoReporter` 객체를 생성하고 각각의 `report()` 메소드를 호출합니다.
            - `FireDetector`와 `AdvancedFireDetector` 객체를 생성하고 각각의 `detect()` 메소드를 호출합니다.
            - `FactoryCam` 객체를 생성하고 `AdvancedFireDetector`와 `VideoReporter` 객체를 설정한 후, `detect()`와 `report()` 메소드를 호출합니다.

---

### 예시 출력

```
일반 화재 신고를 진행합니다.
직전 30초 영상과 함께 신고를 진행합니다.
---------------------
일반 성능으로 화재를 감지합니다.
향상된 성능으로 화재를 감지합니다.
---------------------
향상된 성능으로 화재를 감지합니다.
직전 30초 영상과 함께 신고를 진행합니다.
```

위 조건을 만족하는 자바 프로그램을 작성하세요.

---

### 풀이

### 추상클래스 Camera

```java
public abstract class Camera {
	public void takePicture() {
		System.out.println("사진을 촬영합니다.");
	}
	
	public void recordVideo() {
		System.out.println("동영상을 녹화합니다.");
	}
	
	public abstract void showMainFeature(); // 추상메서드 - 하위클래스에서 구현해야 하는 메서드
	
}
```

---

### 인터페이스

### Detectable

```java
public interface Detectable {
	public void detect();
}
```

---

### Reportable

```java
public interface Reportable {
	public void report();
}
```

---

### 구현 클래스

### **FactoryCam**

```java
public class FactoryCam extends Camera{
	
	@Override
	public void showMainFeature() {
		System.out.println("화재 감지");
	}
	
	public void setDetector(Detectable detector) {
		detector.detect();
	}
	
	public void setReporter(Reportable reporter) {
		reporter.report();
	}
}
```

---

### **SpeedCam**

```java
public class SpeedCam extends Camera{
	@Override
	public void showMainFeature() {
		System.out.println("속도 측정, 번호 인식");
	}
	
	public void setDetector(Detectable detector) {
		detector.detect();
	}
	
	public void setReporter(Reportable reporter) {
		reporter.report();
	}
}
```

---

### **AccidentDetector**

```java
public class AccidentDetector implements Detectable{
	@Override
	public void detect() {
		System.out.println("교통 사고를 감지합니다.");
	}
}
```

---

### **AdvancedFireDetector**

```java
public class AdvancedFireDetector implements Detectable{
	@Override
	public void detect() {
		System.out.println("향상된 성능으로 화재를 감지합니다.");
	}
}
```

---

### **FireDetector**

```java
public class FireDetector implements Detectable{
	@Override
	public void detect() {
		System.out.println("일반 성능으로 화재를 감지합니다.");
	}
}
```

---

### **NormalReporter**

```java
public class NormalReporter implements Reportable{
	@Override
	public void report() {
		System.out.println("일반 화재 신고를 진행합니다.");
	}
}
```

---

### **VideoReporter**

```java
public class VideoReporter implements Reportable{
	@Override
	public void report() {
		System.out.println("직전 30초 영상과 함께 신고를 진행합니다.");
	}
}
```

---

---

### 메인

```java
public class Interface {
	public static void main(String[] args) {
		NormalReporter nr = new NormalReporter();
		nr.report();
		VideoReporter vr = new VideoReporter();
		vr.report();
		System.out.println("---------------------");
		FireDetector fd = new FireDetector();
		fd.detect();
		AdvancedFireDetector afd = new AdvancedFireDetector();
		afd.detect();
		System.out.println("---------------------");
		FactoryCam fc = new FactoryCam();
		fc.setDetector(afd);
		fc.setReporter(vr);
		
	}
}
```
