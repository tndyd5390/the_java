package me.waterdragon;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class BookServiceProxyTest {

	BookService bookService = (BookService)Proxy.newProxyInstance(
		BookService.class.getClassLoader(),
		//이 프록시 인스턴스가 어떤 인터페이스 타입이냐
		new Class[] {BookService.class},
		//이 프록시의 메서드가 호출될때 어떻게 처리할 것이냐
		new InvocationHandler() {
			//여기서 리얼 서브젝트를 들고있어야함
			BookService bookService = new DefaultBookService();

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if (method.getName().equals("rent")) {
					System.out.println("aaaa");
					Object invoke = method.invoke(bookService, args);
					System.out.println("bbbb");
					return invoke;
				}

				return method.invoke(bookService, args);
			}
		});// 이와 같은 코드는 유연하지 못하다. 그래서 Spring AOP를 사용할 수 있다.
	//또한 위 구조는 new Class[]에 전해주는 파라미터가 반드시 인터페이스여야 한다.

	@Test
	public void proxy() {
		Book book = new Book();
		book.setTitle("spring");
		bookService.rent(book);
		bookService.returnBook(book);
	}
}
