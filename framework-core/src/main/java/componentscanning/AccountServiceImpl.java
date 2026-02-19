package componentscanning;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

// @Lazy annotation can be used to load the beans lazily to the IOC container
@Service
public class AccountServiceImpl implements AccountService {

    final private AccountRepository accountRepository;

    // 3 types of dependency injections in Spring [constructor, method and field]
    // constructor injection is preferred
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void transfer() {
        accountRepository.save();
        System.out.println("money transferred!");
    }

    // this is not a spring specific annotation but from Jakarta
    // after the IOC container create the service bean and inject dependencies, the method will be executed
    // theme methods can be invoked with the @Bean as well. But as arguments.
    // since these are not spring annotations, these are from JSR-250. But spring supports them
    @PostConstruct
    private void populateCache() {
        System.out.println("populating cache!");
    }

    // this method is executed sooner before the IOC container destroy the service bean
    // in case under a JVM related sudden termination, this will not be invoked properly
    // this cannot be used with prototype bean scope [Spring does not manage the full lifecycle of prototype beans,
    // it only creates them]
    @PreDestroy
    private void flushCache() {
        System.out.println("flushing cache!");
    }
}
