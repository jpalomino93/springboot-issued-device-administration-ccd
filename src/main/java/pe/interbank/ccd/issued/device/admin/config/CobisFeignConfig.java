package pe.interbank.ccd.issued.device.admin.config;


import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class CobisFeignConfig {

    private final CobisProperties cobisProperties;

    // Logging de Feign (FULL = imprime headers, body, status y tiempo)
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    // Configuración de timeouts
    @Bean
    public Request.Options feignRequestOptions() {
        return new Request.Options(
                cobisProperties.getTimeout().getConnect(), // connect timeout (ms)
                cobisProperties.getTimeout().getRead()// read timeout (ms)
        );
    }

    // Manejo profesional de errores COBIS
    @Bean
    public ErrorDecoder errorDecoder() {
        return new CobisErrorDecoder();
    }

    // Headers que son SIEMPRE fijos en cualquier llamada COBIS
    @Bean
    public RequestInterceptor cobisHeaders() {
        return template -> {
            template.header("x-channel",cobisProperties.getChannel());
            template.header("x-api-key", cobisProperties.getApiKey());
            template.header("Content-Type", "application/json");
            template.header("Accept"," application/json");
        };
    }


}
