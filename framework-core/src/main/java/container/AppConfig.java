package container;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
This is Java based configuration class
Responsibility,
 - business beans creation in the IOC container
 - inject dependencies
 */

@Configuration
public class AppConfig {

    @Bean
    public PaymentService paymentService(AccountRepository accountRepository) {
        return new PaymentService(accountRepository);
    }

//    @Bean
//    public PaymentService paymentService() {
//        return new PaymentService(accountRepository());
//    }

    @Bean
    public AccountRepository accountRepository() {
        return new AccountRepository();
    }
}
