package br.com.wilsonpaiva.controller;

import br.com.wilsonpaiva.dto.CarroDTO;
import br.com.wilsonpaiva.model.Carro;
import br.com.wilsonpaiva.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carro/v1")
public class CarroController {

    private static  final  String template = "Hello, %S!";

    @Autowired
    CarroService service;
    @RequestMapping("/carro")
    public List<CarroDTO> carro(@RequestParam (value = "nome", defaultValue = "Hello") String nome){

        return service.findAll();
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CarroDTO findById(@PathVariable(value = "id") Long id){
        return service.findById(id);
    }
}
