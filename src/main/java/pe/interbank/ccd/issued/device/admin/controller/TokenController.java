package pe.interbank.ccd.issued.device.admin.controller;

import lombok.RequiredArgsConstructor;
import pe.interbank.ccd.issued.device.admin.dto.request.TokenRequest;
import pe.interbank.ccd.issued.device.admin.dto.response.TokenResponse;
import pe.interbank.ccd.issued.device.admin.service.TokenService;
import pe.interbank.ccd.issued.device.admin.service.TokenServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/issued-device-administration/v1/access-token-oauth2/create")
@RequiredArgsConstructor
public class TokenController {

    private final TokenService service;

    @PostMapping
    public ResponseEntity<TokenResponse> generateToken(
            @RequestHeader("x-financial-id") String financialId,
            @RequestHeader("serviceId") String serviceId,
            @RequestHeader("consumerId") String consumerId,
            @RequestHeader("messageId") String messageId,
            @RequestHeader("timeStamp") String timeStamp,
            @RequestHeader("netId") String netId,
            @RequestHeader("userId") String userId,
            @RequestHeader("supervisorId") String supervisorId,
            @RequestHeader("deviceId") String deviceId,
            @RequestHeader("traceId") String traceId,
            @RequestHeader("ipOrigen") String ipOrigen,
            @RequestHeader("funcionalidadId") String funcionalidadId,
            @Valid @RequestBody TokenRequest request) {

        TokenResponse response = service.generateToken(
                financialId,
                serviceId,
                consumerId,
                messageId,
                timeStamp,
                netId,
                userId,
                supervisorId,
                deviceId,
                traceId,
                ipOrigen,
                funcionalidadId,
                request
        );
        return ResponseEntity.ok(response);
    }

}