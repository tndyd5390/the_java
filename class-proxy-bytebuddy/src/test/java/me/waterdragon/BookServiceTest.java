package me.waterdragon;

import static net.bytebuddy.matcher.ElementMatchers.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;

public class BookServiceTest {

	@Test
	public void di() throws
		NoSuchMethodException,
		InvocationTargetException,
		InstantiationException,
		IllegalAccessException {

		Class<? extends BookService> proxyClass = new ByteBuddy()
			.subclass(BookService.class)
			.method(named("rent"))
			.intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
				BookService bookService = new BookService();

				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					System.out.println("test");
					Object invoke = method.invoke(bookService, args);
					System.out.println("aaa");
					return invoke;
				}
			}))
			.make().load(BookService.class.getClassLoader()).getLoaded();

		BookService bookService = proxyClass.getConstructor(null).newInstance();
		Book book = new Book();
		book.setTitle("spring");
		bookService.rent(book);
		bookService.returnBook(book);
	}
}
