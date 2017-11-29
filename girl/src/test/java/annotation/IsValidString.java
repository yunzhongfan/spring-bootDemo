package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.springframework.util.StringUtils;





@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsValidString.ValidStringChecker.class)
@Documented
public @interface IsValidString {
	
	
String message() default "The string is invalid.";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default{};
    
    class ValidStringChecker implements ConstraintValidator<IsValidString,String>
    {

        @Override
        public void initialize(IsValidString arg0)
        {    
        }

        @Override
        public boolean isValid(String strValue, ConstraintValidatorContext context)
        {
            if(StringUtils.isEmpty(strValue))
            {
                return true;
            }
            if(strValue.contains("<"))
            {
                return false;
            }
            return true;
        }
        
    }

}
