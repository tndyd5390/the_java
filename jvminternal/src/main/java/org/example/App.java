package org.example;

/**
 * Hello world!
 */
public class App {

    //클래스 로더의 preparation에서 값을 할당함
    static String name = "sooyong";

    public static void main(String[] args) {
        //링크하는 과정에서는 심볼릭 레퍼런스임 클래스 로더의 resolve 과정에서 실제 레퍼런스로 교체함 optional
        Book book = new Book();
        ClassLoader classLoader = App.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }
}
