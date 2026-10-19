package br.com.programadorprimitivo.licitacoes_analyzer.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ModalidadeDTOTest {

    @Test
    void  deveArmazenarDadosDaModalidade() {
        
        ModalidadeDTO modalidade = new ModalidadeDTO(
            1,
            "Leilão - Eletrônico",
            "Alienação de bens"
        );

        assertEquals(1, modalidade.id());
        assertEquals("Leilão - Eletrônico", modalidade.nome());
        assertEquals("Alienação de bens", modalidade.descricao());
    }
}