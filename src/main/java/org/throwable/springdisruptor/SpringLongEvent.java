package org.throwable.springdisruptor;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/15 10:54
 */
public class SpringLongEvent<T> implements ClearableEvent{

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void clear(){
        value = null;
    }
}
