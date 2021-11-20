package br.com.franca.tutorial.config;

import br.com.franca.tutorial.service.enhanced.*;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CnpjServiceConfig {

    @Bean
    public CnpjService enhancedCnpjService(){
        return new EnhancedCnpjService();
    }

    @Bean
    public CnpjService enhancedCnpjFakeService(){
        return new EnhancedCnpjFakeService();
    }

    @Bean
    public ServiceLocatorFactoryBean serviceLocatorFactoryBean() {
        ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
        serviceLocatorFactoryBean.setServiceLocatorInterface(EnhancedCnpjFactory.class);
        return serviceLocatorFactoryBean;
    }

    @Bean
    public ConditionEnhancedCnpjService conditionEnhancedCnpjSeervice() {
        return new ConditionEnhancedCnpjService();
    }

}
