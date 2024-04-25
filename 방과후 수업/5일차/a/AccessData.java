package access.a;

public class AccessData {
	
	public int publicfield;
	int defaultfield;
	private int privatefield;
	
	public void publicMetod() {
		System.out.println("publicMetod 호출 " + publicfield);
	}
	
	void defaultMetod() {
		System.out.println("defaultMetod 호출 " + defaultfield);
	}
	
	private void privateMetod() {
		System.out.println("privateMetod 호출 " + privatefield);
	}
	
	public void innerAccess() {
		System.out.println("내부 호출");
		publicfield = 100;
		defaultfield = 200;
		privatefield = 300;
		
		publicMetod();
		defaultMetod();
		privateMetod();
	}
}
