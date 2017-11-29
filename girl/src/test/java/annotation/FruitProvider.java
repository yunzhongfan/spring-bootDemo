package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 注解元素必须有确定的值，要么在定义注解的默认值中指定，要么在使用注解时指定，非基本类型的注解元素的值不可为null。因此, 
使用空字符串或0作为默认值是一种常用的做法。这个约束使得处理器很难表现一个元素的存在或缺失的状态，因为每个注解的声明中，所有元素都存在，
并且都具有相应的值，为了绕开这个约束，我们只能定义一些特殊的值，
例如空字符串或者负数，一次表示某个元素不存在，在定义注解时，这已经成为一个习惯用法*/

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {

	/**
	 * 
	 * 供应商ID
	 * 
	 * @return
	 */
	public int id() default -1;

	/**
	 * 供应商名称
	 * 
	 * @return
	 */
	public String name() default "";

	/**
	 * 供应商名称
	 * 
	 */
	public String address() default "";

}
