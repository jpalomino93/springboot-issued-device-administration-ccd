package pe.interbank.ccd.issued.device.admin.service;

import pe.interbank.ccd.issued.device.admin.dto.request.TokenRequest;
import pe.interbank.ccd.issued.device.admin.dto.response.TokenResponse;

public interface TokenService {
    String authenticationRoleCobis();
    TokenResponse generateToken(
            String financialId,
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
            TokenRequest request);
}
