package profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@Profile("dev") //class level profile activation. Possible at method level as well.
@PropertySource("classpath:application-dev.properties") // this is classpath property activation. Instead, properties
//can be loaded via (1) different directory [prefix -> "file:location"] (2) http file server. [prefix -> "http:location"]
public class DevConfig {

    final private Environment environment;

    public DevConfig(Environment environment) {
        this.environment = environment;
    }

    // external property values can be injected via property placeholders as well
    @Bean
    public DevBean devBean(@Value("${db.username") String dbUsername) {
        return new DevBean(environment, dbUsername);
    }
}
