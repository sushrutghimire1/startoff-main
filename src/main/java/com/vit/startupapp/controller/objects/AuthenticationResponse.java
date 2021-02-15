package com.vit.startupapp.controller.objects;

import java.io.Serializable;
import java.util.ArrayList;

public class AuthenticationResponse implements Serializable {

    private final String jwt;
    private final ArrayList<String> authorities;
    private final String username;

    public AuthenticationResponse(String jwt, ArrayList<String> authorities, String username) {
        this.jwt = jwt;
        this.authorities = authorities;
        this.username = username;
    }

    public String getJwt() {
        return jwt;
    }

    public ArrayList<String> getAuthorities() {
        return authorities;
    }

    public String getUsername() {
        return username;
    }
}
