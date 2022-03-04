//package br.com.franca.apienriquecimento.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@Slf4j
//@RestController
//@RequestMapping("api/enriquecimento/pessoas")
//public class TokenController {
//
//    @GetMapping(path = "token", produces = MediaType.TEXT_XML_VALUE)
//    public String obterToken(@RequestParam String usuario, @RequestParam String senha, @RequestParam String cliente) throws JsonProcessingException {
//        log.info("inicio usuario: {}, senha: {}, cliente: {}");
//        ObjectMapper xmlMapper = new XmlMapper();
//        return xmlMapper.writeValueAsString("tokenXYZ");
//    }
//}
