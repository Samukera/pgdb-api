package com.example.pgdbapi.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "candidato")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String siglaUf;

    private String nome;

    private String cargo;

    private int numCand;

    @ManyToOne
    @JoinColumn(name="partido.id", nullable=false)
    private Partido partido;

}
