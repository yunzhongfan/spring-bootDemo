package annotation.shizhan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    public enum ValidateType {
        OBJECT, LIST
    }

    // 默认是Object
    ValidateType value() default ValidateType.OBJECT;

    // 默认非空
    boolean notBlank() default true;

    // 默认参数0
    int params() default 0;

    // 默认错误信息空
    String errorMsg() default "";
}
