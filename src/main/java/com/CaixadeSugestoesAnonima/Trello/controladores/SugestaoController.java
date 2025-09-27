package com.CaixadeSugestoesAnonima.Trello.controladores;

import com.CaixadeSugestoesAnonima.Trello.Services.SugestaoService;
import com.CaixadeSugestoesAnonima.Trello.dtos.SugestaoRequisicaoDto;
import com.CaixadeSugestoesAnonima.Trello.dtos.SugestaoRespostaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sugestoes")
@RequiredArgsConstructor

public class SugestaoController {

    private final SugestaoService sugestaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public SugestaoRespostaDto criarSugestao(@RequestBody SugestaoRequisicaoDto dto) {

        return sugestaoService.criarSugestao(dto);

    }
}