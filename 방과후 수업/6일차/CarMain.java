package extends1.overriding;

public class CarMain {
	
	public static void main(String[] args) {
		ElectricCar electriccar = new ElectricCar();
		electriccar.Move();
		electriccar.charge();
		electriccar.OpenDoor();
		
		GasCar gascar = new GasCar();
		gascar.Move();
		gascar.fillUp();
		gascar.OpenDoor();
	}
	
}
