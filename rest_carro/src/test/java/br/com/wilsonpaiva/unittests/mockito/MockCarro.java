package br.com.wilsonpaiva.unittests.mockito;

import br.com.wilsonpaiva.dto.CarroDTO;
import br.com.wilsonpaiva.model.Carro;

import java.util.ArrayList;
import java.util.List;

public class MockCarro {

    public MockCarro() {
    }

    public Carro mockEntity(){
        return this.mockEntity(0);
    }

    public CarroDTO mockDTO(){
        return this.mockDTO(0);
    }

    public List<Carro> mockEntityList(){
        List<Carro> carros = new ArrayList();
        for (int i = 0; i < 14; i++) {
            carros.add(this.mockEntity(i));
        }
        return carros;
    }

    public List<CarroDTO> mockDTOList(){
        List<CarroDTO> carrosDTO = new ArrayList();
        for (int i = 0; i < 14; i++) {
            carrosDTO.add(this.mockDTO(i));
        }
        return carrosDTO;
    }

    public Carro mockEntity(Integer num){
        Carro carro = new Carro();
        carro.setId(num.longValue());
        carro.setNome("Jetta "+num);
        carro.setModelo("Sedan " +num );
        return carro;
    }

    public CarroDTO mockDTO(Integer num){
        CarroDTO carroDTO = new CarroDTO();
        carroDTO.setKey(num.longValue());
        carroDTO.setNome("Jetta "+num);
        carroDTO.setModelo("Sedan " +num );
        return carroDTO;
    }
}
