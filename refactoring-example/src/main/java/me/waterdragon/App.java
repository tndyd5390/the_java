package me.waterdragon;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws ClassNotFoundException {
		//클래스 인스턴스 정보를 가져오는 방법
		Class<Book> bookClass = Book.class;
		Book book = new Book();
		Class<? extends Book> aClass = book.getClass();
		//full qulified class name
		Class.forName("me.waterdragon.Book");

		Arrays.stream(bookClass.getFields()).forEach(System.out::println);
		Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);
		Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
			try {
				f.setAccessible(true);
				System.out.printf("%s %s\n", f, f.get(book));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		});

		Arrays.stream(bookClass.getMethods()).forEach(System.out::println);
		Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);
		System.out.println(MyBook.class.getSuperclass());

		Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

		Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
			int modifiers = f.getModifiers();
			System.out.println(f);
			System.out.println(Modifier.isPrivate(modifiers));
			System.out.println(Modifier.isStatic(modifiers));
		});

		Arrays.stream(Book.class.getMethods()).forEach(m -> {
			int modifiers = m.getModifiers();
			// m.getReturnType();
			// m.getParameterTypes();
			
		});
	}
}
