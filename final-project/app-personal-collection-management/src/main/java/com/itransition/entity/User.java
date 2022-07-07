package com.itransition.entity;

import com.itransition.entity.template.AbsEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Bekjon Bakhromov
 * @since  18.06.2022-3:23 PM
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "users")
@Where(clause = "deleted=false")
@SQLDelete(sql = "update users set deleted=true where id=?")
@Builder(setterPrefix = "set")
public class User extends AbsEntity implements UserDetails {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne(optional = false)
    private Role role;

    private boolean enabled = true;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getPermissionEnums().stream().map(permissionEnum -> new SimpleGrantedAuthority(permissionEnum.name())).collect(Collectors.toSet());
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
