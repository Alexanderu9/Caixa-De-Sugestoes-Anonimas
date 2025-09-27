package com.CaixadeSugestoesAnonima.Trello.Services;

import com.CaixadeSugestoesAnonima.Trello.dtos.SugestaoRequisicaoDto;
import com.CaixadeSugestoesAnonima.Trello.dtos.SugestaoRespostaDto;
import com.CaixadeSugestoesAnonima.Trello.entidades.SugestaoEntity;
import com.CaixadeSugestoesAnonima.Trello.mapeadores.SugestaoMapper;
import com.CaixadeSugestoesAnonima.Trello.repositorios.SugestaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class SugestaoServiceImpl implements  SugestaoService{

    private final SugestaoRepository sugestaoRepository;

    private final SugestaoMapper sugestaoMapper;


    @Override
    public SugestaoRespostaDto criarSugestao(SugestaoRequisicaoDto dto) {

        SugestaoEntity entity = sugestaoMapper.toEntity(dto);

        SugestaoEntity salva = sugestaoRepository.save(entity);

        return sugestaoMapper.toDto(salva);

    }
}
