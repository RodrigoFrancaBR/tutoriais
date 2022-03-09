//package br.com.franca.msenriquecimento.client.enriquecimento;
//
//import br.com.franca.msenriquecimento.config.FeignConfig;
//import br.com.franca.msenriquecimento.domain.UsuarioAutenticado;
////import br.com.franca.msenriquecimento.domain.model.Cliente;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@FeignClient(name = "api-enriquecimento", url = "http://localhost:8090/api/enriquecimento/clientes", configuration = FeignConfig.class)
//public interface IEnriquecimentoClient {
//
//    @GetMapping(path = "token", produces = MediaType.TEXT_XML_VALUE)
//    UsuarioAutenticado obterToken(@RequestParam String usuario, @RequestParam String senha, @RequestParam String cliente);
//
//    @GetMapping(path="id", produces = MediaType.TEXT_XML_VALUE)
//    Cliente enriquecerCliente(@RequestParam Long id);
//}
