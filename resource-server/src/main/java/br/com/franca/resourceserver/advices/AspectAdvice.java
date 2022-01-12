package br.com.franca.resourceServer.advices;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAdvice {
/*
    @Before("execution(public * *(..))")
    public void execute(){
        System.out.println("Executando o método execute(), antes de todos os métodos públicos.");
    }*/


    @Before("execution(public * obter*(..))")
    public void executeAntesDoObter(){
        System.out.println("Executando o método executeAntesDoObter, antes do método obter().");
    }

    /*
    @Around("execution(public * put*(..))")
    public Object manipularDados(ProceedingJoinPoint pjp){
        System.out.println("manipulou os dados");
        Object[] args = pjp.getArgs();
        for(Object a : args){
            System.out.println(a.toString());
        }
        return null;
    }
    */
}
