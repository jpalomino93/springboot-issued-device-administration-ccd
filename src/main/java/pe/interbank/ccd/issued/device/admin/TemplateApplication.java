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
 @PostConstruct
 public void debugAzureAuth() {
  System.out.println("CLIENT_ID = " + System.getenv("AZURE_CLIENT_ID"));
  System.out.println("TENANT_ID = " + System.getenv("AZURE_TENANT_ID"));
  System.out.println("CLIENT_SECRET = " + System.getenv("AZURE_CLIENT_SECRET"));
 }
}