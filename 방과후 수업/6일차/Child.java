package extends1.access.child;

import extends1.access.parent.Parent;

public class Child extends Parent{
	
	public void call() {
		publicvalue = 1;
		protectedvalue = 1;
		//defaultvalue = 1; 다른 패키지 접근 풀가
		//privatevalue = 1; // private 다른 클래스 접근 불가
		
		printParent();
	}
}
