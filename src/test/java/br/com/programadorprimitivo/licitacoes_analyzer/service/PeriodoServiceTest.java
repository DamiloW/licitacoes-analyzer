package br.com.programadorprimitivo.licitacoes_analyzer.service;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class PeriodoServiceTest {

    @Test
    void deveRejeitarPeriodoIvertido() {

        PeriodoService service = new PeriodoService();

        LocalDate inicio = LocalDate.of(2026, 10, 27);
        LocalDate fim = LocalDate.of(2026, 10, 1);

        assertThrows(IllegalArgumentException.class, () -> service.validarPeriodo(inicio, fim));
    }
}
