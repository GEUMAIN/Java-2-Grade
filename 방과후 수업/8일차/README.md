## 8번째 수업

### 리팩토링 문제 풀기

---

### Before

### FindInt

```java
public class FindInt {
	
	public static boolean find(int[] data, int number) {
		boolean flag = false;
		
		for (int i = 0; i < data.length; i++) {
			if(data[i] == number) {
				flag = true;
			}
		}
		
		return flag;
	}
	
}
```

### FindIntMain

```java
public class FindIntMain {
	public static void main(String[] args) {
		
		int[] data = {1,2,3,4,5,6,7,8,9,10};
		
		if(FindInt.find(data, 10)) {
			System.out.println("Found");
		}else {
			System.out.println("Not Found");
		}
	}
}

```

### After

### FindInt

```java
public class FindInt {
	
	public static boolean find(int[] data, int number) {
		boolean found = false;
		
		for (int i = 0; i < data.length; i++) {
			if(data[i] == number) {
				found = true;
				//break;
				return found; //더 좋은 방식
			}
		}
		
		return found;
	}
	
}
```

### FindIntMain

```java
public class FindIntMain {
	public static void main(String[] args) {
		
		int[] data = {1,2,3,4,5,6,7,8,9,10};
		
		if(FindInt.find(data, 10)) {
			System.out.println("Found");
		}else {
			System.out.println("Not Found");
		}
	}
}
```

---

### 좀 더 어렵게 풀어보기

---

### Before

### Main

```java
public class Main {

public static void main(String[] args) throws FileNotFoundException, IOException {
SimpleDataBase simpleDataBase = new SimpleDataBase(new FileReader(".\\src\\datafile.txt"));

Iterator<String> ir = simpleDataBase.iterator();

while(ir.hasNext()) {
String key = ir.next();
System.out.println("key:" + key);
System.out.println("value: " + simpleDataBase.getValue(key));
}
}
}
```

### SimpleDataBase

```java
public class SimpleDataBase {

	private Map<String, String> map = new HashMap<String, String>();

	public SimpleDataBase(Reader reader) throws IOException {
		BufferedReader br = new BufferedReader(reader);
	
		boolean flag = false;
		String temp;
	
		while (!flag) {
				temp = br.readLine();
				if(temp == null) {
					flag = true;
				} else {
					boolean flag2 = true;
	
					StringBuffer sb1 = new StringBuffer();
					StringBuffer sb2 = new StringBuffer();
	
					for (int i=0; i<temp.length(); i++) {
						char temp2 = temp.charAt(i);
	
						if(flag2) {
							if(temp2 == '=') {
								flag2 = false;
							} else {
								sb1.append(temp2);
							}
						} else {
							sb2.append(temp2);
						}
					}
					String ss1 = sb1.toString();
					String ss2 = sb2.toString();
					map.put(ss1, ss2);
				}
		}
		}
	
		public Iterator<String> iterator() {
			return map.keySet().iterator();
		}
	
		public String getValue(String key) {
			return map.get(key);
		}
	
		@Override
		public String toString() {
			return map.toString();
		}
}
```

### After

### SimpleDataBase (변수명 바꾸기)

```java
public class SimpleDataBase {

	private Map<String, String> map = new HashMap<String, String>();

	public SimpleDataBase(Reader reader) throws IOException {
		BufferedReader br = new BufferedReader(reader);
	
		boolean reading = false;
		String line;
	
		while (!reading) {
				line = br.readLine();
				if(line == null) {
					reading = true;
				} else {
					boolean scanningkey = true;
	
					StringBuffer keyBuffer = new StringBuffer();
					StringBuffer valueBuffer = new StringBuffer();
	
					for (int i=0; i<line.length(); i++) {
						char c = line.charAt(i);
	
						if(scanningkey) {
							if(c == '=') {
								scanningkey = false;
							} else {
								keyBuffer.append(c);
							}
						} else {
							valueBuffer.append(c);
						}
					}
					String key = keyBuffer.toString();
					String value = valueBuffer.toString();
					map.put(key, value);
				}
		}
		}
	
		public Iterator<String> iterator() {
			return map.keySet().iterator();
		}
	
		public String getValue(String key) {
			return map.get(key);
		}
	
		@Override
		public String toString() {
			return map.toString();
		}
}
```

### SimpleDataBase (코드 줄이기)

```java
public class SimpleDataBase2 {

	private Map<String, String> map = new HashMap<String, String>();

	public SimpleDataBase2(Reader reader) throws IOException {
		BufferedReader br = new BufferedReader(reader);
	
		boolean reading = false;
		String line;
	
		while (!reading) {
				line = br.readLine();
				if(line == null) {
					break;
				}
				
				int index = line.indexOf("=");
				
				
				if (index > 0 ) {
					String key = line.substring(0,index);
					String value = line.substring(index+1, line.length());
					
					map.put(key, value);
			}
		}
	}
	
	public Iterator<String> iterator() {
		return map.keySet().iterator();
	}
	
	public String getValue(String key) {
			return map.get(key);
	}
	
	@Override
	public String toString() {
		return map.toString();
	}
}

```

---

### **다향성**

1. **객체지향 프로그래밍의 대표적인 특성 : `캡슐화, 상속, 다향성....`**
2. **다형성은 `객체지향 프로그래밍`의 꽃이라 불린다.**
3. **다향성은 이름 그대로 `'다양한 형태'`,`'여러 형태'`를 뜻한다.**
4. **프로그래밍에서 다형성은 한 객체가 여러 타입의 객체로 취급할 수 있는 능력을 뜻한다.**
5. **보통 하나의 객체는 하나의 타입으로 고정되어 있는데 다향성을 사용하면 하나의 객체가 다른 타입으로 사용할 수 있다는 것이다.**

