package com.CaixadeSugestoesAnonima.Trello.Services;

import com.CaixadeSugestoesAnonima.Trello.dtos.ComentarioRequisicaoDto;
import com.CaixadeSugestoesAnonima.Trello.dtos.ComentarioRespostaDto;
import com.CaixadeSugestoesAnonima.Trello.dtos.SugestaoRequisicaoDto;
import com.CaixadeSugestoesAnonima.Trello.dtos.SugestaoRespostaDto;

import java.util.List;

public interface SugestaoService {

    public SugestaoRespostaDto criarSugestao(SugestaoRequisicaoDto dto);

    List<SugestaoRespostaDto> listarSugestoes(String titulo);

    SugestaoRespostaDto buscarPorId(Long id);

    ComentarioRespostaDto adicionarComentario(Long sugestaoId, ComentarioRequisicaoDto dto);




}
