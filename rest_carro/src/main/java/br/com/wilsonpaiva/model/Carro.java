package br.com.wilsonpaiva.model;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;

@Entity
@Table(name = "carro")
public class Carro implements Serializable {

    private static final long serialVersionUID = -7886584241678132525L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "modelo")
    private String modelo;

    public Carro() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(o instanceof Carro carro)) return false;

        if (getId() != null ? !getId().equals(carro.getId()) : carro.getId() != null) return false;
        if (getNome() != null ? !getNome().equals(carro.getNome()) : carro.getNome() != null) return false;
        return getModelo() != null ? getModelo().equals(carro.getModelo()) : carro.getModelo() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getModelo() != null ? getModelo().hashCode() : 0);
        return result;
    }
}





