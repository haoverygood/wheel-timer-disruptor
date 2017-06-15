package org.throwable.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/14 15:34
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
