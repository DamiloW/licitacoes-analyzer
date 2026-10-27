package br.com.programadorprimitivo.licitacoes_analyzer.client;

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

    public PaginaContratacoesDTO buscarContratacoes(int pagina) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/contratacoes/publicacao")
                        .queryParam("dataInicial", "20261013")
                        .queryParam("dataFinal", "20261019")
                        .queryParam("codigoModalidadeContratacao", 6)
                        .queryParam("pagina", pagina)
                        .queryParam("tamanhoPagina", 10)
                        .build())
                .retrieve()
                .body(PaginaContratacoesDTO.class);
    }

}
