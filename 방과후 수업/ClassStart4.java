package class1;

public class ClassStart4 {
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
}
