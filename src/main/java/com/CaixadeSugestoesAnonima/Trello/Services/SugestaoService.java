package com.CaixadeSugestoesAnonima.Trello.Services;

import com.CaixadeSugestoesAnonima.Trello.dtos.SugestaoRequisicaoDto;
import com.CaixadeSugestoesAnonima.Trello.dtos.SugestaoRespostaDto;

import java.util.List;

public interface SugestaoService {

    public SugestaoRespostaDto criarSugestao(SugestaoRequisicaoDto dto);

    List<SugestaoRespostaDto> listarSugestoes(String titulo);




}
