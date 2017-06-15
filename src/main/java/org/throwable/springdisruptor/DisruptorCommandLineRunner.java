package org.throwable.springdisruptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/15 11:14
 */
@Component
public class DisruptorCommandLineRunner implements CommandLineRunner {

    @Autowired
    private DisruptorSpringProvider disruptorSpringProvider;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 20; i++) {
            disruptorSpringProvider.publish(System.currentTimeMillis());
        }
    }
}
