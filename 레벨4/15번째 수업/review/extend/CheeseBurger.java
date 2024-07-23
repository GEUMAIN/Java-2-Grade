package review.extend;

public class CheeseBurger extends HamBurger{
	
	CheeseBurger(){
		super("치즈버거");
	}
	
	@Override
	public void cook() {
		super.cook();
		System.out.println("+ 치즈");
	}
}
