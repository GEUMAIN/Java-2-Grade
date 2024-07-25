package generics.ex3;

public class CoffeeOrder <T>{
	public T customer;
	public String coffeeName;
	
	public CoffeeOrder(T customer, String coffeeName) {
		this.coffeeName = coffeeName;
		this.customer = customer;
	}
	
	public String getCoffeeName() {
		return coffeeName;
	}
	
	public T getCustomer() {
		return customer;
	}
	
	public void displayOrder() {
		
	}
}
