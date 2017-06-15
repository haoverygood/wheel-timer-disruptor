package org.throwable.disruptor;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/14 15:40
 */
public class Main {

    private static AtomicInteger pushCount = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        EventFactory<LongEvent> eventFactory = new LongEventFactory();
        int ringBufferSize = 8;
        ThreadFactory threadFactory = new DefaultThreadFactory();
        Disruptor<LongEvent> disruptor = new Disruptor<>(eventFactory, ringBufferSize, threadFactory, ProducerType.SINGLE,
                new BlockingWaitStrategy());
        WorkHandler[] array = new WorkHandler[3];
        for (int i = 0; i < 3; i++) {
            array[i] = new LongEventWorkHandler();
        }
        disruptor.handleEventsWithWorkerPool(array);
        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        for (int i = 0; i < 20; i++) {
            publish(ringBuffer);
        }
        Thread.sleep(Integer.MAX_VALUE);
    }

    private static void publish(RingBuffer<LongEvent> ringBuffer) {
        long sequence = ringBuffer.next();
        try {
            LongEvent event = ringBuffer.get(sequence);
            long data = getEventData();
            event.setValue(data);
        } finally {
            ringBuffer.publish(sequence);
        }
    }


    private static long getEventData() {
        System.out.println("current count --> " + pushCount.incrementAndGet());
        return System.currentTimeMillis();
    }
}
