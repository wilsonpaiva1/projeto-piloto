package br.com.wilsonpaiva.model;

public class Carro {

    private long id;
    private String nome;

    public Carro(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
