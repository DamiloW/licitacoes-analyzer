package br.com.programadorprimitivo.licitacoes_analyzer.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import br.com.programadorprimitivo.licitacoes_analyzer.dto.PaginaContratacoesDTO;

@Component
public class ContratacaoClient {

    private final RestClient restClient;

    public ContratacaoClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://pncp.gov.br/api/consulta")
                .build();
    }

    public PaginaContratacoesDTO buscarContratacoes(
            int pagina,
            LocalDate dataInicial,
            LocalDate dataFinal) {

        DateTimeFormatter formato = DateTimeFormatter.BASIC_ISO_DATE;

        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/contratacoes/publicacao")
                        .queryParam("dataInicial", dataInicial.format(formato))
                        .queryParam("dataFinal", dataFinal.format(formato))
                        .queryParam("codigoModalidadeContratacao", 6)
                        .queryParam("pagina", pagina)
                        .queryParam("tamanhoPagina", 10)
                        .build())
                .retrieve()
                .body(PaginaContratacoesDTO.class);
    }

}
