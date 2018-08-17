package booksystem.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;


@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthPassport {
	boolean validate() default true;

}
