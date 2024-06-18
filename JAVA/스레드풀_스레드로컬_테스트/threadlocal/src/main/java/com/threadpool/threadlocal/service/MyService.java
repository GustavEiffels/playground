package com.threadpool.threadlocal.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@EnableAsync
@RequiredArgsConstructor
public class MyService {

    private final ThreadLocalService service;
    public  static StringBuilder beforeValue  = new StringBuilder();
    public  static StringBuilder afterValue   = new StringBuilder();

    @Async("taskExecutor")
    public void asyncMethod(String value) {

        String beforeRetrievedValue = service.getThreadLocal();
        beforeValue.append("Before Retrived Value : "+beforeRetrievedValue+" in thread: "+Thread.currentThread().getName()+"\n");
        
        service.setThreadLocal(value);

        String retrievedValue = service.getThreadLocal();
        afterValue.append("Value in asyncMethod: " + retrievedValue + " in thread: " + Thread.currentThread().getName()+"\n");
        
        // service.clearThreadLocal(); // ** 추가 
    }
}