---

### **다향성 2가지 핵심 여론**

1. **다향성 참조**
2. **메서드 오버라이딩**

### 부모 자식

```java
public class Parent {
	public void parentMethod() {
		System.out.println("Parent.parentMethod");
	}
}
```

```java
public class Child extends Parent{
		
	public void childMethod() {
		System.out.println("Child.childMethod");
	}
}
```

### PolyMain

```java
public class PolyMain {
	
	
/*	
1. 객체지향 프로그래밍의 대표적인 특성 : 캡슐화, 상속, 다향성....
2. 다형성은 객체지향 프로그래밍의 꽃이라 불린다.
3. 다향성은 이름 그대로 '다양한 형태','여러 형태'를 뜻한다.
4. 프로그래밍에서 다형성은 한 객체가 여러 타입의 객체로 취급할 수 있ㄴㄴ 능력을 뜻한다.
5. 보통 하나의 객체는 하나의 타입으로 고정되어 있는데 다향성을 사용하면 하나의 객체가 다른 타입으로 사용할 수 있다는 것이다.

다향성 2가지 핷심 여론
1. 다향성 참조
2. 메서드 오버라이딩
	
*/
	
	public static void main(String[] args) {
		//부모 변수가 부모 인서턴스 참조
		System.out.println("Parent -> Parent");
		Parent parent = new Parent();
		parent.parentMethod();
		
		//자식 뱐수가 자식 인스턴스 참조
		System.out.println("Child -> Child");
		Child child = new Child();
		child.parentMethod();
		child.childMethod();
		
		// 부모 변수가 자식 인스턴스 참조(다향성 참조) -> 부모가 자식을 품을 수 있다.
		System.out.println("Parent -> Child");
		Parent poly = new Child();
		poly.parentMethod();
		//poly.childMethod();  자식의 기능은 사용할 수 없다.
		
		//Child child1 = new Parent(); 자식은 부모를 담을 수 없다. 
	}
}

```

### 다운캐스팅

**`다운캐스팅`을 이용해서 다향적 참조의 부모가 `자식 메서드`를 참조 불가능한 점을
불러 올 수 있게 해주자.**

**참조된 값만 일시적으로 `Child`로 바뀌는 것이지 `poly` 자체가 바뀌는 것은 아니다.**

```java
public class CastingMain1 {
	public static void main(String[] args) {
		// 다향적 참조
		Parent poly = new Child();
		
		//poly.childMethod();
		
		//다운캐스팅(부모타입 -> 자식타입)
		Child child = (Child) poly;
		
		child.childMethod();
	}
	
}
```

### 런타임 문제

```java
public class CastingMain1 {
	// 다운캐스팅은 잘못하면 심각한 런타임 오류가 발생할 수 있다.
	
	public static void main(String[] args) {
		Parent parent1 = new Parent();
		Child child1 = (Child) parent1;
		
		child1.childMethod();
		
		Parent parent2 = new Parent();
		Child child2 = (Child) parent2;
		child2.childMethod();
	}
	
}
```

### 런타임 확률 줄이기 (참조하고 있는지 확인하기)

```java
public class CastingMain5 {
	// 다운캐스팅은 잘못하면 심각한 런타임 오류가 발생할 수 있다.
	
	public static void main(String[] args) {
		Parent parent1 = new Parent();
		System.out.println("parent 호출");
		
		call(parent1);
		
		Parent parent2 = new Child();
		System.out.println("parent2 호출");
		
		call(parent2);
		
		
	}
	
	private static void call(Parent parent) { //개발자가 쓸거라 private
		parent.parentMethod();
		if(parent instanceof Child) { //Child를 참조하고 있으면 true 아니면 false
			System.out.println("Child 인스턴스 맞음");
			((Child)parent).childMethod();
		}
	}
	
}
```

**지금처럼 다운캐스팅을 수행하기 전에 
먼저 `instanceof`를 사용해서 원하는 타입으로 변경이 가능한지
확인한 다음에 `다운캐스팅`을 수행하는 것이 안전하다.**

**참고로 `instanceof` 키워드는 오른쪽 대상의 자식 타입을 
왼쪽에 참조하는 경우에도 `true`를 반환한다.**

```java
parent instanceof Parent 당연히 true
	 
	 new Parent() instanceof Parent : 당연히 true
	 
	 new Child() instanceof Parent : true
	 
	 new Parent() instanceof Parent
	 Parent p = new Parent() : true
	 
	 new Child() instatnceof Parent 
	 Parent p = new Child() : true
	 
	 new Parent() instanceof Child
	 Child c = new Parent() : false
```

### 일시적으로 다운캐스팅 하기 (메모리 공간 절약)

```java
public class CastingMain1 {
	public static void main(String[] args) {
		// 다향적 참조
		Parent poly = new Child();
		
		//poly.childMethod();
		
		//일시적 다운캐스팅(부모타입 -> 자식타입)
		((Child)poly).childMethod();
	}
	
}
```

### 업캐스팅

```java
public class CastingMain3 {
	public static void main(String[] args) {
		
		Child child = new Child();
		Parent parent1 = (Parent) child; //업캐스팅
		Parent parent2 = child; //압캐스팅은 생략이 가능함.
		
		parent1.parentMethod();
		parent2.parentMethod();
	}
	
}
```
