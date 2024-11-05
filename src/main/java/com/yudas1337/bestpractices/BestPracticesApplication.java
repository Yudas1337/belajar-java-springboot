package com.yudas1337.bestpractices;

import com.yudas1337.bestpractices.config.MessageConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MessageConfig.class)
public class BestPracticesApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BestPracticesApplication.class, args);
    }
}
