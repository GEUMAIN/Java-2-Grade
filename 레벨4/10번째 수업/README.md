### 10번째 수업

### 기본형과 래퍼의 용도 차이

```java
public class WrapperVsPrimitive {
	public static void main(String[] args) {
		int iterations = 1_000_000_000;
		long startTime, endTime;
		
		// 기본형 long 사용
		long sumPrimitive = 0;
		startTime = System.currentTimeMillis(); //시스템상 현재 시간을 가져옴
		
		for(int i = 0; i < iterations; i++) {
			sumPrimitive += i;
		}
		
		endTime = System.currentTimeMillis();
		
		System.out.println("sumPrimitive = " + sumPrimitive);
		System.out.println("기본 자료형 long 실행 시간 : " + (endTime - startTime) + "ms");
		
		//래퍼 클래스 Long 사용
		Long sumWrapper = sumPrimitive;
		
		startTime = System.currentTimeMillis();
		
		for(int i = 0; i < iterations; i++) {
			sumWrapper += i; //오토박싱 발생
		}
		
		endTime = System.currentTimeMillis();
		
		System.out.println("sumWrapper = " + sumWrapper);
		System.out.println("래퍼 클래스 Long 실행 시간 : " + (endTime - startTime) + "ms");
	}
}
```

**`기본형 연산`이 `래퍼 클래스`보다 대략 10여배 이상 빠른 것을 확인할 수 있다. 
(시스템 마다 다름)
`기본형`은 메모리에서 단순히 그 크기만큼 공간을 차지한다.**

**`래퍼 클래스`의 `인스턴스`는 내부에 필드로 가지고 있는 `기본형`의 값 뿐만 아니라 `자바`에서 객체를 다루는데 필요한 `객체 메타데이터`를 포함하므로 
더 많은 `메모리`를 사용하게 된다. (대략 8~16바이트)**

**위 연산은 10억 번의 연산을 수행헸을 때 0.2동안 3.1초의 차이만큼 발생한다.
`기본형`이든 `래퍼 클래스`든 이것을 1회로 환산하면 
둘 다 매우 빠르게 연산이 수행된다.**

**일반적으로 `애플리케이션`을 만드는 관점에서 보면 이런 부분을 최적화에도 사막의 모래알 하나 정도의 차이가 날뿐이다.**

**`CPU`연산을 아주 많이 수행하는 특수한 경우이거나, 
수만~수십만 이상 연속해서 연산을 수행해야 하는 경우라면 `기본형`을
사용해서 `최적화`를 고려해야 한다.**

**그렇지 않은 일반적인 경우라면 코드를 `유지보수`하기 더 나은것을 선택하면 된다.**

---

### 유지보수 VS 최적화

**유지보수와 최적화 중 우선 고려할 사항을 유지보수하기 좋은 코드이다.
특히 최신 컴퓨터는 매우 빠르기 때문에 메모리 상에서 
발생하는 연산을 몇 번 줄인다고해도 실질적인 도움이 되지 않는 경우가 많다.**

---

### Class 클래스의 주요 기능

### **Class 클래스의 주요 기능**

1. **`타입 정보 얻기` : `클래스의 이름`, `슈퍼클래스`, `인터페이스`, `접근 제한자` 등과 같은 정보를 조회할 수 있다.**
2. **`리플렉션` : 클래스에 정의된 `메서드, 필드, 생성자` 등을 조회하고, 이들을 통해 `객체 인스턴스`를 생성하거나
`메서드`를 호출하는 등의 작업을 할 수 있다.**
3. **`동적 로딩과 생성`: `Class.forName() 메서드`를 사용하여 클래스를 동적으로 로드하고, `newInstance()` `메서드`를 통해 새로운 `인스턴스`를 생성할 수 있다.
참고(`동적 로딩`) - 런타임에 클래스를 로드하는 프로세스를 말함**
4. **`에노테이션 처리` : 클래스에 적용된 `에노테이션`을 조회하고 
처리하는 기능을 제공한다.**

### Class 클래스의 주요 기능

1. **`getDeclaredFields()` : 클래스의 모든 필드를 조회한다.**
2. **`getDeclaredMethods()` : 클래스의 모든 메서드를 조회한다.**
3. **`getSuperclass()` : 클래스의 부모 클래스를 조회한다.**
4. **`getInterfaces()` : 클래스의 인터페이스를 조회한다.**

```java
public class ClassMetaMain {
	public static void main(String[] args) throws Exception {
		
		Class clazz = String.class; //클래스에서 조회
		
		// 모든 필드 출력
		Field[] fields = clazz .getDeclaredFields();
		for (Field field : fields) {
			System.out.println("Field : " + field.getType() + " " + field.getName());
		}
		
		// 모든 메서드 출력
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods) {
			System.out.println("Method : " + method);
		}
		
		// 슈퍼 클래스 정보 출력
		System.out.println("SuperClass :" + clazz.getSuperclass().getName());
		
		// 인터페이스 정보 출력
		Class[] Interfaces = clazz.getInterfaces();
		
		for(Class i : Interfaces) {
			System.out.println("Interfaces : " + i);
		}
	}
}
```

