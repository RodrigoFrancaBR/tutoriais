package br.com.franca.tutorial.service.funcionalidades;

public class FuncionalidadeEscrever implements Funcionalidades {
    @Override
    public void executarFuncionalidade() {
        System.out.println("Escrevendo!!");
    }

    /** é possível usar o @Profile("prod) e na outra classe que implementa a interface @profile(!prod)
     * ai não precisa criar uma classe de configuração.
     *
     */
}
