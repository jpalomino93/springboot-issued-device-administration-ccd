package pe.interbank.ccd.issued.device.admin.service;


import feign.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import pe.interbank.ccd.issued.device.admin.client.cobis.TokenCobisClient;
import pe.interbank.ccd.issued.device.admin.client.cobis.model.TokenCobisRequest;
import pe.interbank.ccd.issued.device.admin.dto.request.TokenRequest;
import pe.interbank.ccd.issued.device.admin.dto.response.TokenResponse;
import pe.interbank.ccd.issued.device.admin.exception.BusinessException;
import pe.interbank.ccd.issued.device.admin.exception.TechnicalException;
import pe.interbank.ccd.issued.device.admin.mapper.TokenMapper;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenServiceImpl implements TokenService {

    private final TokenCobisClient cobisClient;
    private final TokenMapper mapper;


    @Override
    public String authenticationRoleCobis() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public TokenResponse generateToken(String financialId,
                                       String serviceId,
                                       String consumerId,
                                       String messageId,
                                       String timeStamp,
                                       String netId,
                                       String userId,
                                       String supervisorId,
                                       String deviceId,
                                       String traceId,
                                       String ipOrigen,
                                       String funcionalidadId,
                                       TokenRequest request) {
        TokenCobisRequest tokenCobisRequest = mapper.toModelCobis(request);

        Response response;
        try {

            response = cobisClient.generateToken(
                    financialId,
                    deviceId,
                    messageId,
                    userId,
                    timeStamp,
                    tokenCobisRequest);

        } catch (Exception ex) {
            throw new TechnicalException("COBIS_REQUEST_ERROR",
                    "Error invoking COBIS: " + ex.getMessage());
        }

        log.info("COBIS response status: {}", response.status());

        if(response.status() == 200){
            String token = readHeader(response, "x-amzn-Remapped-Authorization");
            String expiration = readHeader(response, "Date");
            return new TokenResponse(token, expiration);
        }

        // 4. Cualquier otro status → error técnico inesperado (NO COBIS)
        throw new TechnicalException(
                "UNEXPECTED_COBIS_STATUS",
                "COBIS returned: " + response.status()
        );
    }

    private String readHeader(Response response, String key) {
        return response.headers()
                .getOrDefault(key, Set.of(""))
                .stream()
                .findFirst()
                .orElse("");
    }

}
