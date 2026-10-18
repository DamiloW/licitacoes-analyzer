package br.com.programadorprimitivo.licitacoes_analyzer.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("/api/status")
    public Map<String, String> verificarStatus() {
        return Map.of(
            "projeto", "Analisador de Licitações",
            "status", "online"
        );
    }
}
