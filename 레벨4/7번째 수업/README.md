### 7번째 수업

### 래퍼 클래스

## 기본형의 한계

- **자바는 `객체지향 언어`이다.**
- **자바 언어 안에 객체가 아닌 것들이 존재한다.**
- **`int, double` 등과 같은 `기본형 타입`이다.**
- **`기본형`은 객체가 아니기 때문에 다음과 같은 한계가 있다.**
    1. **`객체 아님`: `기본형 데이터`는 객체가 아니기 때문에, 
    `객체 지향 프로그래밍`의 장점을 살릴 수가 없다.
    예를 들어 객체는 `유용한 메서드`를 제공할 수 있는데, `기본형`은 객체가 
    아니므로 메서드를 제공할 수 없다.
    
    1-1. 추가로 `객체 참조`가 필요한 `컬렉션 프레임워크`를 사용할 수 없다. 
    그리고 `제네릭`도 사용할 수 없다.**
    
    2. **`null` 값을 가질 수 없음: `기본형 데이터` 타입은 `null` 값을 가질 수 없다. 
    때로는 데이터가 없음 이라는 상태를 나타내야 할 필요가 있는데, 
    `기본형`은 항상 값을 가지기 때문에 이런 표현을 할 수 없다.**
    
    **`기본형`의 한계를 이해하기 위해, 
    두 값을 비교해서 다음과 같은 결과를 출력하는 간단한 코드를 작성해볼 것이다.**
    
    - **왼쪽이 더 작다 -1**
    - **두 값이 같다 0**
    - **왼쪽의 값이 더 크다 1**
    
    ---
    
    ### Main0
    
    ```java
    public class MyIntegerMethodMain0 {
    	public static void main(String[] args) {
    		int value = 10;
    		int i1 = compareTo(value, 5);
    		int i2 = compareTo(value, 10);
    		int i3 = compareTo(value, 20);
    		
    		System.out.println("i1 : " + i1);
    		System.out.println("i2 : " + i2);
    		System.out.println("i3 : " + i3);
    	}
    	
    	public static int compareTo(int value, int target) {
    		if(value < target) {
    			return -1;
    		}else if(value > target) {
    			return 1;
    		}else {
    			return 0;
    		}
    	}
    }
    
    /*
     value와 비교 대상 값을 compareTo()라는 외부 메서드를 사용해서 비교한다.
     그런데 자기 자신인 value와 다른 값을 연산하는 것이기 때문에 항상 자기 자신의 값인 value가 사용된다.
     이때 만약 value가 객체라면 value 객체 스스로 자신의 값과 다른 값을 비교하는 메서드를 만드는 것이 더 유용하다.
     
     */
    ```
    
    **`value`와 비교 대상 값을 `compareTo()`라는 `외부 메서드`를 
    사용해서 비교한다.
    
    그런데 자기 자신인 `value`와 다른 값을 연산하는 것이기 
    때문에 항상 자기 자신의 값인 `value`가 사용된다.
    
    이때 만약 `value`가 객체라면 `value` 객체 
    스스로 자신의 값과 다른 값을 비교하는 메서드를 만드는 것이 더 유용하다.**
    
    ---
    
    ### MyInteger
    
    ```java
    public class MyInteger {
    	private final int value;
    
    	public MyInteger(int value) {
    		this.value = value;
    	}
    
    	public int getValue() {
    		return value;
    	}
    	
    	public int compareTo(int target) {
    		if(value < target) {
    			return -1;
    		}else if(value > target) {
    			return 1;
    		}else {
    			return 0;
    		}
    	}
    	
    	@Override
    	public String toString() {
    		return String.valueOf(value); //숫자를 문자열로 변경한거다
    	}
    }
    ```
    
    **`MyInteger`는 `int value` 라는 단순한 `기본형 변수`를 하나 가지고 있다.
    이 기본형 변수를 편리하게 사용하도록 `다양한 메서드`를 제공한다.
    `compareTo()`메서드를 `클래스 내부`로 `캡슐화` 한다.
    이 클래스는 `불변`으로 설계했다.**
    
    ---
    
    ### Main1
    
    ```java
    public class MyIntegerMethodMain1 {
    	public static void main(String[] args) {
    		
    		MyInteger myInteger = new MyInteger(10);
    		int i1 = myInteger.compareTo(5);
    		int i2 = myInteger.compareTo(10);
    		int i3 = myInteger.compareTo(20);
    		
    		System.out.println("i1 : " + i1);
    		System.out.println("i2 : " + i2);
    		System.out.println("i3 : " + i3);
    	}
    }
    ```
    
    ---
    
    ### NullMain0
    
    ```java
    public class MyIntegerNullMain0 {
    	public static void main(String[] args) {
    		int[] intArr = {-1,0,1,2,3};
    		System.out.println(findValue(intArr, -1)); //-1
    		System.out.println(findValue(intArr, 0)); //0
    		System.out.println(findValue(intArr, 1)); //1
    		System.out.println(findValue(intArr, 100)); //-1
    	}
    	
    	private static int findValue(int[] intArr, int target) {
    		for(int value : intArr) {
    			if(value == target) {
    				return value;
    			}
    		}
    		
    		return -1;
    	}
    }
    ```
    
    **입력 값이 -1일 때 -1을 반환한다.
    그런데 배열에 없는 값인 100을 입력해도 같은 -1을 반환한다.
    입력값이 -1 일 때를 생각해보면, 배열에 -1 값이 있어서 -1을 반환한 것인지, 아니면 -1 값이 없어서 -1을 반환한건지 명확하지 않다.**
    
    ---
    
    ### NullMain0
    
    ```java
    public class MyIntegerNullMain1 {
    	public static void main(String[] args) {
    		MyInteger[] intArr = {new MyInteger(-1), new MyInteger(0), new MyInteger(1)};
    		
    		System.out.println(findValue(intArr, -1));
    		System.out.println(findValue(intArr, 0));
    		System.out.println(findValue(intArr, 1));
    		System.out.println(findValue(intArr, 100));
    	}
    	
    	private static MyInteger findValue(MyInteger[] intArr, int target) {
    		for(MyInteger myInteger : intArr) {
    			if(myInteger.getValue() == target) {
    				return myInteger;
    			}
    		}
    		
    		return null;
    	}
    }
    ```
    
    ---
    
    ## 자바 래퍼 클래스
    
    - **래퍼 클래스는 쉽게 말해서 `기본형`의 객체 버전이다.**
    - **자바는 `기본형`에 대응하는 `래퍼클래스`를 기본으로 제공한다.**
        
        > **byte -> Byte
        short -> Short
        int -> Integer
        long -> Long
        float -> Float
        double -> Double
        char -> Character
        boolean -> Boolean**
        > 
    
    ### **자바에서 제공하는 래퍼클래스의 특징**
    
    1. **불변이다.**
    2. **`equals`로 비교해야 한다.**
    
    ---
    
    ### 문제 풀기
    
    ### 방 번호
    
    ---
    
    [방 번호](https://www.notion.so/1f7379d3082846c0aa057c7441297815?pvs=21)
    
    ---
    
    ```java
    public class ex1 {
    	public static void main(String[] args) {
    		
    		
    		Scanner sc = new Scanner(System.in);
    		
    		System.out.print("입력 하기 : " );
    		int value = sc.nextInt();
    		int[] cnt = new int[10];
    		while(value > 0) {
    			cnt[value%10]++;
    			value = value / 10;
    			
    		}
    		
    		
    		int ans = (cnt[6] + cnt[9] + 1) /2;
    		for (int i = 0; i < 9; i++) {
    			if(i != 6) {
    				ans = Math.max(ans, cnt[i]);
    			}
    		}
    		
    		System.out.println(ans);
    	}
    }
    ```
