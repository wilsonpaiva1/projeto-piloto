package br.com.wilsonpaiva.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import jakarta.persistence.Column;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@JsonPropertyOrder({"id","nome","modelo"})
public class CarroDTO extends RepresentationModel<CarroDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Mapping("id")
    private Long key;
    private String nome;
    private String modelo;

    public CarroDTO() {
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarroDTO dto)) return false;

        if (getKey() != null ? !getKey().equals(dto.getKey()) : dto.getKey() != null) return false;
        if (getNome() != null ? !getNome().equals(dto.getNome()) : dto.getNome() != null) return false;
        return getModelo() != null ? getModelo().equals(dto.getModelo()) : dto.getModelo() == null;
    }

    @Override
    public int hashCode() {
        int result = getKey() != null ? getKey().hashCode() : 0;
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getModelo() != null ? getModelo().hashCode() : 0);
        return result;
    }
}
