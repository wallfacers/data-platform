package com.wallfacers.data.platform.common;



import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 命名的线程工厂
 *
 * @author wallfacers
 */
public class NamedThreadFactory implements ThreadFactory {

        private final ThreadFactory defaultThreadFactory = Executors.defaultThreadFactory();

        private final AtomicInteger threadNumber = new AtomicInteger(1);

        private final String threadPrefix;

        public NamedThreadFactory(String threadPrefix) {
            this.threadPrefix = threadPrefix;
        }

        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = this.defaultThreadFactory.newThread(runnable);
            thread.setName(this.threadPrefix + "-" + this.threadNumber);
            return thread;
        }
}
