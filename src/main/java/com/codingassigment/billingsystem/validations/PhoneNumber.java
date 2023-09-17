package com.codingassigment.billingsystem.validations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface PhoneNumber {
    String message() default "Phone number must start with '959'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
