package org.throwable.springdisruptor;

import org.springframework.stereotype.Service;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/15 10:58
 */
@Service
public class SpringLongEventService {

    public <T> void process(SpringLongEvent<T> springLongEvent) throws Exception {
        Thread.sleep(100);
        System.out.println("SpringLongEventService process.Current event --> " + springLongEvent.getValue());
    }
}
