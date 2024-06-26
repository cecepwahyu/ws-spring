package id.co.bpddiy.testservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("BPD DIY")
                        .description("Service Spring Boot BPD DIY")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("BPD DIY")
                                .url("https://bpddiy.co.id/")
                                .email("any@email.com")));
    }
}
