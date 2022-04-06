package me.waterdragon;

public class BookService {
	void rent(Book book) {
		System.out.println("rent : " + book.getTitle());
	}

	void returnBook(Book book) {
		System.out.println("return : " + book.getTitle());
	}
}
