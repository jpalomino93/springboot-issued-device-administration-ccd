package pe.interbank.ccd.issued.device.admin.dto.error;

public record ErrorResponse(
        String code,
        String detail
) {}