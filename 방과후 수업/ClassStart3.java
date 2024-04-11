package class1;

public class ClassStart3 {
	public static void main(String[] args) {
		Student stu1 = new Student(); //메모리에 학생클래스를 생성하여 stu1에 담아둔다.
		
		stu1.StudentName = "홍길동"; // .( 닻 )을 쓰는 순간 이 주소로 이동하라고 말해주는 것( 접근 )이다.
		stu1.StudentAge = 15;
		stu1.StudentGrade = 90;
		
		Student stu2 = new Student();
		
		stu2.StudentName = "장발장";
		stu2.StudentAge = 16;
		stu2.StudentGrade = 80;
		
		System.out.println("이름 :" + stu1.StudentName + "나이 : " + stu1.StudentAge + "세 성적 : " + stu1.StudentGrade + "점");
		System.out.println("이름 :" + stu2.StudentName + "나이 : " + stu2.StudentAge + "세 성적 : " + stu2.StudentGrade + "점");
	}
}
