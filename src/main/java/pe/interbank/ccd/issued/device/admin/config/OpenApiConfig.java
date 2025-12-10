package pe.interbank.ccd.issued.device.admin.config;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class OpenApiConfig {
 @Bean
 public OpenAPI IssuedDeviceAdminOpenAPI(){
     return new OpenAPI().info(new Info().title("Issued Device Administration CCD API").version("v1"));
 }
}