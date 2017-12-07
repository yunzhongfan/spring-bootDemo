package annotation.shizhan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateRule {
    String ruleName();  //在使用注解的时候ruleName的值不能为空

    String params() default "";

    String errorMsg();
}