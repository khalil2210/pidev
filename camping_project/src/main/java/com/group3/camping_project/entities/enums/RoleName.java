package com.group3.camping_project.entities.enums;


import org.springframework.security.core.GrantedAuthority;



public enum RoleName implements GrantedAuthority {
    ADMIN,
    SUPERADMIN;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }

    @Override
    public String toString() {
        return "RoleName{}";
    }
}