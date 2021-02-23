package com.vit.startupapp.controller.objects;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
    private final String clientAuthority;

    public Authority(String clientAuthority) {
        this.clientAuthority = clientAuthority;
    }

    @Override
    public String getAuthority() {

        return clientAuthority;
    }
}
