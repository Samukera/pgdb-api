package com.example.pgdbapi.model;

import com.example.pgdbapi.dto.UsuarioDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;
    private String email;
    private String datanasc;

    @Column(name = "isAdmin")
    private boolean isAdmin = false;

    @Transient
    @JsonIgnore
    private String accessToken;

    @Transient
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Permissao> permissoes = new ArrayList<>();

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.permissoes;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return this.senha;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return this.email;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    public UsernamePasswordAuthenticationToken toAuth() {
        return new UsernamePasswordAuthenticationToken(email, senha);
    }

    public UsuarioDto toUsuarioDto() {
        return new UsuarioDto(id,nome,email,datanasc,isAdmin);
    }
}
