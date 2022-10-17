package br.com.wilsonpaiva.controller;

import br.com.wilsonpaiva.model.Carro;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarroController {

    private  static final String template = "Hello, %s! ";

    @RequestMapping("/carro")
    public Carro carro(@RequestParam (value = "nome", defaultValue = "world") String nome){

        return  new Carro(1,String.format(template,nome));

    }
}
