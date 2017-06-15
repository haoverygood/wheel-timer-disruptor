package org.throwable.springdisruptor;

import com.lmax.disruptor.WorkHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/15 10:57
 */
@Component(value = "springLongEventWorkHandler")
@Scope(value = "prototype")
public class SpringLongEventWorkHandler<T> implements WorkHandler<SpringLongEvent<T>>{

    @Autowired
    private SpringLongEventService springLongEventService;

    @Override
    public void onEvent(SpringLongEvent<T> event) throws Exception {
         springLongEventService.process(event);
         event.clear();
    }
}
