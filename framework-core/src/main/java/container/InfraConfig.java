package container;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/*
- multiple configuration loading
- it is a best practice to separate infra and application configs
 */
@Configuration
@Import(AppConfig.class)
public class InfraConfig {

    @Bean
    public InfraSource infraSource() {
        return new InfraSource();
    }
}
