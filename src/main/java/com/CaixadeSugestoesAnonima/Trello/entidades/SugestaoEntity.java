package com.CaixadeSugestoesAnonima.Trello.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "sugestoes")

public class SugestaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDate dataEnvio;

    @Column(nullable = false)
    private LocalDate dataAtualizacao;

    @OneToMany(mappedBy = "sugestao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComentarioEntity> comentarios;

}
