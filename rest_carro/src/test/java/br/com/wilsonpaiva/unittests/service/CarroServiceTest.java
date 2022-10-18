package br.com.wilsonpaiva.unittests.service;

import br.com.wilsonpaiva.dto.CarroDTO;
import br.com.wilsonpaiva.model.Carro;
import br.com.wilsonpaiva.repository.CarroRepository;
import br.com.wilsonpaiva.service.CarroService;
import br.com.wilsonpaiva.unittests.mockito.MockCarro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith({MockitoExtension.class})
public class CarroServiceTest {

    MockCarro mockCarro;

    @InjectMocks
    private CarroService service;
    @Mock
    CarroRepository repository;

    public CarroServiceTest() {
    }

    @BeforeEach
    void setUpMocks() throws Exception{
        this.mockCarro = new MockCarro();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void  findById(){
        Carro entity = this.mockCarro.mockEntity(1);
        entity.setId(1L);
        Mockito.when(this.repository.findById(1L)).thenReturn(Optional.of(entity));
        CarroDTO result = this.service.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/carro/v1/1>;rel=\"self\"]"));
        assertEquals("Jetta 1",result.getNome());
        assertEquals("Sedan 1",result.getModelo());

    }
}
