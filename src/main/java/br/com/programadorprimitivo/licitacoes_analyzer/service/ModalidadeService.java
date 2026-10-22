package br.com.programadorprimitivo.licitacoes_analyzer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

import br.com.programadorprimitivo.licitacoes_analyzer.dto.ModalidadeDTO;

@Service
public class ModalidadeService {

    public List<String> filtrarPorNome(
            List<String> modalidades,
            String palavra) {

        List<String> resultados = new ArrayList<>();

        for (String modalidade : modalidades) {
            if (modalidade.contains(palavra)) {
                resultados.add(modalidade);
            }
        }

        return resultados;
    }

    public List<ModalidadeDTO> filtrarModalidades(
            List<ModalidadeDTO> modalidades,
            String palavra) {

        List<ModalidadeDTO> resultados = new ArrayList<>();

        for (ModalidadeDTO modalidade : modalidades) {
            if (modalidade.nome().toLowerCase(Locale.ROOT)
                    .contains(palavra.toLowerCase(Locale.ROOT))) {
                resultados.add(modalidade);
            }
        }

        return resultados;
    }
}
