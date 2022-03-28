package me.waterdragon;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//기본적으로는 어노테이션은 주석과 같은 취급
@Retention(RetentionPolicy.RUNTIME) //어노테이션의 유지 범위 기본은 class
@Target({ElementType.TYPE, ElementType.FIELD}) //어노테이션을 붙일수 있는 위치
@Inherited //이걸 붙이면 얘는 상속이 되는 annotation이다.
public @interface MyAnnotation {
	//어노테이션은 값을 가질수 있음
	String name() default "sooyong";

	int number() default 100;

	//value라고 쓰면 값을 줄때 그냥 주면 된다 @MyAnnotation("여기 value");
	String value() default "sooyong";

}