---

```java
public class ClassCreateMain {
	public static void main(String[] args) throws Exception{
		Class helloClass = Class.forName("lang.clazz.Hello");
		Hello hello = (Hello) helloClass.getDeclaredConstructor().newInstance();
		//getDeclaredConstructor() : 생성자를 선택
		//newInstance() : 선택된 생성자를 기반으로 인스턴스를 생성한다.
		
		String result = hello.hello();
		System.out.println("result : " + result);
	}
}
```

**`리플렉션` - `reflection`
`Class`를 사용하면 클래스의 `메타 정보`를 기반으로 클래스에 정의된 `메서드, 필드, 생성자` 등을 조회하고, 이들을 통해
`객체 인스턴스`를 생성하거나 `메서드`를 호출하는 작업을 할 수 있다.
이런 작업을 `리플렉션`이라고 한다.**

---

---

### 동방 보수

### 문제

아주대학교에는 N개의 동아리방이 있었다. 빅-종빈빌런이 나타나기 전까지는. 어느 날 나타난 빅-종빈빌런은 아주대학교의 모든 동아리방을 파괴하고, 동아리들을 내쫓았다. 빅-종빈빌런이 떠난 자리에는 무너져내린 동방만이 남았다.

M 개의 동방 없는 동아리들은 각자 Si (1 ≤ i ≤ M)만큼의 예산을 가지고 있다. 각 동아리는 최대 이 예산을 사용하여 동아리방을 재건하려고 한다. 각 동방을 다시 사용할 수 있기 위해서는 보수비용으로 Ci (1 ≤ i ≤ N)원이 필요하다. 한 동방은 하나의 동아리에 배정될 수 있으며, 하나의 동아리는 하나의 동방만을 가질 수 있다. 각 동아리는 보수를 하고 돈이 남는다고 해서 다른 동아리에 돈을 보태주지는 않는다.

종빈이는 소속된 소학회가 동방이 없어 동방 없는 동아리가 얼마나 서러운지 잘 안다. 이에 최대한 많은 동아리가 동방을 가질 수 있게 도와주려 한다. 종빈이가 도울 것은 당연히 예산이 부족해 동아리방을 얻지 못하는 동아리들이다. 종빈이는 이러한 동아리들에게 동방 보수 비용을 보태주려고 한다.

종빈이가 도와줄 수 있는 금액의 합계가 최대 X원이라고 할 때, 동방을 가질 수 있는 동아리는 최대 몇 개일지를 알아보자.

### 입력

첫 줄에 N (1 ≤ N ≤ 100,000), M (1 ≤ M ≤ 100,000), X (0 ≤ X ≤ 1,000,000,000) 가 주어진다. 두 번째 줄에 N개의 동방 보수비용 Ci (0 ≤ Ci ≤ 1,000,000,000)가 차례로 주어진다. 세 번째 줄에 M개의 동아리의 예산 Si (0 ≤ Si ≤ 1,000,000,000) 가 차례로 주어진다.

### 출력

동방을 가질 수 있는 동아리의 최대 개수를 한 줄에 출력한다.

### 예제 입력 1

```
3 4 0
1 2 3
3 3 3 3
```

### 예제 출력 1

```
3
```

### 예제 입력 2

```
5 4 3
5 8 9 1 7
2 10 5 3
```

### 예제 출력 2

```
3
```

### 힌트

2번 예제에서 각 동아리방을 고치는데 비용이 5, 8, 9, 1, 7이고 각 동아리 들은 2, 10, 5, 3의 금액을 가지고 있다.

이때 2번 동아리에 3번방, 4번 동아리에 4번방 배정하면 종빈이가 돈을 지원해 줄 필요가 없고3번동아리에 1번방을 배정하면 종빈이가 2원을 지원해주면서 종빈이의 도와줄 수 있는 금액 한도 내에서 3개의 동아리가 동아리방을 배정받을 수 있게 된다.

어떻게 배정해도 4개의 동아리가 모두 방을 배정받을 순 없다.

### 내 풀이(미완성)

```java
public class ex6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int[] array = new int[3];
		
		for(int i = 0; i< 3; i++) {
			array[i] = sc.nextInt();
		}
		int[] Narr = new int[array[0]];
		for(int i = 0; i < array[0]; i++) {
			Narr[i] = sc.nextInt();
		}
		
		int[] Marr = new int[array[1]];
		for(int i = 0; i < array[1]; i++) {
			Marr[i] = sc.nextInt();
		}
		
		Arrays.sort(Narr);
		Arrays.sort(Marr);
		
		for(int i = 0; i < Narr.length-1 ; i++) { //Narr : 수리에 필요한 값 , Marr : 동아리가 가지고 있는 돈
				if(Narr[i] <= Marr[i]) {
					cnt++;
				}else if(Narr[i] <= (Marr[i] + array[2])) {
					cnt++;
					array[2] -= (Narr[i] - Marr[i]);
				}
		}
		
		System.out.println(cnt);
	}
}
```
