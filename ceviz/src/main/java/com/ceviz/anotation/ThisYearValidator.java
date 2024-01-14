package com.ceviz.anotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
public class ThisYearValidator implements ConstraintValidator<ThisYear, Short> {


    @Override
    public void initialize(ThisYear constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Short value, ConstraintValidatorContext context) {
        LocalDate now = LocalDate.now();
        short year = (short) now.getYear();
        return value <= year;
    }
}