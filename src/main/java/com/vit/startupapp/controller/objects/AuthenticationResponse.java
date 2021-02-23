package com.vit.startupapp.controller.objects;

import java.io.Serializable;
import java.util.ArrayList;

public class AuthenticationResponse implements Serializable {

    private final String jwt;
    private final ArrayList<String> authorities;
    private final String id;

    public AuthenticationResponse(String jwt, ArrayList<String> authorities, String id) {
        this.jwt = jwt;
        this.authorities = authorities;
        this.id = id;
    }

    public String getJwt() {
        return jwt;
    }

    public ArrayList<String> getAuthorities() {
        return authorities;
    }

    public String getId() {
        return id;
    }
}
