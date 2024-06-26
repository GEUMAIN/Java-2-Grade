### 야구게임 수행평가

---

1. **컴퓨터가 `0~9`까지 3개의 서로 다른 난수를 발생시킨다. (`난수발생 메소드` - `난수를 9로 나눈 나머지+1`)**
    - **`난수발생 메소드` - 난수를 9로 나눈 나머지+1**
    - **`서로 다른 수` => `do while`을 사용하여 `난수`를 `발생`시키고 서로 다른 수가 될 때까지 반복**
    - **서로 다른 난수 세 개 반환**
    
    ---
    
2. **사용자는 `0~9`까지 3개의 서로 다른 숫자를 입력한다.**
    - **`게임 플레이 메소드` - `게임 시도 횟수`, 사용자가 입력하는 3개의 `숫자 배열`, 컴퓨터가 발생시킨 `난수 배열`, `strike`과 `ball` 개수 파악**
    - **컴퓨터가 발생시킨 `난수`와 사용자가 입력한 숫자를 비교한다.**
        - **자리와 크기까지 같으면 `strike`을 증가 : `배열`을 이용하여 
        완벽히 일치하는지**
        - **숫자의 크기만 같으면 `ball`을 증가 : 각 세개의 숫자를 비교**
        - **게임은 정해진 `시도횟수`까지 반복, 또는 `3 strike` 일 때 반복**
        - **게임 `시도횟수`를 반환**

---

1. **`메인 메소드` :  `시도횟수`에 따라 `출력 메세지`를 다르게**

---

### playGame()

```java
public static int playGame() throws IOException{
		int x, y, z; //정답이 될 변수
		Random r = new Random(); //Ramdom 함수 인스턴스화 시키기
		
		x = Math.abs(r.nextInt() % 9) + 1; //1~9까지 랜덤한 숫자를 x에 넣는다
		do {y = Math.abs(r.nextInt() % 9) + 1;}while(x==y); //1~9까지 x와 y가 같으면 반복해 즉 중복이 되지 않게 돌린다.
		
		do {z = Math.abs(r.nextInt() % 9) + 1;}while((z==x)||(z==y)); //1~9까지 z와 x가 같으면 또는 z와 y가 같으면 반복해서 즉 중복이 되지 않게 돌린다.
		return playGame(x,y,z); //return해 playGame() 함수를 파라미터 변수 x y z 를 넣어 불러와준다.
	}
```

---

**정답이 될 변수 `x, y, z` 세가지를 만들어주었으며**

---

**`Random` 함수를 불러와주었으며**

**`x`에는 `1~9`까지 랜덤한 수를 넣으며**

**`y`와 `z`는 `do while`문을 사용하여 겹치지 않게 조건으로 
같을 시 계속 반복문을 돌리게 해주었다.**

---

---

### playGame(메개변수)

**`playGame()`과 이름은 같지만 `메개변수`를 다르게 해 `오버로딩` 해준다.**

---

**`시도 횟수`를 표현해줄 `count`와 `스트라이크`를 
표현해줄 `strike` 그리고 `볼`을 표현해줄 `ball` 변수를 `정수형`으로 선언하고**

**각각 유저의 배열, 컴퓨터 즉 정답의 배열을 각각 만들어준다.
이때 컴퓨터의 배열은 위에서 
정해준 `x, y, z`의 난수를 `메개변수`로 받아와 넣어준다.**

```java
int count; //얼마나 했는지
		int strike, ball; //스트라이크와 볼 수
		
		int[] usr = new int[3]; //유저가 입력할 숫자를 넣을 배열
		int[] com = {x,y,z}; //컴퓨터의 변수에는 받아온 난수들을 넣는다
```

---

**이후 `do while`문을 사용해 `strike`가 3보다 작고 시도횟수가 11번 보다 작을때까지
반복하고 조건이 충족될 시 계속해서 `count`의 갯수를 늘려준다.**

```java
do {
			count++; //일단 횟수가 한 번 늘고 시작
			
			
			
			
		}while((strike<3)&&(count<11)); //스트라이크가 3번 미만이고 카운트가 11번 미만일때까지 계속 돌린다
		
```

---

**이후 `do while`문을 하나 더 안에서 선언해 정답을 적는 기능을 만들어준다**

