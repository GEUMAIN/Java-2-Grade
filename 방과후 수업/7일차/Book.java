package extends1.exA;

public class Book extends item{
	private String author;
	private String isbn;
	
	
	public Book(String name, int price, String c, String d) {
		super(name,price);
		this.author = c;
		this.isbn = d;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("- 저자 : " + author + ", isbn : " + isbn);
	}
	
}
