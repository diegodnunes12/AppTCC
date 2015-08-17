package com.example.diego.univas;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Diego on 13/07/2015.
 */
public class Notas{

    private String nome;
    private String descricao;

    public Notas(String nome) {
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



   /* public ArrayList<Notas> getLista(){
        DB db = new DB();
        ArrayList<Notas> lista = new ArrayList<>();
        try{
            ResultSet resultSet = db.select("SELECT * from notas");
            if(resultSet != null){
                while (resultSet.next()){
                    Notas obj = new Notas();
                    obj.setId(resultSet.getInt("id"));
                    obj.setValor(resultSet.getInt("valor"));
                    obj.setAluno(resultSet.getInt("aluno"));
                    obj.setMateria(resultSet.getInt("materia"));
                    lista.add(obj);
                    obj = null;
                }
            }
        }catch(Exception e){
            this._mensagem = e.getMessage();
            this._status = false;
        }
        return  lista;
    }*/
}
