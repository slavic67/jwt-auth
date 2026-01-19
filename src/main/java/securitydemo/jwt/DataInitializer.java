package securitydemo.jwt;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import securitydemo.entity.Authority;
import securitydemo.entity.User;
import securitydemo.repositories.AuthorityRepository;
import securitydemo.repositories.UserRepository;

import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepository userRepository,
                                AuthorityRepository authorityRepository,
                                PasswordEncoder passwordEncoder) {

        return args -> {

            if (userRepository.count() > 0) {
                return; // пользователи уже есть
            }

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setActive(true);

            Authority adminRole = new Authority();
            adminRole.setAuthority("ROLE_ADMIN");
            adminRole.setUser(admin);

            admin.setAuthorities(Set.of(adminRole));

            userRepository.save(admin);
        };
    }
}
