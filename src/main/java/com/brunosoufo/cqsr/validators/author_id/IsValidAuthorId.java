package com.brunosoufo.cqsr.validators.author_id;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * CategoryIdConstraint
 */
@Constraint(validatedBy = AuthorIdValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidAuthorId {

    String message() default "Invalid author Id";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}