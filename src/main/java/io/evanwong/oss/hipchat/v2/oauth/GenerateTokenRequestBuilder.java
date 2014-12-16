package io.evanwong.oss.hipchat.v2.oauth;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import io.evanwong.oss.hipchat.v2.commons.Scope;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class GenerateTokenRequestBuilder extends RequestBuilder<GenerateTokenRequest> {

    private final GrantType grantType;
    private final GenerateTokenRequest generateTokenRequest;

    public GenerateTokenRequestBuilder(GrantType grantType, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.grantType = grantType;
        generateTokenRequest = new GenerateTokenRequest(grantType, accessToken, httpClient, executorService);
    }

    public GenerateTokenRequestBuilder setUsername(String username) {
        generateTokenRequest.setUsername(username);
        return this;
    }

    public GenerateTokenRequestBuilder setCode(String code) {
        generateTokenRequest.setCode(code);
        return this;
    }

    public GenerateTokenRequestBuilder setRedirectUri(String redirectUri) {
        generateTokenRequest.setRedirectUri(redirectUri);
        return this;
    }

    public GenerateTokenRequestBuilder addScope(Scope scope) {
        generateTokenRequest.addScope(scope);
        return this;
    }

    public GenerateTokenRequestBuilder setPassword(String password) {
        generateTokenRequest.setPassword(password);
        return this;
    }

    public GenerateTokenRequestBuilder setRefreshToken(String refreshToken) {
        generateTokenRequest.setRefreshToken(refreshToken);
        return this;
    }

    @Override
    public GenerateTokenRequest build() {
        return generateTokenRequest;
    }
}
