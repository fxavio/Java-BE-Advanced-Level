package org.javaadvancedlevel.lab1.reflectionandannotations.two;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation to specify validation constraints for method parameters.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ParameterValidation {
    // Minimum value for the parameter (default is the minimum value of int)
    int min() default Integer.MIN_VALUE;

    // Maximum value for the parameter (default is the maximum value of int)
    int max() default Integer.MAX_VALUE;
}
