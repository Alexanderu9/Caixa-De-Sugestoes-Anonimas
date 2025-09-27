package com.CaixadeSugestoesAnonima.Trello.Services;

import com.CaixadeSugestoesAnonima.Trello.dtos.SugestaoRequisicaoDto;
import com.CaixadeSugestoesAnonima.Trello.dtos.SugestaoRespostaDto;
import com.CaixadeSugestoesAnonima.Trello.entidades.SugestaoEntity;
import com.CaixadeSugestoesAnonima.Trello.mapeadores.SugestaoMapper;
import com.CaixadeSugestoesAnonima.Trello.repositorios.SugestaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<SugestaoRespostaDto> listarSugestoes(String titulo) {

        List<SugestaoEntity> sugestoes;

        if (titulo == null || titulo.isEmpty()) {

            sugestoes = sugestaoRepository.findAllByOrderByDataAtualizacaoDesc();

        } else {

            sugestoes = sugestaoRepository.findByTituloContainingIgnoreCaseOrderByDataAtualizacaoDesc(titulo);

        }

        return sugestoes.stream()
                .map(sugestaoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SugestaoRespostaDto buscarPorId(Long id) {

        SugestaoEntity entity = sugestaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sugestão não encontrada com ID: " + id));

        return sugestaoMapper.toDto(entity);
        
    }

}

