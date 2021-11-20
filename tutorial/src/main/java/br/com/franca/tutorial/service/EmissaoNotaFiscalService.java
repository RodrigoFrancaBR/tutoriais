package br.com.franca.tutorial.service;

import br.com.franca.tutorial.config.properties.NotificadorSMSProperties;
import br.com.franca.tutorial.domain.model.Cliente;
import br.com.franca.tutorial.domain.model.Produto;
import br.com.franca.tutorial.domain.model.anotations.PrioridadeDoNotificador;
import br.com.franca.tutorial.domain.model.enums.Prioridade;
import br.com.franca.tutorial.service.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class EmissaoNotaFiscalService {
    @Autowired
    NotificadorSMSProperties notificadorSMSProperties;
//    @Value("${notificador.sms.operadora-celular}")
//    private String operadora;

    @PrioridadeDoNotificador(Prioridade.UM)
    @Autowired
    private Notificador notificador;

    public boolean emitir(Cliente cliente, Produto produto) {
          System.out.println(notificadorSMSProperties.getOperadoraCelular());
//        System.out.println(operadora);

        String mensagem = "Nota fiscal emitida com sucesso!!";

        if (ObjectUtils.isEmpty(cliente) || ObjectUtils.isEmpty(produto)){
            throw new IllegalArgumentException("Cliente e Produto devem ser válidos");
        }

        notificador.notificar(cliente, mensagem);
        return true;
    }
}
