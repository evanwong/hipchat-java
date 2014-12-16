package io.evanwong.oss.hipchat.v2.oauth;

import io.evanwong.oss.hipchat.v2.commons.Scope;

import java.util.*;

public class Token {

    private String accessToken;
    private Integer expiresIn;
    private String groupName;
    private TokenType type;
    private Set<Scope> scopes;
    private Integer groupId;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public Set<Scope> getScopes() {
        return scopes;
    }

    public void setScope(String scope) {
        //api return a string with space-delimited
        this.scopes = new HashSet<>();
        for (String s : scope.split(" ")) {
            scopes.add(Scope.valueOf(s.toUpperCase()));
        }
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
