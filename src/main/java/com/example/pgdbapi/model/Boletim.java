package com.example.pgdbapi.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "boletim")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Boletim implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int zona;

    private int secao;

    private String local_votacao;

    private int aptos;

    private int faltosos;

    private int comparecimento;

    private boolean valido;

    @ManyToOne
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuario;

    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
    @JoinColumn(name = "boletim_id")
    private List<Votos> votos = new ArrayList<>();

}