**이는 `BufferedReader`라는 함수를 이용해 입력할 것이다.**

---

**`BufferedReader`는 `String` 값이므로 이것을 담을 변수는 `String`으로 선언하고
이름은`user`로 해준다.**

```java
System.out.println("\n카운트: "+count); //몇번째 카운트인지
				
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); //콘솔창에 입력하는 내용을 내부 메모리에 저장하는 내부함수
				
				String user; //in을 받아들일려면 String 형으로 선언해야 한다.
```

---

**하지만 우리는 유저의 배열은 `int`형으로 선언했으므로 `user` 값을 `int`형으로 바꿔주는 작업이 필요하고 우리는 이를 `Integer` 함수를 사용해야 한다.**

```java
	System.out.print("1번째 숫자 : ");
				user = in.readLine(); //readLine()이라는 메소드를 이용해서 in에 들어있는 값을 user 변수에 저장한다.
				
				usr[0] = new Integer(user).intValue(); //Integer 형태로 형변환해서 0번째 자리에 넣었다
				
				System.out.print("2번째 숫자 : ");
				user = in.readLine();
				
				usr[1] = new Integer(user).intValue();
				
				System.out.print("3번째 숫자 : ");
				user = in.readLine();
				
				usr[2] = new Integer(user).intValue();
```

---

**이후 `if`문을 사용해 유저의 배열에 담긴 값이 0인지 9보다 큰지 서로 겹치는지를 
체크해 다시 치도록 해주고 `do while`도 위의 조건이 충족할 시 다시 반복하게 해준다**

```java
if(usr[0]==0||usr[1]==0||usr[2]==0) { //만약 0번지 자리 또는 1번지 자리 또는 2번지 자리가 0이라면
					System.out.println("0은 입력하지 마세요. 다시 입력해주세요.");
				}else if(usr[0]>9||usr[1]>9||usr[2]>9) { //만약 0번지 자리 또는 1번지 자리 또는 2번지 자리가 9보다 크다면
					System.out.println("1부터 9까지의 숫자 중 하나를 입력해주세요. 다시 입력해주세요.");
				}else if(usr[0]==usr[1]||usr[1]==usr[2]||usr[0]==usr[2]) { //만약 0번지 자리와 1번지 자리가 또는 1번지 자리와 2번지 자리가 또는 0번지 자리가 2번지 자리와 같다면
					System.out.println("모두 다른 숫자를 입력해주세요. 다시 입력해주세요.");
				}
			}while((usr[0]==0||usr[1]==0||usr[2]==0)||
					(usr[0]>9||usr[1]>9||usr[2]>9)||
					(usr[0]==usr[1]||usr[1]==usr[2]||usr[0]==usr[2]));
```

---

**이 모든 과정이 통과되었다면 `반환값`으로 `시도횟수`를 반환해준다.**

```java
return count;
```

### 전체 코드

