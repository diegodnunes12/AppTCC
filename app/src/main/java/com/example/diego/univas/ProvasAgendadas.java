package com.example.diego.univas;

/**
 * Created by Diego on 16/08/2015.
 */
public class ProvasAgendadas {

    private String nome;
    private String descricao;

    public ProvasAgendadas(String nome) {
        this.nome = nome;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
