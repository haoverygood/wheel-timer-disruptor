package org.throwable.validators;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.throwable.Application;
import org.throwable.validators.entity.Entity1;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/16 11:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class LengthLimitConstraintValidatorTest {

    @Autowired
    private Validator validator;

    @Test
    public void testLengthLimitValid() throws Exception {
        Entity1 entity1 = new Entity1();
        entity1.setValue("zjc123");
        Set<ConstraintViolation<Entity1>> result = validator.validate(entity1);
        Iterator<ConstraintViolation<Entity1>> iterator =  result.iterator();
        while (iterator.hasNext()){
            ConstraintViolation<Entity1> constraintViolation = iterator.next();
            System.out.println("Message --> " + constraintViolation.getMessage());
        }
    }
}