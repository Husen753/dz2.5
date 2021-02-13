package com.company;

import java.util.concurrent.CountDownLatch;

public class Uploader extends Thread {
    private CountDownLatch cdl;
    private int file = 500;
    private int speed = 20;


    public Uploader(CountDownLatch countDownLatch) {
        this.cdl = countDownLatch;
        start();
    }

    @Override
    public void run() {
        System.out.println("_______________________");
        System.out.println("Началась загрузка файла на сервер");
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("**************");
                sleep(file / speed * 100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("загрузка завершена ");
        cdl.countDown();

    }
}
