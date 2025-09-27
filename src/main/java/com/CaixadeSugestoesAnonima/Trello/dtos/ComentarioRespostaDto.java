package com.CaixadeSugestoesAnonima.Trello.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data

public class ComentarioRespostaDto {

    private Long id;
    private String texto;
    private LocalDate dataCriacao;

}
