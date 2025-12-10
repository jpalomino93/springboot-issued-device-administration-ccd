package pe.interbank.ccd.issued.device.admin.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pe.interbank.ccd.issued.device.admin.client.cobis.model.TokenCobisRequest;
import pe.interbank.ccd.issued.device.admin.dto.request.TokenRequest;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TokenMapper {

    @Mapping(source = "employeeIdentification", target = "authentication.username")
    @Mapping(source = "employeePassword", target = "authentication.password")
    @Mapping(source = "subsidiaryCode", target = "subsidiary.code")
    @Mapping(source = "branchCode", target = "branch.code")
    @Mapping(source = "roleCode", target = "role.code")
    TokenCobisRequest toModelCobis(TokenRequest request);
}
