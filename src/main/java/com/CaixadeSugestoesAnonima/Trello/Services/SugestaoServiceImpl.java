package com.CaixadeSugestoesAnonima.Trello.Services;

import com.CaixadeSugestoesAnonima.Trello.dtos.ComentarioRequisicaoDto;
import com.CaixadeSugestoesAnonima.Trello.dtos.ComentarioRespostaDto;
import com.CaixadeSugestoesAnonima.Trello.dtos.SugestaoRequisicaoDto;
import com.CaixadeSugestoesAnonima.Trello.dtos.SugestaoRespostaDto;
import com.CaixadeSugestoesAnonima.Trello.entidades.ComentarioEntity;
import com.CaixadeSugestoesAnonima.Trello.entidades.SugestaoEntity;
import com.CaixadeSugestoesAnonima.Trello.mapeadores.ComentarioMapper;
import com.CaixadeSugestoesAnonima.Trello.mapeadores.SugestaoMapper;
import com.CaixadeSugestoesAnonima.Trello.repositorios.ComentarioRepository;
import com.CaixadeSugestoesAnonima.Trello.repositorios.SugestaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class SugestaoServiceImpl implements  SugestaoService{

    private final SugestaoRepository sugestaoRepository;

    private final ComentarioRepository comentarioRepository;

    private final SugestaoMapper sugestaoMapper;

    private final ComentarioMapper comentarioMapper;


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

    @Override
    public ComentarioRespostaDto adicionarComentario(Long sugestaoId, ComentarioRequisicaoDto dto) {

        SugestaoEntity sugestao = sugestaoRepository.findById(sugestaoId)

                .orElseThrow(() -> new RuntimeException("Sugestão não encontrada com ID: " + sugestaoId));


        ComentarioEntity comentario = comentarioMapper.toEntity(dto);

        comentario.setSugestao(sugestao);

        comentario.setDataEnvio(LocalDate.now());

        comentarioRepository.save(comentario);


        sugestao.setDataAtualizacao(LocalDate.now());

        sugestaoRepository.save(sugestao);

        return comentarioMapper.toDto(comentario);

    }
}

