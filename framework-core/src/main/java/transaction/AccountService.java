package transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.ls.LSOutput;

@Service
public class AccountService {

    final private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void checkBalance() {
        accountRepository.getAll().forEach(System.out::println);
    }

    // default behavior : Propagation.REQUIRED
    @Transactional
    public void transfer(int fromId, int toId, int amount) {
        // if something goes wrong, a RuntimeException will be thrown.
        // by default, spring only rollback RuntimeExceptions only
        // in case need to wrap it, that exception needs to be a subclass of it
        // if needed, rollback can be configured as required
        accountRepository.debit(fromId, amount);
        accountRepository.credit(toId, amount);
    }

    // demonstrates internal call problem due to proxy
    @Transactional
    public void outerMethod() {
        innerMethod(); // ❌ NO transaction applied here!
    }

    @Transactional
    public void innerMethod() {
        System.out.println("inner method transaction?");
    }
}
