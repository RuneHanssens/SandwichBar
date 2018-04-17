package be.ucll.sandwichbar.web.config;

import be.ucll.sandwichbar.domain.SandwichService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public SandwichService service(){
        return new SandwichService();
    }
}
