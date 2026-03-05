package aspects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {

    public static void main(String[] args) {

        ApplicationContext applicationContext  = new AnnotationConfigApplicationContext(AppConfig.class);
        Invoker invoker = applicationContext.getBean(Invoker.class);
        invoker.run();
    }
}
