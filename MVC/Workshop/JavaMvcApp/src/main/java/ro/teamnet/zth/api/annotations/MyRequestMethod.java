package ro.teamnet.zth.api.annotations;

/**
 * Created by user on 7/14/2016.
 */

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.METHOD})
@Retention(RUNTIME)
@Documented
public @interface MyRequestMethod {
    String methodType() default "GET";
    String urlPath();
}
