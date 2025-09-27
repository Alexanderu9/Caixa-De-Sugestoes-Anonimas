package com.CaixadeSugestoesAnonima.Trello.repositorios;

import com.CaixadeSugestoesAnonima.Trello.entidades.ComentarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends  JpaRepository<ComentarioEntity, Long> {
}

