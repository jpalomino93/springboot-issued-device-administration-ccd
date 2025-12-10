package pe.interbank.ccd.issued.device.admin.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "cobis")
public class CobisProperties {

    private String url;
    private String channel;
    private String terminal;
    private String apiKey;
    private Timeout timeout = new Timeout();

    @Getter
    @Setter
    public static class Timeout{
        private int connect;
        private int read;
    }
}
