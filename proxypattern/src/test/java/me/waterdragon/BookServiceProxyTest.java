package me.waterdragon;

import org.junit.Test;

public class BookServiceProxyTest {

	BookService bookService = new BookServiceProxy(new DefaultBookService());

	@Test
	public void proxy() {
		Book book = new Book();
		book.setTitle("spring");
		bookService.rent(book);
	}
}
