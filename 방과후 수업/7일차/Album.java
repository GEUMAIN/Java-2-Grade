package extends1.exA;

public class Album extends item{
	public String artist;
	
	public Album(String name, int price, String c) {
		super(name, price);
		artist = c;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("- 아티스트 : " + artist);
	}
}
