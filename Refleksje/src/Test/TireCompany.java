package Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TireCompany {
    String manufacturer() default "";

    String tireSize() default "";
}
