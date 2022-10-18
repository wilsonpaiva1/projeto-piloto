package br.com.wilsonpaiva.controller;

import br.com.wilsonpaiva.dto.CarroDTO;
import br.com.wilsonpaiva.model.Carro;
import br.com.wilsonpaiva.service.CarroService;
import br.com.wilsonpaiva.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/carro/v1")
@Tag(name = "Carro",description = "Endpoint para gerenciar Carro")
public class CarroController {

    private Logger logger = Logger.getLogger(CarroController.class.getName());

    @Autowired
    CarroService service;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/{id}")
    @Operation(summary = "Finds a Carro", description = "Finds a Carro",
            tags = {"Carro"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CarroDTO.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    public CarroDTO findById(@PathVariable(value = "id") Long id){
        return service.findById(id);
    }
}
