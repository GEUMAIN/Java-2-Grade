### 11번째 수업

### Math

```java
public class MathMain {
	public static void main(String[] args) {
		System.out.println("max : " + Math.max(10, 20));
		System.out.println("min : " + Math.min(10,20));
		System.out.println("abs : " + Math.abs(-10));
		
		System.out.println("ceil : " + Math.ceil(2.1));
		System.out.println("floor : " + Math.floor(2.7));
		System.out.println("round : " + Math.round(2.5));
		
		System.out.println("sqrt : " + Math.sqrt(4));
		System.out.println("random : " + Math.random());
	}
}
```

---

### 종류

1. **기본 연산 메서드**
    1. **abs(x) : 절대값**
    2. **max(a, b) : 최대값**
    3. **min(a, b) : 최소값**
2. **지수 및 로그 연산 메서드**
    1. **exp(x) : e^x 계산**
    2. **log(x) : 자연로그**
    3. **log10(x) : 로그 10**
    4. **pow(a, b) : a의 b 제곱**
3. **반올림 및 정밀도 메서드**
    1. **ceil(x) : 올림**
    2. **floor(x) : 내림**
    3. **round(x) : 반올림**
    4. **rint(x) : 가장 가까운 정수로 반올림**
4. **삼각 함수 메서드**
    1. **sin(x) : 사인**
    2. **cos(x) : 코사인**
    3. **tan(x) : 탄젠트**
5. **기타 유용한 메서드**
    1. **sqrt(x) : 제곱근**
    2. **cbrt(x) : 세제곱근**
    3. **random() : 0.0과 1.0 사이의 무작위 값 생성**

---

### Random

```java
public class RandomMain {
	public static void main(String[] args) {
		
		//Random random = new Random();
		Random random = new Random();
		
		int randomInt = random.nextInt();
		System.out.println("randomInt : " + randomInt);
		
		double randomDouble = random.nextDouble();
		System.out.println("randomDouble : " + randomDouble); //0.0d ~ 1.0d
		
		
		boolean randomBoolrean = random.nextBoolean();
		System.out.println("randomBoolrean : " + randomBoolrean);
		
		int randomRange1 = random.nextInt(10); // 0 ~ 9
		System.out.println("RandomRange1 : " + randomRange1); 
		
		int randomRange2 = random.nextInt(10) + 1; // 1 ~10
		System.out.println("RandomRange2 : " + randomRange2); 
		
	}
}
```

---

### **씨드 - `Seed`**

**랜덤은 내부에서 피드값을 사용해서 랜덤값을 구한다.
그런데 이 씨드 값이 같으면 항상 같은 결과를 출력한다.**

**`new Random();` 생성자를 비워두면 내부에서 
`System.nanoTime()` 에 여러가지 복잡한 
알고리즘을 섞어서 `씨드값`을 생성한다.**

**따라서 반복 실행해도 결과는 항상 달라진다.**

**`new Random(int seed):` 생성자에 `씨드 값`을 직접 전달할 수 있다. 
씨드 값이 같으면 여러번 반복 실행해도 실행값과 같다.**

**이렇게 `씨드 값`을 직접 사용하면 결과 값이 
항상 같기 때문에 결과가 달라지는 `랜덤값`을 구할 수 없다.**

**하지만 결과가 고정되기 때문에 테스트 코드 
같은 곳에서 같은 결과를 검증할 수 있다.**

**참고로 마인크래프트 같은 게임을 지형을 생성할 때 랜덤으로 생성하는데, 
같은 `씨드 값`을 설정하면 같은 지형을 생성할 수 있다.**

---

---

### 래퍼 클래스 복습하기

```java
public class WrapperTest1 {
	public static void main(String[] args) {
		
		String str1 = "10";
		String str2 = "20";
		
		// 문자로 입력된 str1과 str2의 합을 구하시오
		
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		
		System.out.println(num1 + num2);
	}
}	
```

---

```java
public class WrapperTest2 {
	public static void main(String[] args) {
		
		String[] array = {"1.5", "2.5", "3.0"};
		
		// 배열에 입력된 모든 숫자의 합을 구하시오
		// 숫자는 double 형이 입력될 수 있다.
		
		double num = 0;
		
		for (String s : array) {
			double i = Double.parseDouble(s);
			num += i;
		}
		
		System.out.println(num);
	}
}	
```

---

```java
public class WrapperTest3 {
	public static void main(String[] args) {
		
		String str = "100";
		
		// String str을 Integer로 변환해서 출력
		// Integer을 int로 변환해서 출력
		// int를 Integer로 변환해서 출력
		
		
		//String -> Integer 박싱
		Integer integer1 = Integer.valueOf(str);
		System.out.println(integer1);
		
		//Integer -> int 오토언박싱
		int intvalue = integer1;
		System.out.println(intvalue);
		
		//int -> Integer 오토박싱
		Integer integer2 = intvalue;
		System.out.println(integer2);
	}
}	
```

---

### Math 복습하기

```java
public class LottoGeneratorMain {
	public static void main(String[] args) {
		LottoGenerator generator = new LottoGenerator();
		int[] lottoNumbers = generator.generator();
		
		for(int lottoNumber : lottoNumbers) {
			System.out.println(lottoNumber + " ");
		}
	}
}
```

---

**1~45 중에 6개의 중복없이 뽑아야 한다.
실행할 때 마다 결과가 달라야 한다.**

---

```java
public class LottoGenerator {
	
	public int[] generator() {
		Random r = new Random();
		
		
		int[] arr = new int[6];
		
		for(int i = 0; i< 6; i++) {
			arr[i] = r.nextInt(45) + 1;
			
			for(int j = 0; j < i; j++) {
				if(arr[i] == arr[j]) {
					i--;
				}
			}
		}
		
		return arr;
	}
}
```
