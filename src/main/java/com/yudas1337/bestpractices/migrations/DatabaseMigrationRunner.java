package com.yudas1337.bestpractices.migrations;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class DatabaseMigrationRunner implements CommandLineRunner {

    @Autowired
    private Environment env;

    @Override
    public void run(String... args) {
        Flyway flyway = Flyway.configure()
                .dataSource(
                        env.getProperty("spring.datasource.url"),
                        env.getProperty("spring.datasource.username"),
                        env.getProperty("spring.datasource.password")
                )
                .locations("classpath:db/migration")
                .load();

        flyway.migrate();
    }
}