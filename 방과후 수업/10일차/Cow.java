package poly.ex4;

public class Cow implements InterFaceAnimal{
	@Override
	public void sound() {
		System.out.println("옴메");
	}
	
	@Override
	public void move() {
		System.out.println("소 이동");
	}
}
