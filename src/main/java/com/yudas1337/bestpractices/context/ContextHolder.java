package com.yudas1337.bestpractices.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ContextHolder {

    private static final ThreadLocal<Long> currentRequestId = new ThreadLocal<>();
    private static ApplicationContext applicationContext;

    public static Long getId() {
        return currentRequestId.get();
    }

    public static void setId(Long id) {
        currentRequestId.set(id);
    }

    public static void clear() {
        currentRequestId.remove();
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        ContextHolder.applicationContext = applicationContext;
    }
}