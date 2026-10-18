package br.com.programadorprimitivo.licitacoes_analyzer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import br.com.programadorprimitivo.licitacoes_analyzer.client.PncpClient;
import br.com.programadorprimitivo.licitacoes_analyzer.dto.ModalidadeDTO;

@RestController
public class PncpController {

    private final PncpClient pncpClient;

    public PncpController (PncpClient pncpClient) {
        this.pncpClient = pncpClient;
    }

    @GetMapping("api/modalidades")
    public List<ModalidadeDTO> listarModalidades() {
        return pncpClient.buscarModalidades();
    }
}
