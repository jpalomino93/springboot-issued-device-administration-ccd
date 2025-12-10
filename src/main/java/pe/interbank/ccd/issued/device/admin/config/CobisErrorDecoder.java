package pe.interbank.ccd.issued.device.admin.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import pe.interbank.ccd.issued.device.admin.exception.BusinessException;
import pe.interbank.ccd.issued.device.admin.exception.CobisClientException;
import pe.interbank.ccd.issued.device.admin.exception.TechnicalException;

@Slf4j
public class CobisErrorDecoder implements ErrorDecoder {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Exception decode(String methodKey, Response response) {

        int status = response.status();
        log.error("[COBIS] Error in {} - HTTP {}", methodKey, status);

        String bodyText = null;

        try {
            if (response.body() != null) {
                bodyText = Util.toString(response.body().asReader());
            }
        } catch (Exception e) {
            log.warn("[COBIS] Error reading response body", e);
        }

        log.error("[COBIS] Raw Error Body: {}", bodyText);

        String detail = "COBIS returned an error";

        if (bodyText != null && !bodyText.isBlank()) {
            try {
                JsonNode json = mapper.readTree(bodyText);
                detail = json.path("message").asText(
                        json.path("detail").asText(bodyText)
                );
            } catch (Exception e) {
                detail = bodyText;
            }
        }

        // Clasificación
        if (status == 400) return new BusinessException("COBIS_BAD_REQUEST", detail);
        if (status == 401) return new BusinessException("COBIS_UNAUTHORIZED", detail);
        if (status == 403) return new BusinessException("COBIS_FORBIDDEN", detail);
        if (status == 404) return new BusinessException("COBIS_NOT_FOUND", detail);
        if (status == 429) return new BusinessException("COBIS_RATE_LIMIT", "Rate limit exceeded");
        if (status >= 400 && status < 500)
            return new BusinessException("COBIS_CLIENT_ERROR", detail);

        if (status >= 500)
            return new CobisClientException(status, "COBIS backend failure: " + detail);

        return new TechnicalException("COBIS_UNEXPECTED_STATUS",
                "Unexpected status from COBIS: " + status);
    }
}
