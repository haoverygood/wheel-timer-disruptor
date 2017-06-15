package org.throwable.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/14 15:35
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long sequence, boolean endOfBatch) throws Exception {
        Thread.sleep(1000);
        System.out.println("Receive event --> " + longEvent.getValue());
    }
}
