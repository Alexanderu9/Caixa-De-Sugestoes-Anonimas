package com.CaixadeSugestoesAnonima.Trello.repositorios;


import com.CaixadeSugestoesAnonima.Trello.entidades.SugestaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SugestaoRepository extends  JpaRepository<SugestaoEntity, Long> {

    List<SugestaoEntity> findAllByOrderByDataAtualizacaoDesc();

    @Query("SELECT s FROM SugestaoEntity s " +
            "WHERE (:titulo IS NULL OR LOWER(s.titulo) LIKE LOWER(CONCAT('%', :titulo, '%'))) " +
            "ORDER BY s.dataAtualizacao DESC")

    List<SugestaoEntity> findByTituloContainingIgnoreCaseOrderByDataAtualizacaoDesc(@Param("titulo") String titulo);

}

