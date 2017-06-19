package org.throwable.validators.entity;

import org.throwable.validators.annotation.LengthLimit;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/16 11:46
 */
public class Entity1 {

    @LengthLimit(length = 5,max = 3)
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
