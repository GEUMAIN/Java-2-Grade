package extends1.exA;

public class Movie extends item{
	public String director;
	public String actor;
	
	public Movie(String name, int price, String c, String d) {
		super(name,price);
		director = c;
		actor = d;
		
	}

	@Override
	public void print() {
		super.print();
		System.out.println("- 감독 : " + director + ", 배우 : " + actor);
	}
	

}
