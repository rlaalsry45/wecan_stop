package com.z5.zcms.admsys.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = {BoardCheckValidator.class})
@Documented 
@Target( { ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) 
public @interface BoardCheck {

	String message() default ""; 
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
