package com.android.rest.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name="user",schema="afia")
public class User implements UserDetails {


   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Please provide a username")
    @Column(unique = true)
    private String username;

    @Size(min = 8, message = "Your password must have at least 8 characters")
    @NotBlank(message = "Please provide your password")
    private String password;

    @NotBlank(message = "Please provide your full name")
    private String name;
    
    @NotBlank(message = "Please provide your full name")
    private String lname;
    
    
    @NotBlank(message = "Please provide your full name")
    private String email;



    @NotBlank(message="Phone number is required")
    private String phone;
    
    @Column(name = "enabled")
    private int enabled;

    private String hospitalPicture;

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="user_role",
            joinColumns= {@JoinColumn(name="user_id")},
            inverseJoinColumns= {@JoinColumn(name="role_id")})
    private Set<Role> roles;




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> authorities = roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toSet());

        return authorities;
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
        return true;
    }
}

