package class1;

public class ClassStart2 {
	public static void main(String[] args) {
		
		
		String[] StudentNames = {"홍길동","장발장","임꺽정","로미오"};
		int[] StudentAges = {15,16,17,20};
		int[] StudentGrades = {90,80,99,70};
		
		for (int i = 0; i<StudentNames.length; i++) {
			System.out.println("이름 :" + StudentNames[i] + "나이 : " + StudentAges[i] + "세 성적 : " + StudentGrades[i] + "점");
		}
	}
}
