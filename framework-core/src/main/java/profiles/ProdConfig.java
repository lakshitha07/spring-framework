package profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@Profile("prod")
@PropertySource("classpath:application-prod.properties") // this is classpath property activation. Instead, properties
//can be loaded via (1) different directory [prefix -> "file:location"] (2) http file server. [prefix -> "http:location"]
public class ProdConfig {

    private final Environment environment;

    public ProdConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public ProdBean prodBean(@Value("${db.username") String dbUsername) {
        return new ProdBean(environment, dbUsername);
    }
}
