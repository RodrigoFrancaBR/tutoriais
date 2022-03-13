package br.com.franca.apienriquecimento.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;


@RestController
@RequestMapping("/host")
public class HostCheckController {

    @GetMapping(path = "/check")
    public String checkHost() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress()
                + " - " + InetAddress.getLocalHost().getHostName();
    }
}
