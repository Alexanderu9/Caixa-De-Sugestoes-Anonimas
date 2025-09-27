package com.CaixadeSugestoesAnonima.Trello.mapeadores;


import com.CaixadeSugestoesAnonima.Trello.dtos.SugestaoRequisicaoDto;
import com.CaixadeSugestoesAnonima.Trello.dtos.SugestaoRespostaDto;
import com.CaixadeSugestoesAnonima.Trello.entidades.SugestaoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ComentarioMapper.class})
public interface SugestaoMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "comentarios", ignore = true)

    SugestaoEntity toEntity(SugestaoRequisicaoDto dto);


    SugestaoRespostaDto toDto(SugestaoEntity entity);
}