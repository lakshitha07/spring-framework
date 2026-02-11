package container;

public class PaymentService {

    private AccountRepository accountRepository;

    public PaymentService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void transfer() {
        System.out.println("transaction done!");
    }
}
