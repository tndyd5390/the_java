package me.waterdragon;

@MyAnnotation(name = "sooyong", number = 100)
public class Book {

	private String a = "a";
	private static String B = "BOOK";
	@MyAnnotation
	private static final String C = "BOOK";
	public String d = "d";
	protected String e = "e";

	public Book() {
	}

	@AnotherAnnotation
	public Book(String a, String d, String e) {
		this.a = a;
		this.d = d;
		this.e = e;
	}

	private void f() {
		System.out.println("F");
	}

	@AnotherAnnotation
	public void g() {
		System.out.println("g");
	}

	public int h() {
		return 100;
	}

}
