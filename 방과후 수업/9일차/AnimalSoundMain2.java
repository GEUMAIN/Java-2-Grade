package poly.ex2;

public class AnimalSoundMain2 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		Cow cow = new Cow();
		
		Animal A[] = {dog,cat,cow};
		
		for (int i = 0; i < 3; i++) {
			System.out.println("동물소리 테스트 시작");
			A[i].sound();
			System.out.println("동물소리 테스트 종료");
		}
	}
}
