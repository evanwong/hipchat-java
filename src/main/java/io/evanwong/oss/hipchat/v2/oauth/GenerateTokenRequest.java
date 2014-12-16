package io.evanwong.oss.hipchat.v2.oauth;

import io.evanwong.oss.hipchat.v2.commons.PostRequest;
import io.evanwong.oss.hipchat.v2.commons.Scope;
import org.apache.http.client.HttpClient;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

public class GenerateTokenRequest extends PostRequest<Token> {

    private String username;
    private final GrantType grantType;
    private String code;
    private String redirectUri;
    private final Set<Scope> scopes;
    private String password;
    private String refreshToken;

    GenerateTokenRequest(GrantType grantType, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.grantType = grantType;
        this.scopes = new HashSet<>();
    }

    public void setUsername(String username) {
        if (grantType != GrantType.PASSWORD && grantType != GrantType.CLIENT_CREDENTIALS) {
            throw new RuntimeException("Grant type " + grantType.getValue() + "  is not supported for username.");
        }
        this.username = username;
    }

    public void setCode(String code) {
        if (grantType != GrantType.AUTHORIZATION_CODE) {
            throw new RuntimeException("Grant type " + grantType.getValue() + "  is not supported for code.");
        }
        this.code = code;
    }

    public void setRedirectUri(String redirectUri) {
        if (grantType != GrantType.AUTHORIZATION_CODE) {
            throw new RuntimeException("Grant type " + grantType.getValue() + "  is not supported for redirectUri.");
        }
        this.redirectUri = redirectUri;
    }

    public void addScope(Scope scope) {
        this.scopes.add(scope);
    }

    public void setPassword(String password) {
        if (grantType != GrantType.PASSWORD) {
            throw new RuntimeException("Grant type " + grantType.getValue() + "  is not supported for password.");
        }
        this.password = password;
    }

    public void setRefreshToken(String refreshToken) {
        if (grantType != GrantType.REFRESH_TOKEN) {
            throw new RuntimeException("Grant type " + grantType.getValue() + "  is not supported for refresh token.");
        }
        this.refreshToken = refreshToken;
    }

    public String getUsername() {
        return username;
    }

    public GrantType getGrantType() {
        return grantType;
    }

    public String getCode() {
        return code;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public Set<Scope> getScopes() {
        return scopes;
    }

    public String getPassword() {
        return password;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    @Override
    protected Map<String, Object> toQueryMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("grant_type", grantType.getValue());
        if (username != null) {
            params.put("username", username);
        }
        if (code != null) {
            params.put("code", code);
        }
        if (redirectUri != null) {
            params.put("redirectUri", redirectUri);
        }
        if (scopes.size() > 0) {
            params.put("scope", scopes.stream().map( s -> s.getValue() ).collect(Collectors.joining(" ")));
        }
        if (password != null) {
            params.put("password", password);
        }
        if (refreshToken != null) {
            params.put("refreshToken", refreshToken);
        }
        return params;
    }

    @Override
    protected String getPath() {
        return "/oauth/token";
    }
}
