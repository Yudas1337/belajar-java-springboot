package com.yudas1337.bestpractices.seeder;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        UserSeeder.run();
    }
}
