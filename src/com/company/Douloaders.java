package com.company;

import  java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;


public class Douloaders extends Thread{
    private Semaphore semaphore;
    private CountDownLatch xdl;
    private int speedDownload = 100;
    private CountDownLatch cdl;


    public Douloaders(String name, Semaphore semaphore,
                       CountDownLatch countDownLatch,
                       CountDownLatch countDownLatch1) {
        super(name);
        this.cdl = countDownLatch;
        this.semaphore = semaphore;
        this.xdl = countDownLatch1;
        start();
    }

    @Override
    public synchronized void run() {
        try {
            cdl.await();
            semaphore.acquire();

            System.out.println(getName() + " скачивает из сервера файл");
            sleep(500 / speedDownload * 1000);


            System.out.println(getName() + " успешно скачен файл из сервера ");

            xdl.countDown();
            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

