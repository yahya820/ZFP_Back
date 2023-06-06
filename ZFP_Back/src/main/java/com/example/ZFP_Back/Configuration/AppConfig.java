package com.example.ZFP_Back.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public OpenAPI
    usersMicroserviceOpenAPI(){
        return new OpenAPI()
                .info(new Info().title("Your Api")
                        .description("Your Description")
                        .version("1.0"));
    }

}
