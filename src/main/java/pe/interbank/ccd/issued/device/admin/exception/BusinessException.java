package pe.interbank.ccd.issued.device.admin.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final String code;
    private final String detail;

    public BusinessException(String code, String detail) {
        super(detail);
        this.code = code;
        this.detail = detail;
    }
}