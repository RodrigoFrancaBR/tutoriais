package br.com.franca.apienriquecimento.aspect;

import br.com.franca.apienriquecimento.anotations.Auditavel;
import br.com.franca.apienriquecimento.enuns.Erro;
import br.com.franca.apienriquecimento.exception.ConvertException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Aspect
@Component
public class AuditavelAspect {

    @Around("@annotation(br.com.franca.apienriquecimento.anotations.Auditavel)")
    public Object logRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        final String NOME_DA_TABELA = "nomeDaTabela";
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();

        var parameterNames = codeSignature.getParameterNames();
        var parameterValues = joinPoint.getArgs();

        Map<String, Object> requestMap = new HashMap<>();

        for (int i = 0; i < parameterNames.length; i++) {
            var valoresRequest = eUmTipoJava(parameterValues[i]) ?
                    Map.of(parameterNames[i], parameterValues[i]) :
                    getMapComNomeValorDoAtributoDoObjeto(parameterValues[i], requestMap);

            requestMap.putAll(valoresRequest);
        }

        System.out.println(requestMap);
        String nomeDaTabela = getNomeDaTabela(joinPoint);
        requestMap.put(NOME_DA_TABELA, nomeDaTabela);
        var result = joinPoint.proceed();

        return result;
    }

    private String getNomeDaTabela(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        return methodSignature.getMethod().getAnnotation(Auditavel.class).nomeDaTabela();
    }

    private Map<String, Object> getMapComNomeValorDoAtributoDoObjeto(Object objeto, Map<String, Object> requestMap) {
        // transformar vetor em lista
        List<Field> atributosDoObjeto = Arrays.stream(objeto.getClass().getDeclaredFields()).collect(Collectors.toList());
        atributosDoObjeto.forEach(atributo -> {
            requestMap.putAll(getMapComNomeValorDoAtributo(atributo, objeto));
        });
        return requestMap;
    }


    private Map<String, Object> getMapComNomeValorDoAtributo(Field atributo, Object objeto) {
        Map<String, Object> mapComNomeValorDoAtributo = new HashMap<>();
        atributo.setAccessible(Boolean.TRUE);

        try {
            String nomeDoAtributo = atributo.getName();
            Object valorDoAtributo = atributo.get(objeto);
            mapComNomeValorDoAtributo.put(nomeDoAtributo, valorDoAtributo);
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
            throw new ConvertException(Erro.CONVERSAO_FALHOU.getChave(), ex);
        }
        return mapComNomeValorDoAtributo;

    }

    private boolean eUmTipoJava(Object parameterValue) {
        final String JAVA_PACKAGE = "java";
        return parameterValue.getClass().getPackageName().contains(JAVA_PACKAGE);
    }
}
