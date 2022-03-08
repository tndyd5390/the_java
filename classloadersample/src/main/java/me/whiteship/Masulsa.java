package me.whiteship;

public class Masulsa {

    public static void main(String[] args) {
//        ClassLoader classLoader = Masulsa.class.getClassLoader();
//        TypePool typePool = TypePool.Default.of(classLoader);
//
//        try {
//            new ByteBuddy().redefine(typePool.describe("me.whiteship.Moja").resolve(),
//                ClassFileLocator.ForClassLoader.of(classLoader))
//                .method(named("pullOut"))
//                .intercept(FixedValue.value("Rabbit!"))
//                .make().saveIn(new File("/Users/sooyong/the_java/classloadersample/target/classes/"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println(new Moja().pullOut());
    }
}
