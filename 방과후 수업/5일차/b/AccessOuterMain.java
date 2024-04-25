package access.b;

import access.a.AccessData;

public class AccessOuterMain {
	public static void main(String[] args) {
		AccessData data = new AccessData();
		
		// public
		data.publicfield = 1;
		data.publicMetod();
		
		//default - 같은 패키지니까 호출이 가능
		//data.defaultfield = 2;
		//data.defaultMetod();
		 
		//private - 다른 클래스에서 호출 불가
		//data.privatefield = 3;
		//data.privateMethod();
		
		data.innerAccess(); //private로 막아놨어도 내부에서 private를 호출해서 할 수 있는 public메서드가 있다면 호출할 수 있다.
	}
}
