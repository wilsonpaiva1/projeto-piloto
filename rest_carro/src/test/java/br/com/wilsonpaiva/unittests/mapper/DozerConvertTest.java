package br.com.wilsonpaiva.unittests.mapper;

import br.com.wilsonpaiva.dto.CarroDTO;
import br.com.wilsonpaiva.mapper.DozerMapper;
import br.com.wilsonpaiva.model.Carro;
import br.com.wilsonpaiva.unittests.mockito.MockCarro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DozerConvertTest {

    MockCarro mockCarro;

    public DozerConvertTest() {
    }

    @BeforeEach
    public void setUp(){
        this.mockCarro = new MockCarro();
    }

    @Test()
    @Order(0)
    public void parseEntityToDTOTEst(){
        CarroDTO dto =  DozerMapper.parseObject(this.mockCarro.mockEntity(),CarroDTO.class);
        Assertions.assertEquals(0L,dto.getKey());
        Assertions.assertEquals("Jetta 0",dto.getNome());
        Assertions.assertEquals("Sedan 0",dto.getModelo());
    }
    @Test()
    @Order(1)
    public void parseDTOToEntityTEst(){
        Carro carro =  DozerMapper.parseObject(this.mockCarro.mockDTO(),Carro.class);
        Assertions.assertEquals(0L,carro.getId());
        Assertions.assertEquals("Jetta 0",carro.getNome());
        Assertions.assertEquals("Sedan 0",carro.getModelo());
    }

    @Test()
    @Order(2)
    public void parseEntityListToDTOListTest(){

        List<CarroDTO> dtoList = DozerMapper.parseListObjects(this.mockCarro.mockEntityList(),CarroDTO.class);
        CarroDTO dto =  dtoList.get(0);
        Assertions.assertEquals(0L,dto.getKey());
        Assertions.assertEquals("Jetta 0",dto.getNome());
        Assertions.assertEquals("Sedan 0",dto.getModelo());

        CarroDTO dto7 =  dtoList.get(7);
        Assertions.assertEquals(7L,dto7.getKey());
        Assertions.assertEquals("Jetta 7",dto7.getNome());
        Assertions.assertEquals("Sedan 7",dto7.getModelo());

        CarroDTO dto13 =  dtoList.get(13);
        Assertions.assertEquals(13L,dto13.getKey());
        Assertions.assertEquals("Jetta 13",dto13.getNome());
        Assertions.assertEquals("Sedan 13",dto13.getModelo());
    }

    @Test()
    @Order(3)
    public void parseDTOListEntityListTest(){

        List<Carro> carroList = DozerMapper.parseListObjects(this.mockCarro.mockDTOList(),Carro.class);
        Carro carro =  carroList.get(0);
        Assertions.assertEquals(0L,carro.getId());
        Assertions.assertEquals("Jetta 0",carro.getNome());
        Assertions.assertEquals("Sedan 0",carro.getModelo());

        Carro dto7 =  carroList.get(7);
        Assertions.assertEquals(7L,dto7.getId());
        Assertions.assertEquals("Jetta 7",dto7.getNome());
        Assertions.assertEquals("Sedan 7",dto7.getModelo());

        Carro dto13 =  carroList.get(13);
        Assertions.assertEquals(13L,dto13.getId());
        Assertions.assertEquals("Jetta 13",dto13.getNome());
        Assertions.assertEquals("Sedan 13",dto13.getModelo());
    }
}
