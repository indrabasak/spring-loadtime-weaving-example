package com.basaki.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@code CustomAnnotation} is annotation for marking a method.
 * <p/>
 * Given a method like this:
 * <pre><code>
 *     {@literal @}CustomAnnotation(description = "My description")
 *     public String someMethod(String name) {
 *         return "Hello " + name;
 *     }
 * </code></pre>
 * <p>
 *
 * @author Indra Basak
 * @since 02/07/18
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {

    String description() default "";
}
