package org.throwable.validators;

import org.throwable.validators.annotation.LengthLimit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/16 11:37
 */
public class LengthLimitConstraintValidator implements ConstraintValidator<LengthLimit, String> {

    private LengthLimit lengthLimit;

    @Override
    public void initialize(LengthLimit lengthLimit) {
        this.lengthLimit = lengthLimit;
    }

    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
        if (input.length() <= lengthLimit.length()) {
            return true;
        }
        //禁用默认校验实现
        constraintValidatorContext.disableDefaultConstraintViolation();
        //使用注解中定义的模板,注解中的{xxx}中的xxx是对应classpath:valid/validation.properties下的key
        //模板中的{max}这种占位符会直接读取注解中的字段,例如LengthLimit定义了max字段,会直接被替换成模板
        //org.throwable.valid.lengthLimit.message=字符串过长,限制最大长度为{max}中的max
        constraintValidatorContext.buildConstraintViolationWithTemplate(lengthLimit.message()).addConstraintViolation();
        return false;
    }
}
