## 복습 문제

**요구사항**

**은행 계좌를 객체로 설게해보자**

1. **`Account` 클래스 생성**
2. **`int balance` : 잔액**
3. **`deposit(int amount)`: 입금 메서드
-입금시 잔액이 증가함**
4. **`withdraw(int amount)` : 출금 메서드
-출금시 잔액이 감소함
-만약 잔액이 부족하면 잔액 부족을 출력함**
5. **`accountMain`클래스 생성 - main 메서드 생성**
6. **계좌에 10000원 입금**
7. **계좌에서 9000원 출금**
8. **계좌에서 2000원을 출금 -> 잔액 부족 출력**
9. **잔고를 출력**

## Account 클래스

```java
public class Account {
    int balance = 0;

    public void deposit(int amount){
        balance += amount;
    }

    public void withdraw(int amount){
        if(balance > amount){
            balance -= amount;
        }else if(balance < amount){
            System.out.println("잔액 부족");
        }
    }
}
```

---

## AccountMain 클래스

public static void main(String[] args) {
        Account account = new Account();

        account.deposit(10000);
        account.withdraw(9000);
        account.withdraw(2000);

        System.out.println("잔고 : "+ account.balance);
    }

## 결과

```java
잔액 부족
잔고 : 1000
```

## hashset에 대해서

- **`set` 인터페이스에서 지원하는 구현 클래스이다.**
- **`인터페이스`는 완성이 되어 있지 않고 정의만 되어 있다.**
- **이걸 구현하는데 `hash`함수 필요하다.**
- **순서대로 입력되지 않고, 일정하게 유지되지 않는다.**
- **`null` 요소도 허용이 된다.**
- **`중복`을 허용하지 않는다. (매력적인 부분)**

### 중복을 걸러내는 과정

- **객체를 저장하기 전에 먼제 객체의

`hashCode()` 메소드를 호출해서 코드를 얻어 낸 다음

저장되어 있는 객체들의 `해시 코드`와 비교한 뒤 같은
`해시 코드`가 있다면 다시 `equals()` 메소드로

두 객체를 비교해서 `true`가 나오면 동일한 객체로
판단하고 `중복 저장`을 하지 않는다.**

### 선언하는 방법

```java
HashSet<Integer> set = new HashSet<Integer>();
```

### 메소드

**add(value) : 값을 추가**

**remove(value) : 값 제거**

**`clear()`: 모든 값 삭제**

**`size()` : HashSet 크기**

**`contains(values)` : 값이 있는지 확인**

### **출력**

**`System.out.println(set);`**

- **전체 출력은 위와 같다**
- **get 메소드가 존재하지 않아서하나의 객체를 가지고 올 수가 없다.**
- **하나의 객체를 가져오기 위해서는 `Iterator`를 사용해야 한다.**
    - **전체 객체를 대상으로 한 번씩 반복해서 가져오는 반복자이다.**
    - **`iterlator()` 메소드를 호출하면 얻을 수 있다.**
    - **`iterlator`에서 하나의 객체를 가져올 때는 `next()` 메소드를 사용한다.**
    - **먼저 가져올 객체가 있는지 확인하기 위해 `hasNext()` 메소드를 
    사용하여 확인하는 것이 좋다.**
        - **`hasNext()` 메소드는 가져올 객체가 있으면 true, 
        없으면 false를 반환한다.**
            
            ```java
            Iterlator iter = set.iterlator();
            while(iter.hasNext()){
            	System.out.println(iter.next());
            }
            ```
            

## 문제

**문제 - 두 개의 수로 특정값 만들기**

**n개의 양의 정수로 이루어진 배열 arr와 정수 `target`이 주어졌을 때 이 중에서 합이 `target`인 두 수가 arr에 있는지 찾고, 있으면 `true`, 없으면 false를 반환하는`solution()`함수를 작성해 보자.**

**제약 조건**

- **n은 2 이상 10,000 이하의 자연수이다.**
- **arr의 각 원소는 1 이상 10,000 이하의 자연수이다.**
- **arr의 원소 중 중복되는 원소는 없다.**
- **target은 1 이상 20,000 이하의 자연수이다.**

```java
**입력
길이 : 5 타겟 : 6
1 2 3 4 8
결과 true

길이 : 4 타겟 : 10
2 3 5 9
결과 false

길이 : 6 타겟 : 10
1 2 3 5 5 6
결과 false**
```

## 내 풀이 (중복 제어 불가능)

```java
public class HashSetEx01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr, target));
    }
    //solution 메소드 생성하고 구현
    public static boolean solution(int[] arr, int target){

        for (int i = 0; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

}
```

## HashSet 사용

```java
HashSet<Integer> set = new HashSet<Integer>();

        for(int i : arr){
            if(set.contains(target -= i)){
                return true;
            }
            set.add(i);

        }
```
