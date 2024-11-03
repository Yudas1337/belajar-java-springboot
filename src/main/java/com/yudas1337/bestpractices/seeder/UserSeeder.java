package com.yudas1337.bestpractices.seeder;

import com.yudas1337.bestpractices.entity.User;
import com.yudas1337.bestpractices.repository.UserRepository;
import com.yudas1337.bestpractices.security.BCrypt;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class UserSeeder {

    private static UserRepository userRepository;

    @Autowired
    public UserSeeder(UserRepository userRepository) {
        UserSeeder.userRepository = userRepository;
    }

    public static void run() {
        Faker faker = new Faker(new Locale("in-ID"));
        for (int i = 0; i < 100; i++) {

            if (userRepository.existsById(String.valueOf(i + 1))) {
                break;
            }

            User user = new User();
            user.setName(faker.name().fullName());
            user.setUsername("User-" + i);
            user.setPassword(BCrypt.hashpw(faker.internet().password(), BCrypt.gensalt()));
            user.setToken(faker.internet().password());
            user.setTokenExpiredAt((long) faker.number().randomDigit());
            userRepository.save(user);

            System.out.println("Generating user: " + user.getUsername());

        }
    }

}
