package org.throwable.disruptor;

import java.util.concurrent.ThreadFactory;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/14 15:46
 */
public class DefaultThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }
}
