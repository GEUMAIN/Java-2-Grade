package extends1.access.parent;

public class Parent {
	
	public int publicvalue;
	protected int protectedvalue;
	int defaultvalue;
	private int privatevalue;
	
	public void printParent() {
		
		System.out.println("== Parent 메서드 내부 ==");
		System.out.println("public : " + publicvalue);
		System.out.println("protected : " + protectedvalue);
		System.out.println("default : " + defaultvalue);
		System.out.println("private : " + privatevalue);
	}
}