```java
public static int playGame(int x, int y, int z) throws IOException{
		int count; //얼마나 했는지
		int strike, ball; //스트라이크와 볼 수
		
		int[] usr = new int[3]; //유저가 입력할 숫자를 넣을 배열
		int[] com = {x,y,z}; //컴퓨터의 변수에는 받아온 난수들을 넣는다.
		
		System.out.println("숫자 야구 게임");
		
		count = 0; //0으로 초기화해준다
		
		do {
			count++; //일단 횟수가 한 번 늘고 시작
			
			do {
				System.out.println("\n카운트: "+count); //몇번째 카운트인지
				
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); //콘솔창에 입력하는 내용을 내부 메모리에 저장하는 내부함수
				
				String user; //in을 받아들일려면 String 형으로 선언해야 한다.
				
			
				
				if(usr[0]==0||usr[1]==0||usr[2]==0) { //만약 0번지 자리 또는 1번지 자리 또는 2번지 자리가 0이라면
					System.out.println("0은 입력하지 마세요. 다시 입력해주세요.");
				}else if(usr[0]>9||usr[1]>9||usr[2]>9) { //만약 0번지 자리 또는 1번지 자리 또는 2번지 자리가 9보다 크다면
					System.out.println("1부터 9까지의 숫자 중 하나를 입력해주세요. 다시 입력해주세요.");
				}else if(usr[0]==usr[1]||usr[1]==usr[2]||usr[0]==usr[2]) { //만약 0번지 자리와 1번지 자리가 또는 1번지 자리와 2번지 자리가 또는 0번지 자리가 2번지 자리와 같다면
					System.out.println("모두 다른 숫자를 입력해주세요. 다시 입력해주세요.");
				}
			}while((usr[0]==0||usr[1]==0||usr[2]==0)||
					(usr[0]>9||usr[1]>9||usr[2]>9)||
					(usr[0]==usr[1]||usr[1]==usr[2]||usr[0]==usr[2]));
			
			//모든 숫자가 1~9사이, 같은 숫자가 없는 경우에만 반복문을 빠져나오게 하기
			
			strike = ball = 0;
			//스트라이크와 볼을 0으로 초기화
			
			if(usr[0]==com[0]) strike++; //만약 유저의 0번지 자리값이 컴의 0번지 자리값이 같다면 스트라이크 추가
			if(usr[1]==com[1]) strike++; //만약 유저의 1번지 자리값이 컴의 1번지 자리값이 같다면 스트라이크 추가
			if(usr[2]==com[2]) strike++; //만약 유저의 2번지 자리값이 컴의 2번지 자리값이 같다면 스트라이크 추가
			
			if(usr[0]==com[1]) ball++;   //만약 유저의 0번지 자리값이 컴의 1번지 자리값이 같다면 볼 추가
			if(usr[0]==com[2]) ball++;	 //만약 유저의 0번지 자리값이 컴의 2번지 자리값이 같다면 볼 추가
			if(usr[1]==com[0]) ball++;	 //만약 유저의 1번지 자리값이 컴의 0번지 자리값이 같다면 볼 추가
			if(usr[1]==com[2]) ball++;	 //만약 유저의 1번지 자리값이 컴의 2번지 자리값이 같다면 볼 추가
			if(usr[2]==com[0]) ball++;	 //만약 유저의 2번지 자리값이 컴의 0번지 자리값이 같다면 볼 추가
			if(usr[2]==com[1]) ball++;	 //만약 유저의 2번지 자리값이 컴의 1번지 자리값이 같다면 볼 추가
			
			System.out.println("Strike: "+ strike +" Ball: "+ ball); //스트라이크 값과 볼 값을 출력하기
			
			
		}while((strike<3)&&(count<11)); //스트라이크가 3번 미만이고 카운트가 11번 미만일때까지 계속 돌린다
		
		
		return count; //빈복문에서 나왔다면 count를 return 해준다
	}
```

---

### Main

```java
public static void main(String[] args) throws IOException{
		
		int result; //카운트횟수를 받을 변수
		
		if(args.length == 3) { //프로그램이 실행할 때 내가 컴퓨터에서 난수 발생 대신 직접 입력한 것의 길이가 3일 때
			int x = Integer.valueOf(args[0]).intValue(); 
			int y = Integer.valueOf(args[1]).intValue();
			int z = Integer.valueOf(args[2]).intValue();
			
			result = playGame(x, y, z); //x,y,z를 넣고 실행한다..
		}else {
			result = playGame(); //난수 발생으로 인생 시도 횟수를 저장
		}
		
		System.out.println();
		
		if(result<=2){
			System.out.println("참 잘했어요!"); //시도횟수가 2번 이하
		}else if(result<=5){
			System.out.println("잘했어요!");//시도횟수가 3번부터 5번 이하
		}else if(result<=9){
			System.out.println("보통이네요!"); //시도횟수가 6번~9번
		}else{
			System.out.println("분발하세요!");// 시도횟수가 10번
		}
		
	}
```

**`args.length`를 사용해 만약 사용자가 직접 컴퓨터에 입력을 한 값의 길이가 3이라면
`x, y, z` 변수를 만들고 그것을 `정수형`으로 받아준다.**

---

**이후 `result` 변수에 `playGame(메개변수)` 함수를 불러와 `count`값을 받아온다**

**만약 아니라면 `result`에 `playGame()`변수를 불러와준다.**

---

**이후 `시도횟수`가 몇이냐에 따라 `출력문구`를 다르게 해준다.**
