package br.com.programadorprimitivo.licitacoes_analyzer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.programadorprimitivo.licitacoes_analyzer.client.PncpClient;
import br.com.programadorprimitivo.licitacoes_analyzer.dto.ModalidadeDTO;
import br.com.programadorprimitivo.licitacoes_analyzer.service.ModalidadeService;

@RestController
public class PncpController {

    private final PncpClient pncpClient;
    private final ModalidadeService modalidadeService;

    public PncpController(
            PncpClient pncpClient,
            ModalidadeService modalidadeService) {

        this.pncpClient = pncpClient;
        this.modalidadeService = modalidadeService;
    }

    @GetMapping("api/modalidades")
    public List<ModalidadeDTO> listarModalidades() {
        return pncpClient.buscarModalidades();
    }

    @GetMapping("/api/modalidades/buscar")
    public List<ModalidadeDTO> buscarPorNome(
            @RequestParam String nome) {

        List<ModalidadeDTO> modalidades = pncpClient.buscarModalidades();

        return modalidadeService.filtrarModalidades(modalidades, nome);
    }
}
