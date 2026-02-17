package profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
//@PropertySource("classpath:application-${spring.profiles.active}.properties") // this is not much straight forward as
// a generic activation solution over mentioning property source in each profile activation config beans
@Import({DevConfig.class, ProdConfig.class})
public class AppConfig {

    // in raw spring framework, property placeholders are activated through this PropertySourcesPlaceholderConfigurer bean
    // meaning, this enables Spring to resolve ${...} placeholders in @Value annotations.
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
