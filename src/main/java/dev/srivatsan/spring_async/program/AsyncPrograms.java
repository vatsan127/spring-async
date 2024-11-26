package dev.srivatsan.spring_async.program;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class AsyncPrograms {

    /* Implicitly If any ThreadPoolTaskExecutor bean is created SpringBoot
    will use that else by Default SimpleAsyncTaskExecutor will be used

    @Async or @Async("customAsyncTaskExecutor") both are correct if ThreadPoolTaskExecutor bean is created
    */
    @Async
    public void printThreadName(int i) throws InterruptedException {
        String str = "TaskStarted: '%s', Thread Name: '%s'";
        System.out.println(String.format(str, String.valueOf(i), Thread.currentThread().getName()));
        if (true) {

            throw new RuntimeException();
        }
        TimeUnit.SECONDS.sleep(20);
        str = "TaskCompleted: '%s', Thread Name: '%s'";
        System.out.println(String.format(str, String.valueOf(i), Thread.currentThread().getName()));
    }

}
