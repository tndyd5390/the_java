package me.waterdragon;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AnotherAnnotation {
	String name() default "sooyong";

	int number() default 100;
}
