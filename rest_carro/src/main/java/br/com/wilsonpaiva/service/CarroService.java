package br.com.wilsonpaiva.service;

import br.com.wilsonpaiva.controller.CarroController;
import br.com.wilsonpaiva.dto.CarroDTO;
import br.com.wilsonpaiva.exceptions.ResourceNotFoundException;
import br.com.wilsonpaiva.mapper.DozerMapper;
import br.com.wilsonpaiva.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import  static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CarroService {

    private Logger logger = Logger.getLogger(CarroService.class.getName());
    @Autowired
    CarroRepository repository;

    public List<CarroDTO> findAll(){
        logger.info("Buscando carro");
        var carro = repository.findAll();
        var listCarroDTO  = carro.stream().map( c -> DozerMapper.parseObject(c,CarroDTO.class));
        return (List<CarroDTO>) listCarroDTO;
    }

    public  CarroDTO findById(Long id){
        logger.info("Buscando um carro por id");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro para esse ID"));
        var dto = DozerMapper.parseObject(entity,CarroDTO.class);
        dto.add(linkTo(methodOn(CarroController.class).findById(id)).withSelfRel());
        return dto;
    }
}
