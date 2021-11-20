package br.com.franca.tutorial.service.enhanced;

import br.com.franca.tutorial.domain.model.CnpjData;
import org.springframework.stereotype.Service;

@Service(value = "test")
public class EnhancedCnpjFakeService implements CnpjService{

    @Override
    public CnpjData getEnhancedCnpj(String cnpj) {
        System.out.println("fazendo as coisas de dev e test");
        return CnpjData.builder().cnpj(cnpj).nome("Tudo menos PROD").build();
    }
}
