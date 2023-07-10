package com.towerbuilder.proposalsubmitter.validator;

import com.towerbuilder.proposalsubmitter.validator.impl.LastDayIsAfterFirstDayImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented // adnotacja jest adnotacja
@Target(ElementType.TYPE) // nad czym zostanie uzyte czy pole/pola/klasa itp
@Retention(RetentionPolicy.RUNTIME) // czasu kiedy zostanie uzyta adnotacja
@Constraint(validatedBy = LastDayIsAfterFirstDayImpl.class)
public @interface LastDayIsAfterFirstDay {
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
