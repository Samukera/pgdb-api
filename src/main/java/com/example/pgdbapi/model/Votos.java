package com.example.pgdbapi.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "votos")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Votos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int qtd_votos;

    private Date data;

    @ManyToOne
    @JoinColumn(name="boletim.id", nullable=false)
    private Boletim boletim;

    @ManyToOne
    @JoinColumn(name="cadidato.id", nullable = false)
    private Candidato candidato;

}
