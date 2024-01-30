package com.westee.goodsservice.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = EnumNamePatternValidator.class)
public @interface DiscountTypePattern {
    Class<? extends Enum<?>> enumClass();
    String message() default "Invalid value. Must be one of: {enumClass.values()}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
