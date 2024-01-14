package com.ceviz.anotation;

import com.ceviz.constant.Messages;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ThisYearValidator.class)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface ThisYear {

    String message() default Messages.YEAR_ANOTATION_MESSAGE;

    short key() default 0;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
