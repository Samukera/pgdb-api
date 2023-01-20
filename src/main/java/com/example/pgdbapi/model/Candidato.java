package com.example.pgdbapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "candidato")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String siglaUf;

    private String nome;

    private String cargo;

    private int numCand;

    @ManyToOne
    @JoinColumn(name="partido_id", nullable=false)
    private Partido partido;

    @OneToMany(mappedBy="candidato",cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Votos> votos = new ArrayList<>();

}
