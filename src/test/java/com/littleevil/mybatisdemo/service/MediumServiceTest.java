package com.littleevil.mybatisdemo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MediumServiceTest {

    @Autowired
    private MediumService mediumService;

    @Test
    public void buyHouseLock() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread thread1 = new Thread(() -> {
            mediumService.buyHouseLock(1, 2);
            countDownLatch.countDown();
        },"thread1");

        Thread thread2 = new Thread(() -> {
            mediumService.buyHouseLock(1, 1);
            countDownLatch.countDown();
        },"thread2");
        thread1.start();
        thread2.start();
        countDownLatch.await();
    }

    @Test
    public void buyHouse() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread thread1 = new Thread(() -> {
            mediumService.buyHouse(1, 2);
            countDownLatch.countDown();
        },"thread1");

        Thread thread2 = new Thread(() -> {
            LockSupport.parkNanos(100);
            mediumService.buyHouse(1, 1);
            countDownLatch.countDown();
        },"thread2");
        thread1.start();
        thread2.start();
        countDownLatch.await();
    }

}