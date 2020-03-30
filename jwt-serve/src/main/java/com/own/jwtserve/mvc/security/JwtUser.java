package com.own.jwtserve.mvc.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;

public class JwtUser extends User implements UserDetails {

    private  String id;
    private final LocalDateTime lastPasswordResetDate;

    private String name;
    private String userpic;
    private String utype;
    private String companyId;

    public JwtUser(String id , String username, String password, Collection<? extends GrantedAuthority> authorities, LocalDateTime lastPasswordResetDate) {
        super(username, password, authorities);
        this.id = id;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public JwtUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, LocalDateTime lastPasswordResetDate) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.lastPasswordResetDate = lastPasswordResetDate;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public LocalDateTime getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
