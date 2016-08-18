package by.htp.lib.domain;

public class Book {

	private String title;
	private double price;
	
	public Book(String title, double price, String author) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	private String author;
	
}
