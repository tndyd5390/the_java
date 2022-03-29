package me.waterdragon.di;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContainerServiceTest {

	@Test
	public void getObject_BookRepository() {
		BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
		assertNotNull(bookRepository);
	}

	@Test
	public void getObject_BookService() {
		BookService bookService = ContainerService.getObject(BookService.class);
		assertNotNull(bookService);
		assertNotNull(bookService.bookRepository);
	}
}
