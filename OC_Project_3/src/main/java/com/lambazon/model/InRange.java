package com.lambazon.model;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { InRangeValidator.class })
public @interface InRange {
    String message() default "{inrange.message}";
 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
 
    double min() default Double.MIN_VALUE;
 
    double max() default Double.MAX_VALUE;
}
