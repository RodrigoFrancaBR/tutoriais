package br.com.franca.msenriquecimento.client.apienriquecimento;

import br.com.franca.msenriquecimento.client.dto.PessoaResponse;
import br.com.franca.msenriquecimento.model.Aluno;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ApiEnriquecimentoService {

    private final IApiEnriquecimentoClient apiEnriquecimentoClient;

    public PessoaResponse findByCpf(String cpf) {
        long inicioRequest = System.currentTimeMillis();
        log.info("Requisitando cpf: {} inicio", cpf);
        PessoaResponse pessoaResponse = apiEnriquecimentoClient.obterCpf(cpf);
        log.info("requisitando cpf: {} final: {} time", cpf, System.currentTimeMillis() - inicioRequest);
        ObjectMapper objectMapper = new XmlMapper();
        return null;
    }
}
