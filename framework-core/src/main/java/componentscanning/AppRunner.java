package componentscanning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {

    public static void main(String[] args) {

        // spring application context needs to be closed properly before exiting the application
        // if not closed properly, sooner the main method done, JVM kill it without properly closing
        // doing so, the IOC container fails to properly terminates the beans due respect to their life cycles
        // there are two ways to overcome this. (1) manually close the application context (2) registerShutdownHook
        // with approach 2, jvm calls the hook if it terminates under healthy conditions and the spring will then
        // close the application context using close() properly
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // accessing the service bean from the IOC container
        AccountService accountService = applicationContext.getBean(AccountServiceImpl.class);
        accountService.transfer();

        //manually closing
        // applicationContext.close();

        // registering the shutdown hook in the jvm
        applicationContext.registerShutdownHook();
    }
}
