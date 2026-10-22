package br.com.programadorprimitivo.licitacoes_analyzer.service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import br.com.programadorprimitivo.licitacoes_analyzer.dto.ModalidadeDTO;

class ModalidadeServiceTest {

    @Test
    void deveFiltrarModalidadesPorNome() {

        // Preparação
        ModalidadeService service = new ModalidadeService();

        List<String> modalidades = List.of(
                "Pregão Eletrônico",
                "Concorrência",
                "Pregão Presencial",
                "Leilão");

        // Execução
        List<String> resultado = service.filtrarPorNome(modalidades, "Pregão");

        // Verificação
        assertEquals(2, resultado.size());
        assertEquals("Pregão Eletrônico", resultado.get(0));
        assertEquals("Pregão Presencial", resultado.get(1));
    }

    @Test
    void deveIgnorarMaiusculasEMinusculas() {

        ModalidadeService service = new ModalidadeService();

        List<ModalidadeDTO> modalidades = List.of(
                new ModalidadeDTO(1, "Pregão Eletrônico", "Compras"),
                new ModalidadeDTO(2, "Leilão", "Alienação"),
                new ModalidadeDTO(3, "Pregão Presencial", "Compras"),
                new ModalidadeDTO(4, "Leilão Virtual", "Alienação"));

        List<ModalidadeDTO> resultado = service.filtrarModalidades(modalidades, "pregão");

        assertEquals(2, resultado.size());
        assertEquals("Pregão Eletrônico", resultado.get(0).nome());
        assertEquals("Pregão Presencial", resultado.get(1).nome());
    }

    @Test
    void deveFiltrarObjetosPorNome() {

        ModalidadeService service = new ModalidadeService();

        List<ModalidadeDTO> modalidades = List.of(
                new ModalidadeDTO(1, "Pregão Eletrônico", "Compras"),
                new ModalidadeDTO(2, "Leilão", "Alienação"),
                new ModalidadeDTO(3, "Pregão Presencial", "Compras"));

        List<ModalidadeDTO> resultado = service.filtrarModalidades(modalidades, "Leilão");

        assertEquals(1, resultado.size());
        assertEquals("Leilão", resultado.get(0).nome());
        assertEquals(2, resultado.get(0).id());

    }
}
