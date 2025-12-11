package pe.interbank.ccd.issued.device.admin.client.cobis.model;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenCobisRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Authentication authentication;
    private Subsidiary subsidiary;
    private Branch branch;
    private Role role;


    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Authentication implements  Serializable{
        private static final long serialVersionUID = 1L;
        private String login;
        private String password;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Subsidiary implements Serializable{
        private static final long serialVersionUID = 1L;
        private Integer code;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Branch implements Serializable{
        private static final long serialVersionUID = 1L;
        private Integer code;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Role implements Serializable{
        private static final long serialVersionUID = 1L;
        private Integer code;
    }

}
