학생 정보 출력 프로그램

두 명의 학생 정보를 출력하는데. 학생은 이름, 나이, 성적을 가지고있다.

1.

홍길동, 15세, 90점

2.

장발장, 16세, 80점

출력

이름: [이름] 나이: [나이]세 성적: [성적]점

변수를 사용하여 학생 정보를 저장하고,

변수를 사용해서 학생 정보를 출력해보자!!

public static void main(String[] args) {
		String StudentName1 = "홍길동";
		int StudentAge1 = 15;
		int StudentGrade1 = 90;
		
		String StudentName2 = "장발장";
		int StudentAge2 = 16;
		int StudentGrade2 = 80;
		
		System.out.println("이름 :" + StudentName1 + "나이 : " + StudentAge1 + "세 성적 : " + StudentGrade1 + "점");
		System.out.println("이름 :" + StudentName2 + "나이 : " + StudentAge2 + "세 성적 : " + StudentGrade2 + "점");
	}

## 문제점 :

위 방식은 학생이 늘어날 때 마다 변수와 출력하는 코드를 추가해야 하는 문제점이 있다.

위 문제점 해결을 위해 배열을 사용해보자.
	public static void main(String[] args) {
		
		
		String[] StudentNames = {"홍길동","장발장","임꺽정","로미오"};
		int[] StudentAges = {15,16,17,20};
		int[] StudentGrades = {90,80,99,70};
		
		for (int i = 0; i<StudentNames.length; i++) {
			System.out.println("이름 :" + StudentNames[i] + "나이 : " + StudentAges[i] + "세 성적 : " + StudentGrades[i] + "점");
		}
	}

배열을 사용하여 코드를 다시 작성하였을 때,

1. 학생이 추가되어도 배열에 데이터만 추가하면 됨. 변수추가 X
2. 출력을 반복문을 통해 배열을 순차적으로 탐색하므로,
학생이 추가되어도 출력 코드를 추가할  필요가 없음

## 문제점 :

코드 변경은 최소화 되었으나,
한 학생의 데이터가 3개의 배여로 나눠서 관리가 됨.
데이터를 변경, 삭제할 때 매우 조심히 작업을 해야함.
따라서 위와 같은 코드는
컴퓨터가 볼 때는 전혀 문제가 없지만 사람이 관리하기에는
좋은 코드가 아니다.

그래서 클래스를 도입한다.

클래스를 사용해 학생이라는 개념을 만들고,
각각의 학생별로 본인의 이름, 나이, 성적을 관리한다.

## 클래스
public static void main(String[] args) {
		Student stu1 = new Student(); //메모리에 학생클래스를 생성하여 stu1에 담아둔다.
		
		stu1.StudentName = "홍길동"; // .( 닷 )을 쓰는 순간 이 주소로 이동하라고 말해주는 것( 접근 )이다.
		stu1.StudentAge = 15;
		stu1.StudentGrade = 90;
		
		Student stu2 = new Student();
		
		stu2.StudentName = "장발장";
		stu2.StudentAge = 16;
		stu2.StudentGrade = 80;
		
		System.out.println("이름 :" + stu1.StudentName + "나이 : " + stu1.StudentAge + "세 성적 : " + stu1.StudentGrade + "점");
		System.out.println("이름 :" + stu2.StudentName + "나이 : " + stu2.StudentAge + "세 성적 : " + stu2.StudentGrade + "점");
	}

## 클래스와 사용자 정의 타입

- 타입은 데이터의 종류나 형태를 나타낸다.
- int 정수 타입, String 문자열 타입
- 학생(Student)라는 타입을 만들면 좋지 않을까?
- 클래스를 사용하면 int, String과 같은 타입을 직접 생성할 수 있다.
- 사용자가 직접 정의하는 사용자 정의 타입을 만들려면 설계도가 필요하고
이 설계도가 클래스이다.
- 설계도인 클래스를 사용헤서 실제 메모리에 만들어진 실체를 객체 또는 인스턴스라 함.
- 클래스를 통해서 사용자가 원하는 종류의 데이터 타입을 마음껏 정의할 수 있다.

## 참조값을 변수에 보관하는 이유

객체를 생성하는 new Student() 코드 자체에는 이름이 없다.

이 코드는 단순히 Student 클래스를 기반으로 메모리에

실제 객체를 만드는 기능만 한다.

따라서 생성한 객체에 접근할 방법이 필요하다.

객체를 생성할 때 반환되는 참조값( 주소 )를 알면 객체에 접근할 수 있다.

따라서 반환되는 참조값( 주소 )를 저장할 변수가 필요하며

앞서 Student stu1로 선언한 변수(stu1)에 참조값을

저장하여 필요할 때 객체에 접근할 수 있다.

## 정리

Student stu1 = new Student(); // Student 객체 생성

Student stu1 = 0x0099ff (주소 예); // new Student()의 결과로 참조값( 주소 ) 반환

stu1 = 0x0099ff; //stu1 변수에 주소값이 담김

클래스에도 배열을 도입하면 관리가 용이해진다.

	public static void main(String[] args) {
		Student stu1 = new Student();
		
		stu1.StudentName = "홍길동";
		stu1.StudentAge = 15;
		stu1.StudentGrade = 90;
		
		Student stu2 = new Student();
		
		stu2.StudentName = "장발장";
		stu2.StudentAge = 16;
		stu2.StudentGrade = 80;
		
		Student[] students = new Student[2];
		students[0] = stu1;
		students[1] = stu2;
		
		System.out.println(students[0].StudentName);
	}

1. System.out.println(students[0].StudentName); 배열 접근 시작
2. System.out.println(005[0].StudentName); [0]을 사용해서 005 배열의 0번 요소에 접근
3. System.out.println(001.StudentName); .(dot)을 사용해서 참조값으로 객체에 접근
4. System.out.println(”홍길동”);

## 리팩토링

1. 선언 단일화( 베열로만 접근 )

2. 출력문구를 반복문을 통해 심플하게 변경

public static void main(String[] args) {
		// 리팩토링
		// 1. 선언 단일화( 베열로만 접근 )
		// 2. 출력문구를 반복문을 통해 심플하게 변경
		Student[] students = new Student[2];
		students[0] = new Student();
		students[1] = new Student();
		
		students[0].StudentName = "홍길동";
		students[0].StudentAge = 15;
		students[0].StudentGrade = 90;
		
		students[1].StudentName = "장발장";
		students[1].StudentAge = 16;
		students[1].StudentGrade = 80;
		
		for(int i = 0; i<students.length; i++) {
			System.out.println("이름 :" + students[i].StudentName + "나이 : " +  students[i].StudentAge + "세 성적 : " +  students[i].StudentGrade + "점");
		}
		
		for (Student s : students) {
			System.out.println("이름 :" + s.StudentName + "나이 : " +  s.StudentAge + "세 성적 : " +  s.StudentGrade + "점");
		}
	}
