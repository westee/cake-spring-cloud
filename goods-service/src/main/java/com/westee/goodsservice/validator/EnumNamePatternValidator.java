package com.westee.goodsservice.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumNamePatternValidator implements ConstraintValidator<DiscountTypePattern, Enum<?>> {
    private DiscountTypePattern annotation;

    @Override
    public void initialize(DiscountTypePattern constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Enum<?> anEnum, ConstraintValidatorContext constraintValidatorContext) {
        if (anEnum == null) {
            return true;
        }
        Object[] enumValues = this.annotation.enumClass().getEnumConstants();
        for (Object enumValue : enumValues) {
            if (anEnum.equals(enumValue.toString())) {
                return true;
            }
        }
        return false;
    }


}
