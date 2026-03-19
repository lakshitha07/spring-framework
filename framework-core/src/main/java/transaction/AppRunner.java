package transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        AccountService accountService = applicationContext.getBean(AccountService.class);
        System.out.println("before transaction:");
        accountService.checkBalance();
        accountService.transfer(1, 2, 100);
        System.out.println("after transaction:");
        accountService.checkBalance();
    }
}
