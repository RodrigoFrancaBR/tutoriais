package br.com.franca.tutorial.service.enhanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class ConditionEnhancedCnpjService {

    @Value("${spring.profiles.active:test}")
    private String profileActive;
    private String service="test";

    @Autowired
    private EnhancedCnpjFactory enhancedCnpjFactory;

    public CnpjService getCnpjService() {
        service = (profileActive.equals("prod")) ? "prod" : "test";
        return enhancedCnpjFactory.getEnhancedCnpjType(service);
    }

    public void setCnpjServiceType(String profileActive) {
        this.profileActive = profileActive;
    }
}
