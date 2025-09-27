package com.CaixadeSugestoesAnonima.Trello.mapeadores;


import com.CaixadeSugestoesAnonima.Trello.dtos.ComentarioRequisicaoDto;
import com.CaixadeSugestoesAnonima.Trello.dtos.ComentarioRespostaDto;
import com.CaixadeSugestoesAnonima.Trello.entidades.ComentarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ComentarioMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataEnvio", expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "sugestao", ignore = true)
    ComentarioEntity toEntity(ComentarioRequisicaoDto dto);

    ComentarioRespostaDto toDto(ComentarioEntity entity);
}