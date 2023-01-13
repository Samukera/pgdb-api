package com.example.pgdbapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "partido")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String sigla;

}
