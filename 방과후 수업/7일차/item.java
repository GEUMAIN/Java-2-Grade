package extends1.exA;

public class item {
	
	private String name;
	private int price;
	
	public item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	void print() {
		System.out.println("이름 : "+ name + ", 가격 : " + price);
	}
	
	public int getPrice() {
		return price;
	}
}
