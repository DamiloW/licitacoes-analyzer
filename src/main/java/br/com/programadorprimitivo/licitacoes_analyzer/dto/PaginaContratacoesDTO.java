package br.com.programadorprimitivo.licitacoes_analyzer.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record PaginaContratacoesDTO(
        List<ContratacaoDTO> data,
        Integer totalRegistros,
        Integer totalPaginas,
        Integer numeroPagina) {
}
