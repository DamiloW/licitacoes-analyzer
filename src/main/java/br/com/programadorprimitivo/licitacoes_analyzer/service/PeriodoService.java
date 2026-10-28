package br.com.programadorprimitivo.licitacoes_analyzer.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service 
public class PeriodoService {

    public void validarPeriodo(
            LocalDate dataInicial,
            LocalDate dataFinal) {

        if (dataInicial == null || dataFinal == null) {
            throw new IllegalArgumentException("As datas são obrigatórias");
        }

        if (dataInicial.isAfter(dataFinal)) {
            throw new IllegalArgumentException("A data inicial não pode ser posterior à data final");
        }
    }
}
