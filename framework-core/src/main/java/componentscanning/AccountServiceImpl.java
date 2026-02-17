package componentscanning;

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
}
