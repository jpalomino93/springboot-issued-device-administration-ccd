package pe.interbank.ccd.issued.device.admin.exception;

import lombok.Getter;

/*
    * Custom exception class for technical errors.
    * Timeout , NullPointer,Error con AWS API GW.Error al mapear JSON
 */
@Getter
public class TechnicalException extends RuntimeException {

    private final String code;

    public TechnicalException(String code, String message) {
        super(message);
        this.code = code;
    }
}