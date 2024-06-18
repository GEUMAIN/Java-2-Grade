### 4번째 수업

### 불변객체 복습

### MemberV1 (불변 X)

```java
public class MemberV1 {
	
	private String name;
	private Address address;

	public MemberV1(String name, Address address) {
		this.address = address;
		this.name = name;
	}
	
	Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "MemberV1 [name=" + name + ", address=" + address + "]";
	}
	
	
}
```

## 메인

```java
public class MemberMainV1 {
	public static void main(String[] args) {
		
		Address address = new Address("서울");
		
		MemberV1 memberA = new MemberV1("회원A", address);
		MemberV1 memberB = new MemberV1("회원B", address);
		
		System.out.println("memberA : " + memberA);
		System.out.println("memberB : " + memberB);
		
		memberB.getAddress().setValue("부산");
		
		System.out.println("부산 -> memberB.address");
		System.out.println("memberA : " + memberA);
		System.out.println("memberB : " + memberB);
	}
}
```

---

### MemberV2(불변 O)

```java
public class MemberV2 {
	
	private String name;
	private ImmutableAddress address;
	
	public MemberV2(String name, ImmutableAddress address) {
		this.name = name;
		this.address = address;
	}

	public ImmutableAddress getAddress() {
		return address;
	}

	public void setAddress(ImmutableAddress address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "MemberV2 [name=" + name + ", address=" + address + "]";
	}

}
```

## 메인

```java
public class MemberMainV2 {
	public static void main(String[] args) {
		
		ImmutableAddress address = new ImmutableAddress("서울");
		
		MemberV2 memberA = new MemberV2("회원A", address);
		MemberV2 memberB = new MemberV2("회원B", address);
		
		System.out.println("memberA : " + memberA);
		System.out.println("memberB : " + memberB);
		
		//memberB.getAddress().setValue("부산"); 컴파일 오류
		
		memberB.setAddress(new ImmutableAddress("부산"));
		
		System.out.println("부산 -> memberB.address");
		System.out.println("memberA : " + memberA);
		System.out.println("memberB : " + memberB);
	}
}

```

---

### String

### Char String 비교해서 출력하기

---

```java
public class CharArrayMain {
	//char를 이용해서 hello 출력;
	//String을 이용해서 hello 출력;
	
	public static void main(String[] args) {
		char[] h1 = {'h','e','l','l','o'}; 
		
		String h2 = "hello";
		
		System.out.println(h1);
		System.out.println(h2);
	}
}

```

---

```java
public class StringBasicMain {
	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = new String("hello");
		
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
	}
}
```

---

**`""` 사용 방법, `객체 생성` 방법이 있다.
`String` 클래스이다 `int`, `boolean`과 같은 `기본형`이 아니라 `참조형`이다.
따라서 `str1` 변수에는 `String` 인스턴스의 `참조값`만 들어갈 수 있다.
그러면 `String str1` = `"hello";` 문장은 뭔가 어색하다.
`String str1 = "hello";` 이 문장을
`String str1 = new String("hello");` 자바가 이 형태로 문장을 바꿔준다**

---

### Concat

---

```java
public class StringConcatMain {
	public static void main(String[] args) {
		String a = "hello";
		String b = " java";
		String result1 = a.concat(b);
		String result2 = (a + b);
		
		System.out.println("result1 = " + result1);
		System.out.println("result2 = " + result2);
		
	}
}
```

---

**`concat`은 사람들이 글자를 합치는것을 너무 많이 쓰기에
좀 더 쉽고 이해하기 쉽게 `+ 연산자`를 사용하게 해주었다. `(편리성)`**

---

### Equals

---

```java
public class StringEqualsMain1 {
	public static void main(String[] args) {
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		System.out.println("== 비교 : " + (str1 == str2));
		System.out.println("equals 비교 : " + str1.equals(str2));
		
		//이터널 선언
		String str3 = "hello";
		String str4 = "hello";
		
		System.out.println("== 비교 : " + (str3 == str4));
		System.out.println("equals 비교 : " + str3.equals(str4));
	}
}
```

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/fa97d740-13f6-4ddc-9939-b86bb2c976d6/db52716a-acff-4780-856b-92632e6de895/Untitled.png)

**`동일성 비교`는 주소 값부터 따지기 때문에 `false`를 띄우고**

**`동등성 비교`는 값이 가리키는 것에 있는 실질적인 값을 비교해 `true`가 나온다.**

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/fa97d740-13f6-4ddc-9939-b86bb2c976d6/4185bd58-4396-4a93-81e8-675ec4742afb/Untitled.png)

