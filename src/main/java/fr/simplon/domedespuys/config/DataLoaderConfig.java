package fr.simplon.domedespuys.config;

import com.github.javafaker.Faker;
import fr.simplon.domedespuys.entity.User;
import fr.simplon.domedespuys.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Random;

@Component
@AllArgsConstructor
public class DataLoaderConfig implements CommandLineRunner {

    private UserRepository userRepository;

    @Override
    public void run(String @NonNull ... args) {
        createUsers();
    }

    private void createUsers() {
        if (0 == userRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));

            for (int i = 0; i < 20; i++) {
                User user = new User();
                user.setFirstname(faker.name().firstName());
                user.setLastname(faker.name().lastName());
                String email = faker.internet().emailAddress((user.getFirstname() + "." + user.getLastname()).toLowerCase());
                user.setEmail(email);
                user.setPassword(faker.internet().password(12, 20));
                if (hasProbability(2, 3)) {
                    user.setPhone(faker.phoneNumber().phoneNumber());
                }
                LocalDateTime localDate = new java.sql.Date(faker.date().birthday(0, 5).getTime()).toLocalDate().atTime(0, 0);
                user.setCreatedAt(localDate);
                userRepository.save(user);
            }

            userRepository.flush();
        }
    }

    private boolean hasProbability(int expected, int max) {
        Random random = new Random();
        // random.nextInt(max) = génère un entier aléatoire entre 0 et MAX
        // expected = la proba attendue
        // Si le random est inférieure ou égale à la prob, alors on renvoie true
        return random.nextInt(max) < expected;
    }

}