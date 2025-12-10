package pe.interbank.ccd.issued.device.admin.exception;

import lombok.Getter;

@Getter
public class CobisClientException extends RuntimeException {

    private final int status;
    private final String detail;

    public CobisClientException(int status, String detail) {
        super(detail);
        this.status = status;
        this.detail = detail;
    }
}