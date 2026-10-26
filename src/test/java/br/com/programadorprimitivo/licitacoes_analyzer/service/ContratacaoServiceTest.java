package br.com.programadorprimitivo.licitacoes_analyzer.service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import br.com.programadorprimitivo.licitacoes_analyzer.dto.ContratacaoDTO;

public class ContratacaoServiceTest {

    @Test
    void deveFiltrarContratacoesPorObjeto() {

        ContratacaoService service = new ContratacaoService();

        List<ContratacaoDTO> contratacao = List.of(
                new ContratacaoDTO("001", "Aquisição de computadores", null),
                new ContratacaoDTO("002", "Contratação de software ERP", null),
                new ContratacaoDTO("003", "Serviços de limpeza", null));

        List<ContratacaoDTO> resultado = service.filtrarPorObjeto(contratacao, "software");

        assertEquals(1, resultado.size());
        assertEquals("002", resultado.get(0).numeroControlePNCP());
        assertEquals("Contratação de software ERP", resultado.get(0).objetoCompra());
    }

    @Test
    void deveIgnorarContratacoesSemDescricao() {

        ContratacaoService service = new ContratacaoService();

        List<ContratacaoDTO> contratacoes = List.of(
                new ContratacaoDTO("001", null, null),
                new ContratacaoDTO("002", "Software ERP", null));

        List<ContratacaoDTO> resultado = service.filtrarPorObjeto(contratacoes, "software");

        assertEquals(1, resultado.size());
        assertEquals("002", resultado.get(0).numeroControlePNCP());
    }
}
