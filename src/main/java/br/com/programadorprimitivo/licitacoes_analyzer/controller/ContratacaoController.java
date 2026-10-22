package br.com.programadorprimitivo.licitacoes_analyzer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.programadorprimitivo.licitacoes_analyzer.client.ContratacaoClient;

@RestController
public class ContratacaoController {

    private final ContratacaoClient contratacaoClient;

    public ContratacaoController(ContratacaoClient contratacaoClient) {
        this.contratacaoClient = contratacaoClient;
    }

    @GetMapping("/api/contratacoes")
    public String listarContratacoes() {
        return contratacaoClient.buscarContratacoes();
    }

}
