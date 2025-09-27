package com.CaixadeSugestoesAnonima.Trello.dtos;



import java.time.LocalDate;
import java.util.List;


public record SugestaoRequisicaoDto(
        String titulo,
        String descricao,
        LocalDate dataEnvio,
        LocalDate dataAtualizacao,
        List<Long> comentariosIds
) {}