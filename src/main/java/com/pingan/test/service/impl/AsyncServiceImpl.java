package com.pingan.test.service.impl;

import com.pingan.test.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步执行
 * 1、启动类添加注解：@EnableAsync
 * 2、定义线程池相应参数:TaskThreadPoolConfig
 * 3、设置线程池参数：AsyncTaskExecutePool
 */

/**
 * 拒绝策略
 * 1、AbortPolicy：直接抛出java.util.concurrent.RejectedExecutionException异常
 * 2、CallerRunsPolicy:主线程直接执行该任务，执行完之后尝试添加下一个任务到线程池中，
 * 这样可以有效降低向线程池内添加任务的速度
 *
 * 当队列中的任务满了之后，如果线程直接抛异常，那么这个任务就会被丢弃。如果是CallerRunsPolicy，
 * 则会用主线程去执行，也就是同步执行，最起码任务不会被丢弃
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    @Async
    public void testAsync() throws InterruptedException {
        Thread.sleep(5000);
        System.err.println("current Thread run: " + Thread.currentThread().getName());
    }
}
