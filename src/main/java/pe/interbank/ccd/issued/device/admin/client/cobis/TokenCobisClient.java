package pe.interbank.ccd.issued.device.admin.client.cobis;


import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import pe.interbank.ccd.issued.device.admin.client.cobis.model.TokenCobisRequest;
import pe.interbank.ccd.issued.device.admin.config.CobisFeignConfig;

@FeignClient(
        name = "system-authentication-role",
        url = "${cobis.url}",
        configuration = CobisFeignConfig.class
)
public interface TokenCobisClient {

    @PostMapping("/system-auth/authentication-role/")
    Response generateToken(
            @RequestHeader("x-financial-id") String financialId,
            @RequestHeader("x-end-user-terminal") String terminal,
            @RequestHeader("x-request-id") String requestId,
            @RequestHeader("x-end-user-login") String endUserLogin,
            @RequestHeader("x-end-user-request-date-time") String endUserRequestDateTime,
            //@RequestHeader("x-channel") String channel,
            //@RequestHeader("x-api-key") String apiKey,
            @RequestBody TokenCobisRequest request);
}
