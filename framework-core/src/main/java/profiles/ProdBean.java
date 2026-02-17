package profiles;

import org.springframework.core.env.Environment;

public class ProdBean {

    final private Environment environment;
    final private String dbUsername;

    public ProdBean(Environment environment, String dbUsername) {
        this.environment = environment;
        this.dbUsername = dbUsername;
    }

    public void run() {
        System.out.println("prod bean active!");
    }

    // this is raw level of accessing properties in spring framework via Environment interface
    // accessing via this interface having priority order, (1) jvm properties (2) OS variables (3) application properties
    public void printProp() {
        System.out.println("DB URL: " + environment.getProperty("db.url"));
        System.out.println("DB USERNAME: " + dbUsername);
    }
}
