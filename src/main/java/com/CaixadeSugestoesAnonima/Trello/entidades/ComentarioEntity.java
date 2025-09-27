package com.CaixadeSugestoesAnonima.Trello.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "comentarios")

public class ComentarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sugestao_id", nullable = false)
    private SugestaoEntity sugestao;

    @Column(nullable = false)
    private String texto;

    @Column(nullable = false)
    private LocalDate dataEnvio;


}
