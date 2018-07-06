/**
 * 
 */
package com.internal.customAnnotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.internal.validations.EquinitiEmailValidator;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = EquinitiEmailValidator.class)
public @interface EquinitiEmail {

	public String message() default "Please enter a valid email Id, Email Id should be in the form of abc@equiniti.com";

	Class<?>[] groups() default {};

	public Class<? extends Payload>[] payload() default {};

}
