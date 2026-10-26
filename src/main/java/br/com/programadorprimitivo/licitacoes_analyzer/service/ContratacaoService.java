package br.com.programadorprimitivo.licitacoes_analyzer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

import br.com.programadorprimitivo.licitacoes_analyzer.dto.ContratacaoDTO;

@Service
public class ContratacaoService {

    public List<ContratacaoDTO> filtrarPorObjeto(
            List<ContratacaoDTO> contratacoes,
            String palavra) {

        List<ContratacaoDTO> resultados = new ArrayList<>();

        for (ContratacaoDTO contratacao : contratacoes) {
            if (contratacao.objetoCompra() != null
                    && contratacao.objetoCompra().toLowerCase(Locale.ROOT)
                            .contains(palavra.toLowerCase(Locale.ROOT))) {
                resultados.add(contratacao);
            }
        }

        return resultados;
    }
}
