package com.westee.goodsservice.validator;

import com.westee.goodsservice.generate.Coupon;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StartBeforeEndValidator implements ConstraintValidator<StartBeforeEnd, Coupon> {
    @Override
    public void initialize(StartBeforeEnd constraintAnnotation) {
    }

    @Override
    public boolean isValid(Coupon value, ConstraintValidatorContext context) {
        return value.getStartDate().isBefore(value.getEndDate());
    }
}
