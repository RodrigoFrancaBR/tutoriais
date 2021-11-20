package br.com.franca.tutorial.service.enhanced;

import br.com.franca.tutorial.domain.model.CnpjData;

public interface CnpjService {

    CnpjData getEnhancedCnpj(String cnpj);
}
