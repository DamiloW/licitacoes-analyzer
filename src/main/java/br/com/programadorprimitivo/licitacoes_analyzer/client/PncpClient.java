package br.com.programadorprimitivo.licitacoes_analyzer.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

import br.com.programadorprimitivo.licitacoes_analyzer.dto.ModalidadeDTO;

@Component
public class PncpClient {

    private final RestClient restClient;
    
    public PncpClient(RestClient.Builder builder) {
        this.restClient = builder
            .baseUrl("http://pncp.gov.br/api/pncp")
            .build();
    }

    public List<ModalidadeDTO> buscarModalidades () {
        return restClient.get()
        .uri("/v1/modalidades")
        .retrieve()
        .body(new ParameterizedTypeReference<List<ModalidadeDTO>>() {});
    }
}