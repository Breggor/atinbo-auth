package com.atinbo.auth.consts;

/**
 * @author guojd 2015-12-16
 */
public enum GrantType {

    AUTHORIZATION_CODE("authorization_code"),
    PASSWORD("password"),
    REFRESH_TOKEN("refresh_token"),
    CLIENT_CREDENTIALS("client_credentials");

    private String grantType;

    private GrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getValue() {
        return grantType;
    }
}
