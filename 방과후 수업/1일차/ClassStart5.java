package class1;

public class ClassStart5 {
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
		
	}
}
