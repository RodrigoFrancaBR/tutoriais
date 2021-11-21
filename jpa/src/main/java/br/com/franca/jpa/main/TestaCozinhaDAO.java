package br.com.franca.jpa.main;

import br.com.franca.jpa.JpaApplication;
import br.com.franca.jpa.dao.CozinhaDAO;
import br.com.franca.jpa.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class TestaCozinhaDAO {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(JpaApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaDAO dao = applicationContext.getBean(CozinhaDAO.class);


        Cozinha cozinha = dao.buscar(1L);

        System.out.println(cozinha.getNome());
    }
}
