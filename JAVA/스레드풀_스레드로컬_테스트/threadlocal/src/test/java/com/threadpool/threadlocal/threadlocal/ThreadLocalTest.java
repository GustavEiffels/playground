package com.threadpool.threadlocal.threadlocal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.threadpool.threadlocal.service.MyService;

@SpringBootTest
public class ThreadLocalTest {

    @Autowired
    private MyService mService;

    @Test
    void 테스트() throws InterruptedException{
        System.out.println(":: Thread Local Test START ::");
        System.out.println("");
        System.out.println("");

        for (int i = 1; i < 6; i++) {
            mService.asyncMethod("Value-" + i);
        }

        Thread.sleep(3000);

        System.out.println("before values : ");
        System.out.println(mService.beforeValue);
        System.out.println();
        System.out.println("after values : ");
        System.out.println(mService.afterValue);


        System.out.println("");
        System.out.println("");
        System.out.println(":: Thread Local Test END ::");
    }
}
