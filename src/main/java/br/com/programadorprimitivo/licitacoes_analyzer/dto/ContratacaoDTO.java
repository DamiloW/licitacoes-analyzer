package br.com.programadorprimitivo.licitacoes_analyzer.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record ContratacaoDTO(
        String numeroControlePNCP,
        String objetoCompra,
        BigDecimal valorTotalEstimado) {
}
