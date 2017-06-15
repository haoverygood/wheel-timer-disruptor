package org.throwable.springdisruptor;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WorkHandler;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.throwable.disruptor.DefaultThreadFactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/15 11:00
 */
@Component
public class DisruptorSpringProvider implements InitializingBean, DisposableBean, ApplicationContextAware {

    //default ringbuffer size
    private static final int DEFAULT_RINGBUFFER_SIZE = 8;
    //default work handler numbers
    private static final int DEFAULT_CONSUMER_NUMBERS = 3;
    //Disruptor core component
    private Disruptor<SpringLongEvent<Long>> disruptor;
    //spring application context
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        EventFactory<SpringLongEvent<Long>> eventFactory = new SpringLongEventFactory<>();
        ThreadFactory threadFactory = new DefaultThreadFactory();
        disruptor = new Disruptor<>(eventFactory, DEFAULT_RINGBUFFER_SIZE, threadFactory,
                ProducerType.SINGLE, new YieldingWaitStrategy());
        WorkHandler[] array = new WorkHandler[3];
        for (int i = 0; i < DEFAULT_CONSUMER_NUMBERS; i++) {
            SpringLongEventWorkHandler workHandler =
                    applicationContext.getBean("springLongEventWorkHandler", SpringLongEventWorkHandler.class);
            array[i] = workHandler;
        }
        disruptor.handleEventsWithWorkerPool(array);
        disruptor.start();
    }

    @Override
    public void destroy() throws Exception {
        disruptor.shutdown(15, TimeUnit.SECONDS);
    }

    /**
     * publish data
     */
    public void publish(Long data) {
        RingBuffer<SpringLongEvent<Long>> ringBuffer = disruptor.getRingBuffer();
        long sequence = ringBuffer.next();
        try {
            SpringLongEvent<Long> event = ringBuffer.get(sequence);
            event.setValue(data);
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}
