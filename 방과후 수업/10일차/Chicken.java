package poly.ex6;

public class Chicken extends AbstractAnimal implements Fly{

	@Override
	public void sound() {
		System.out.println("꼬꼬댁");
	}
	
	@Override
	public void fly() {
		System.out.println("닭이 날아간다");
	}
}
