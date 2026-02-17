package profiles;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {

    public static void main(String[] args) {

        // activating the profile via system/jvm property
        // different ways of activating (1) command line [-Dspring.profiles.active=dev,prod] (2) programmatically [this]
        System.setProperty("spring.profiles.active", "dev");

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // accessing the activated profile bean from the IOC container
        ProdBean prodBean = applicationContext.getBean(ProdBean.class);
        prodBean.run();
        prodBean.printProp();

//        DevBean devBean = applicationContext.getBean(DevBean.class);
//        devBean.run();
//        devBean.printProp();
    }
}
