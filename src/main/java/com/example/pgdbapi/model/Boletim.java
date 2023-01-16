package com.example.pgdbapi.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "boletim")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Boletim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int zona;

    private int secao;

    private String local_votacao;

    private int aptos;

    private int faltosos;

    private int comparecimento;

    @ManyToOne
    @JoinColumn(name="usuario.id", nullable=false)
    private Usuario usuario;

    @OneToMany
    private List<Votos> votos;

    private boolean valido;
}
