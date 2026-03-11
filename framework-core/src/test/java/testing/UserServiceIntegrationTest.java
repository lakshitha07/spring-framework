package testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

// integration testing of service bean
// here spring loads the application context based on the test configs
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
//below annotation combines both ExtendWith & ContextConfiguration
//@SpringJUnitConfig(TestConfig.class)
@TestPropertySource(properties = {"username=foo","password=bar"},
        locations = "classpath:test.properties")
@ActiveProfiles("dev")
public class UserServiceIntegrationTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Value("${username}")
    private String username;
    @Value("${app.name}")
    private String appName;

    @Test
    // below annotation forces to destroy the application context including the cache after running the test method.
    // when next test method runs, a fresh application context will be created
    //@DirtiesContext
    void getUserName_validId_returnUser() {
        when(userRepository.findUserNameById(1)).thenReturn("Alice");
        String result = userService.getUserName(1);
        assertEquals("Alice", result);
    }

    @Test
    void printProperties() {
        assertEquals("foo", username);
        assertEquals("TestApp", appName);
    }
}
