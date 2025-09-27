package com.CaixadeSugestoesAnonima.Trello.repositorios;


import com.CaixadeSugestoesAnonima.Trello.entidades.SugestaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SugestaoRepository extends  JpaRepository<SugestaoEntity, Long> {
}

