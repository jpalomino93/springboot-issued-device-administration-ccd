package pe.interbank.ccd.issued.device.admin.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pe.interbank.ccd.issued.device.admin.dto.error.ErrorResponse;
import pe.interbank.ccd.issued.device.admin.exception.BusinessException;
import pe.interbank.ccd.issued.device.admin.exception.CobisClientException;
import pe.interbank.ccd.issued.device.admin.exception.TechnicalException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleBusiness(BusinessException ex) {
        log.warn("[BusinessException] {} - {}", ex.getCode(), ex.getDetail());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getCode(), ex.getDetail()));
    }

    @ExceptionHandler(CobisClientException.class)
    public ResponseEntity<?> handleCobis(CobisClientException ex) {
        log.error("[CobisClientException] Status={} Detail={}", ex.getStatus(), ex.getDetail());
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY) // 502 = problema backend
                .body(new ErrorResponse("COBIS_ERROR", ex.getDetail()));
    }

    @ExceptionHandler(TechnicalException.class)
    public ResponseEntity<?> handleTechnical(TechnicalException ex) {
        log.error("[TechnicalException] {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneral(Exception ex) {
        log.error("[UnexpectedException]", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("UNEXPECTED_ERROR", ex.getMessage()));
    }
}
