### 자바 3레벨 테스트

### 예제

- 정렬 알고리즘이 구현해야 할 내용을 Sort 인터페이스에 정의한다.
- 인터페이스에는 정수형 배열을 인수로 받아서 오름차순으로 정렬하는
ascending() 메서드와 내림차순으로 정렬하는 descending() 메서드가 있다.
- 알고리즘에 대한 설명을 출력하는 description() 메서드도 존재한다.

- 정렬 기능은 세 클래스가 구현했다.
    - 실제 숫자는 정렬하지 않고 설명만 출력한다.

1. Sort 인터페이스를 구현하라
2. 인터페이스를 받아 Quicksort, HeapSort, BubbleSort를 구현하라.
    1. 아래 출력화면을 참고하여 클래스를 구현할 것!!
    2. 출력 화면
        
        ```
        정렬 방식을 선택하세요.
        [1] : BubbleSort
        [2] : HeapSort
        [3] : QuickSort
        3 // <- 사용자가 숫자를 써서 입력하는 것이며 3을 입력했을 때
        // 아래 처럼 출력된다.
        
        QuickSort ascending
        QuickSort descending
        숫자를 정렬하는 알고리즘입니다.
        QuickSort입니다.
        ```
        

---

### 문제 풀이

### Sort (인터페이스)

```java
public interface Sort {
	void ascending(int[] asc);
	void descending(int[] desc);
	void description();
}
```

---

### QuickSort

```java
public class QuickSort implements Sort{
	private String name = "QuickSort";
	
	@Override
	public void ascending(int[] asc_arr) {
		System.out.println(name + " ascending");
	}
	
	@Override
	public void descending(int[] desc_arr) {
		System.out.println(name + " descending");
	}
	
	@Override
	public void description() {
		System.out.println("숫자를 정렬하는 알고리즘입니다.");
		System.out.println(name + "입니다.");
	}
}
```

---

### HeapSort

```java
public class HeapSort implements Sort{
	private String name = "HeapSort";
	
	@Override
	public void ascending(int[] asc_arr) {
		System.out.println(name + " ascending");
	}
	
	@Override
	public void descending(int[] desc_arr) {
		System.out.println(name + " descending");
	}
	
	@Override
	public void description() {
		System.out.println("숫자를 정렬하는 알고리즘입니다.");
		System.out.println(name + "입니다.");
	}
}
```

---

### BubbleSort

```java
public class BubbleSort implements Sort{
	private String name = "BubbleSort";
	
	@Override
	public void ascending(int[] asc_arr) {
		System.out.println(name + " ascending");
	}
	
	@Override
	public void descending(int[] desc_arr) {
		System.out.println(name + " descending");
	}
	
	@Override
	public void description() {
		System.out.println("숫자를 정렬하는 알고리즘입니다.");
		System.out.println(name + "입니다.");
	}
}
```

---

### SortTest

```java
public class SortTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Sort[] sort = {new BubbleSort(),new HeapSort(), new QuickSort()};
		
		int[] nums = new int[5];
		
		System.out.println("정렬 방식을 선택하세요.");
		System.out.println("[1] : BubbleSort");
		System.out.println("[2] : HeapSort");
		System.out.println("[3] : QuickSort");
		
		int choice = sc.nextInt();
		
		seletedSort(nums,choice,sort);
	}
	
	private static void seletedSort(int[] nums, int choice, Sort[] sort) {
		
			sort[choice-1].ascending(nums);
			sort[choice-1].descending(nums);
			sort[choice-1].description();
	}
}
```
