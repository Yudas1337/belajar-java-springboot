package com.yudas1337.bestpractices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class BestPracticesApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;
    
    @Test
    void contextLoads() {
        // Test to ensure the application context loads successfully
    }

}
