package enumeration.test.ex1;

public class GradeMain {
	public static void main(String[] args) {
		AuthGrade[] authgrade = AuthGrade.values();
		
		for(AuthGrade g : authgrade) {
			printGrade(g);
		}
	}
	
	private static void printGrade(AuthGrade grade) {
		System.out.println(grade.name() + ", 레벨 : " + grade.getlevel() + ", 설명 : " + grade.getDescription());
	}

}
