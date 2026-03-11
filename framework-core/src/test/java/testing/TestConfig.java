package testing;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// integration testing config
@Configuration
@Profile("dev")
public class TestConfig {

    @Bean
    public UserRepository userRepository() {
        return Mockito.mock(UserRepositoryImpl.class);
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }
}
