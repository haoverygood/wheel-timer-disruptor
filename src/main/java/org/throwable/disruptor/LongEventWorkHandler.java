package org.throwable.disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/14 16:27
 */
public class LongEventWorkHandler implements WorkHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent event) throws Exception {
        Thread.sleep(1000);
        System.out.println("LongEventWorkHandler receive event -> " + event.getValue());
    }
}
