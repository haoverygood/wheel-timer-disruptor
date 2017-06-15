package org.throwable.springdisruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/15 10:55
 */
public class SpringLongEventFactory<T> implements EventFactory<SpringLongEvent<T>>{

    @Override
    public SpringLongEvent<T> newInstance() {
        return new SpringLongEvent<>();
    }
}
