package container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring-context dependency is the minimum requirement to access core spring features,
 * spring-core
 * spring-beans
 * spring-expression
 * spring-aop
 * --------------------------------------------
 * BeanFactory is the core IoC container responsible for bean creation, dependency injection, and lifecycle management.
 * ApplicationContext extends BeanFactory and provides enterprise features such as event publishing, internationalization,
 * resource loading, environment abstraction, and automatic post-processor registration.
 * So, ApplicationContext is the central interface of the Spring IoC container.
 * ----------------------------------------------
 * BeanFactory
 *  ├── ListableBeanFactory
 *  ├── HierarchicalBeanFactory
 *  ├── AutowireCapableBeanFactory
 *  └── ConfigurableBeanFactory
 *
 * ApplicationContext
 *  ├── ConfigurableApplicationContext
 *  │     └── AbstractApplicationContext
 *  │            └── AbstractRefreshableApplicationContext
 *  │                   └── AbstractRefreshableConfigApplicationContext
 *  │                          ├── AnnotationConfigApplicationContext
 *  │                          ├── ClassPathXmlApplicationContext
 *  │                          └── GenericApplicationContext
 *  │
 *  └── WebApplicationContext
 *         └── ConfigurableWebApplicationContext
 *                └── AnnotationConfigServletWebServerApplicationContext
 * -----------------------------------------------
 * ApplicationContext can be created in any environment including standalone app, web app or unit test
 */
public class AppRunner {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(InfraConfig.class);
        // accessing the business bean from the IOC container
        InfraSource infraSource = applicationContext.getBean(InfraSource.class);
        infraSource.load();
        PaymentService paymentService = applicationContext.getBean(PaymentService.class);
        paymentService.transfer();
    }
}
