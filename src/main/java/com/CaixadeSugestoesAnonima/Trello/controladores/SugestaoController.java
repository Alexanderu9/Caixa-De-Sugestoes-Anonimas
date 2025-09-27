package com.CaixadeSugestoesAnonima.Trello.controladores;

import com.CaixadeSugestoesAnonima.Trello.Services.SugestaoService;
import com.CaixadeSugestoesAnonima.Trello.dtos.SugestaoRequisicaoDto;
import com.CaixadeSugestoesAnonima.Trello.dtos.SugestaoRespostaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<SugestaoRespostaDto> listarSugestoes(@RequestParam(value = "titulo", required = false) String titulo) {

        return sugestaoService.listarSugestoes(titulo);

    }

    @GetMapping("/{id}")
    public SugestaoRespostaDto buscarPorId(@PathVariable Long id) {

        return sugestaoService.buscarPorId(id);

    }
}