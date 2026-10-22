package br.com.programadorprimitivo.licitacoes_analyzer.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ContratacaoClient {

    private final RestClient restClient;

    public ContratacaoClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://pncp.gov.br/api/consulta")
                .build();
    }

    public String buscarContratacoes() {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/contratacoes/publicacao")
                        .queryParam("dataInicial", "20261013")
                        .queryParam("dataFinal", "20261019")
                        .queryParam("codigoModalidadeContratacao", 6)
                        .queryParam("pagina", 1)
                        .queryParam("tamanhoPagina", 10)
                        .build())
                .retrieve()
                .body(String.class);
    }

}
