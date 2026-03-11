package testing;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// Unit testing with Mockito
@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTest {

    @Mock
    UserRepositoryImpl userRepositoryImpl;
    @InjectMocks
    UserServiceImpl userServiceImpl;

    // runs once before all tests
    // the reason for the static modifier is that by default each test class creates one instance per each test method.
    // so beforeAll and afterAll should run before any instance exists
    @BeforeAll
    static void initAll() {
        System.out.println("Runs once before all tests.");
    }

    // running before every test method
    @BeforeEach
    void setUp() {
        System.out.println("Running before every test.");
    }

    // methodName_condition_expectedResult -> standard naming convention
    @Test
    void getUserName_validId_returnUser() {
        when(userRepositoryImpl.findUserNameById(1)).thenReturn("John");
        String user = userServiceImpl.getUserName(1);
        assertEquals("John", user);
        //was the injected mock object's method was actually called
        verify(userRepositoryImpl).findUserNameById(1);
    }

    // running after every test method
    @AfterEach
    void cleanUp() {
        System.out.println("Running after every test.");
    }

    // runs once after all tests
    @AfterAll
    static void tearDownAll() {
        System.out.println("Runs once after all tests.");
    }
}
