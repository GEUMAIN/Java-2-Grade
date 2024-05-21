package poly.ex6;

public class InterfaceMain {
	public static void main(String[] args) {
		
		AbstractAnimal dog = new Dog();
		AbstractAnimal abbird = new Bird();
		AbstractAnimal abchicken = new Chicken();
		
		Fly bird = new Bird();
		Fly chicken = new Chicken();
		
		animalsound(dog);
		animalsound(abchicken);
		animalsound(abbird);
		
		animalfly(chicken);
		animalfly(bird);
		
		dog.move();
		abbird.move();
		abchicken.move();
	}
	
	public static void animalsound(AbstractAnimal animal) {
		animal.sound();
	}
	
	public static void animalfly(Fly fly) {
		fly.fly();
	}
}
