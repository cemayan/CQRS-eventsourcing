package com.ca.usercore.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role  implements GrantedAuthority {
    READ_PRIVILIGE, WRITE_PRIVILIGE;

    @Override
    public String getAuthority() {
        return name();
    }
}
