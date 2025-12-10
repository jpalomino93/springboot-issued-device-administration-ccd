package pe.interbank.ccd.issued.device.admin.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotBlank(message = "La identificación del empleado es obligatoria")
    private String employeeIdentification;
    @NotBlank(message = "La contraseña del empleado es obligatoria")
    private String employeePassword;
    @NotNull(message = "El código de la sucursal es obligatorio")
    private Integer subsidiaryCode;
    @NotNull(message = "El código de la agencia es obligatorio")
    private Integer branchCode;
    @NotNull(message = "El código del rol es obligatorio")
    private Integer roleCode;

}
