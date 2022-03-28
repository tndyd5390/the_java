package me.waterdragon;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws
		ClassNotFoundException,
		NoSuchMethodException,
		InvocationTargetException,
		InstantiationException,
		IllegalAccessException, NoSuchFieldException {

		Class<?> bookClass = Class.forName("me.waterdragon.Book");
		Constructor<?> constructor = bookClass.getConstructor(null);
		Book book = (Book)constructor.newInstance();
		Constructor<?> stringConstructor = bookClass.getConstructor(String.class);
		Book stringBook = (Book)stringConstructor.newInstance("mybook");
		System.out.println(stringBook);

		Field a = Book.class.getDeclaredField("A");
		System.out.println(a.get(null));

		a.set(null, "AAAAA");
		System.out.println(a.get(null));

		Field b = Book.class.getDeclaredField("B");
		b.setAccessible(true);
		System.out.println(b.get(stringBook));

		b.set(stringBook, "AAAAA");
		System.out.println(b.get(stringBook));

		Method c = Book.class.getDeclaredMethod("c");
		c.setAccessible(true);
		c.invoke(book);

		Method d = Book.class.getDeclaredMethod("d", int.class, int.class);
		int invoke = (int)d.invoke(book, 1, 2);
		System.out.println(invoke);
	}
}
