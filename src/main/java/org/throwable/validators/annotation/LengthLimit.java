package org.throwable.validators.annotation;

import org.throwable.validators.LengthLimitConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/16 11:36
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = LengthLimitConstraintValidator.class)
public @interface LengthLimit {

    int length();
    int max();
    String message() default "{org.throwable.valid.lengthLimit.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
