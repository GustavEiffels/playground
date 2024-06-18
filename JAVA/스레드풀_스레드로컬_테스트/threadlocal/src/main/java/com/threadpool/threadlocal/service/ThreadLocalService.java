package com.threadpool.threadlocal.service;

import org.springframework.stereotype.Service;

@Service
public class ThreadLocalService {
    
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void setThreadLocal(String value) {
        threadLocal.set(value);
    }

    public String getThreadLocal() {
        String value = threadLocal.get();
        return value;
    }

    public void clearThreadLocal() {
        threadLocal.remove();
    }
}
