package br.com.franca.msenriquecimento.client.apienriquecimento;

import br.com.franca.msenriquecimento.client.dto.PessoaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ApiEnriquecimentoService {

    private final IApiEnriquecimentoClient apiEnriquecimentoClient;

    public PessoaResponse enriquecerAluno(String cpf) {
        long inicioRequest = System.currentTimeMillis();
        log.info("Requisitando cpf: {} inicio: {}", cpf, inicioRequest);
        PessoaResponse pessoaResponse = apiEnriquecimentoClient.enriquecerAluno(cpf);
        log.info("Response: {}", pessoaResponse);
        log.info("requisitando cpf: {} final: {} time", cpf, System.currentTimeMillis() - inicioRequest);
        return pessoaResponse;
    }
}
