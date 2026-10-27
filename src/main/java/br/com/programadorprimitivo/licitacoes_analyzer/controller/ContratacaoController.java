package br.com.programadorprimitivo.licitacoes_analyzer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.programadorprimitivo.licitacoes_analyzer.client.ContratacaoClient;
import br.com.programadorprimitivo.licitacoes_analyzer.dto.ContratacaoDTO;
import br.com.programadorprimitivo.licitacoes_analyzer.dto.PaginaContratacoesDTO;
import br.com.programadorprimitivo.licitacoes_analyzer.service.ContratacaoService;

@RestController
public class ContratacaoController {

    private final ContratacaoClient contratacaoClient;
    private final ContratacaoService contratacaoService;

    public ContratacaoController(
            ContratacaoClient contratacaoClient,
            ContratacaoService contratacaoService) {

        this.contratacaoClient = contratacaoClient;
        this.contratacaoService = contratacaoService;
    }

    @GetMapping("/api/contratacoes")
    public PaginaContratacoesDTO listaContratacoes(
            @RequestParam(defaultValue = "1") int pagina) {

        return contratacaoClient.buscarContratacoes(pagina);
    }

    @GetMapping("/api/contratacoes/buscar")
    public List<ContratacaoDTO> buscarPorObjeto(
            @RequestParam String palavra,
            @RequestParam(defaultValue = "1") int pagina) {

        PaginaContratacoesDTO resultado = contratacaoClient.buscarContratacoes(pagina);

        return contratacaoService.filtrarPorObjeto(resultado.data(), palavra);
    }
}
