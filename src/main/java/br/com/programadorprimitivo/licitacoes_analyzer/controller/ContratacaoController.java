package br.com.programadorprimitivo.licitacoes_analyzer.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.programadorprimitivo.licitacoes_analyzer.client.ContratacaoClient;
import br.com.programadorprimitivo.licitacoes_analyzer.dto.ContratacaoDTO;
import br.com.programadorprimitivo.licitacoes_analyzer.dto.PaginaContratacoesDTO;
import br.com.programadorprimitivo.licitacoes_analyzer.service.ContratacaoService;
import br.com.programadorprimitivo.licitacoes_analyzer.service.PeriodoService;

@RestController
public class ContratacaoController {

    private final ContratacaoClient contratacaoClient;
    private final ContratacaoService contratacaoService;
    private final PeriodoService periodoService;

    public ContratacaoController(
            ContratacaoClient contratacaoClient,
            ContratacaoService contratacaoService,
            PeriodoService periodoService) {

        this.contratacaoClient = contratacaoClient;
        this.contratacaoService = contratacaoService;
        this.periodoService = periodoService;
    }

    @GetMapping("/api/contratacoes")
    public PaginaContratacoesDTO listaContratacoes(
            @RequestParam(defaultValue = "1") int pagina,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {

        periodoService.validarPeriodo(dataInicial, dataFinal);

        return contratacaoClient.buscarContratacoes(pagina, dataInicial, dataFinal);
    }

    @GetMapping("/api/contratacoes/buscar")
    public List<ContratacaoDTO> buscarPorObjeto(
            @RequestParam String palavra,
            @RequestParam(defaultValue = "1") int pagina,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {

        periodoService.validarPeriodo(dataInicial, dataFinal);

        PaginaContratacoesDTO resultado = contratacaoClient.buscarContratacoes(pagina, dataInicial, dataFinal);

        return contratacaoService.filtrarPorObjeto(resultado.data(), palavra);
    }
}
