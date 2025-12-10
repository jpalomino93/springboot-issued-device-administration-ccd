package pe.interbank.ccd.issued.device.admin.dto.response;

public record TokenResponse(
        String token,
        String expiration
) {}