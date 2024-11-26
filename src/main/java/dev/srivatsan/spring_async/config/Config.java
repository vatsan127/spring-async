package dev.srivatsan.spring_async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class Config {
    @Bean(name = "customAsyncTaskExecutor")
    public Executor customAsyncTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1); // Min Thread Size
        executor.setMaxPoolSize(2); // Max Thread Size
        executor.setQueueCapacity(3); // Queue Capacity
        executor.setThreadNamePrefix("NewThread-");
        executor.initialize();
        return executor;
    }
}