**`이터널 선언`은 `String Pool`에서 먼저 값이 있는지 찾아 있으면 그 값을 가리킨다.**

**그렇기에 `동일성 비교`, `동등성 비교` 모두 `true`가 나온다.**

---

### 메서드 호출 비교

---

```java
public class StringEqualsMain2 {
	public static void main(String[] args) {
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		System.out.println("메서드 호출 비교 : " + isSame(str1,str2));
		
		//이터널 선언
		String str3 = "hello";
		String str4 = "hello";
		
		System.out.println("메서드 호출 비교 : " + isSame(str3,str4));
		
	}
	
	private static boolean isSame(String A, String B) {
		return A == B;
	}
}
```

---

### String 불변 객체인지 알아보기

---

```java
public class StringImmutable1 {
	
	public static void main(String[] args) {
		String str = "hello";
		str.concat("java");
		
		System.out.println("str : " + str);
	}
}
```

---

**`concat`에서 `java`를 붙인 결과 붙여서 나오지 않는다.**

**그렇기에 못 바꾸게 되어있기에 `String`은 `불변 객체`임을 알 수 있다.**

**따라서 생성 이후에 절대로 `내부의 문자열 값`을 변경할 수 없다.**

---

### 변경이 필요한 경우

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/fa97d740-13f6-4ddc-9939-b86bb2c976d6/a6bbe450-acc6-4de3-81bc-612563d7fd44/Untitled.png)

---

```java
public class StringImmutable2 {
	
	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = str1.concat("java");
		
		System.out.println("str : " + str1);
		System.out.println("str : " + str2);
	}
}
```

---

**변경이 필요한 경우 기존값을 변경하지 않고 `새로운 결과`를 만들어서 
`반환`해야 한다.**

**`String`이 불변으로 설계된 이유**

**`문자열 풀`에 있는 `String` 인스턴스의 값이 중간에 변경되면 같은 
`문자열`을 참고하는 다른 `변수의 값`도 변경된다. 
즉, `사이드 이펙트`가 발생한다.**

---

### String의 다양한 함수

### 문자열 정보 조회

```java
public class StringInfoMain {
	//문자열의 정보 조회
	public static void main(String[] args) {
		
		String str = "Hello. Java!";
		
		System.out.println("문자열의 길이 : " + str.length()); //공백 포함
		System.out.println("문자열이 비어있는지 : " + str.isEmpty());
		System.out.println("문자열이 비어있거나 공백인지1 : " + str.isBlank()); //자바 11 이상
		System.out.println("문자열이 비어있거나 공백인지2 : " + " ".isBlank());
		
		char c = str.charAt(7); //문자열의 7번 인덱스
		
		System.out.println("8번째 인덱스의 문자 : " + c); //공백 포함
	}
}
```

---

### 문자열 비교

```java
public class StringComparisonMain {
	//문자열 비교
	public static void main(String[] args) {
		String str1 = "Hello, Java";
		String str2 = "hello, java";
		String str3 = "Hello, World";
		
		System.out.println("str1 equals str2 : " + str1.equals(str2)); //false
		System.out.println("str1 equalsIgnoreCase str2 : " + str1.equalsIgnoreCase(str2)); //대소문자 무시
		System.out.println("'d' compareTo 'a' : " + "d".compareTo("a")); //사전 순 비교 (a : 1 b : 2 ...)
		System.out.println("str1 compareTo str2 : " + str1.compareTo(str2));
		System.out.println("str1 compareToIgnoreCase str2 : " + str1.compareToIgnoreCase(str2)); //대소문자 무시
		System.out.println("str1 starts with 'Hello' : " + str1.startsWith("Hello"));
		System.out.println("str1 ends with 'Java' : " + str1.endsWith("Java"));
	} 
}

```

---

### 문자열 검색

```java
public class StringSearchMain {
	//문자열 검색
	public static void main(String[] args) {
		
		String str = "Hello, Java! Welcome to Java World";
		
		System.out.println("문자열에 'Java'가 포함되어 있는지 : " + str.contains("Java"));
		System.out.println("'Java'의 첫 번째 인덱스 : " + str.indexOf("Java"));
		System.out.println("인덱스 10부터 'Java'의 인덱스 : " + str.indexOf("Java", 10));
		System.out.println("'Java'의 마지막 인덱스 : " + str.lastIndexOf("Java"));
	}
}
```
