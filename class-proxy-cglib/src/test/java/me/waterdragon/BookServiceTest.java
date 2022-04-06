package me.waterdragon;

import java.lang.reflect.Method;

import org.junit.Test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class BookServiceTest {

	@Test
	public void di() {
		MethodInterceptor handler = new MethodInterceptor() {
			BookService bookService = new BookService();

			@Override
			public Object intercept(Object o, Method method, Object[] objects,
				MethodProxy methodProxy) throws Throwable {
				if (method.getName().equals("rent")) {
					System.out.println("aaa");
					Object invoke = method.invoke(bookService, objects);
					System.out.println("bbb");
					return invoke;
				}
				return method.invoke(bookService, objects);
			}
		};

		BookService bookService = (BookService)Enhancer.create(BookService.class, handler);

		Book book = new Book();
		book.setTitle("spring");
		bookService.rent(book);
		bookService.returnBook(book);
	}
}
