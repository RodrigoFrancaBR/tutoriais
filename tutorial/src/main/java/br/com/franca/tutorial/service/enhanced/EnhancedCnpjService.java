package br.com.franca.tutorial.service.enhanced;

import br.com.franca.tutorial.domain.model.CnpjData;
import org.springframework.stereotype.Service;

@Service(value = "prod")
public class EnhancedCnpjService implements CnpjService{

    @Override
    public CnpjData getEnhancedCnpj(String cnpj) {
        System.out.println("fazendo as coisas de produção");
        return CnpjData.builder().cnpj(cnpj).nome("PROD").build();
    }
}
