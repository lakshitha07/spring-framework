package componentscanning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // accessing the service bean from the IOC container
        AccountService accountService = applicationContext.getBean(AccountServiceImpl.class);
        accountService.transfer();
    }
}
