package com.CaixadeSugestoesAnonima.Trello.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder

public class SugestaoRespostaDto {

    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate dataEnvio;
    private LocalDate dataAtualizacao;
    private List<ComentarioRespostaDto> comentarios;

}