package br.com.wilsonpaiva.model;

public class Carro {

    private final long id;
    private final  String nome;

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

