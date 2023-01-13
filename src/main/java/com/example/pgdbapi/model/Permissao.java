package com.example.pgdbapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;


@Table(name = "permissao")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Permissao implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String permissao;

    @Override
    public String getAuthority() {
        return permissao;
    }
}
