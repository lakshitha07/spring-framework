package componentscanning;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("componentscanning")
// all the stereotype annotations [@Component, @Controller, @Service, @Repository]
// are activated through this annotation. It's applicable for the current directory and all the subdirectories
// it should be placed with configurations
public class AppConfig {
}
