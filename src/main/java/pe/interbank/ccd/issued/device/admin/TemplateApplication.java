package pe.interbank.ccd.issued.device.admin;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import pe.interbank.ccd.issued.device.admin.config.CobisProperties;

@SpringBootApplication
@EnableFeignClients(basePackages = "pe.interbank.ccd.issued.device.admin")
@EnableConfigurationProperties(CobisProperties.class)
public class TemplateApplication {
 public static void main(String[] args){SpringApplication.run(TemplateApplication.class,args);}
}