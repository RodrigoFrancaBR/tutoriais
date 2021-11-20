package br.com.franca.tutorial.api.controller;

import br.com.franca.tutorial.domain.model.CnpjData;
import br.com.franca.tutorial.service.enhanced.CnpjService;
import br.com.franca.tutorial.service.enhanced.ConditionEnhancedCnpjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cnpj")
public class CnpjController {

    @Autowired
    private ConditionEnhancedCnpjService conditionEnhancedCnpjService;

    @GetMapping(path = "/{cnpj}")
    private CnpjData getEnhancedCnpj(@PathVariable String cnpj){
        CnpjService cnpjService = conditionEnhancedCnpjService.getCnpjService();
        return cnpjService.getEnhancedCnpj(cnpj);
    }
}
