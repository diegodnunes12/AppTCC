package com.example.diego.univas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Created by Diego on 13/07/2015.
 */
public class DB extends _Default implements  Runnable{

    private Connection conn;
    private String host = "192.168.0.102";
    private String db = "univas";
    private int porta = 5432;
    private String user = "postgres";
    private String pass = "diego";
    private  String url = "jdbc:postgresql://%s:%d/%s";

    public DB() {
        super();
        this.url = String.format(this.url, this.host, this.porta, this.db);

        this.conecta();
        this.desconecta();
    }

    @Override
    public void run() {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection("jdbc:postgresql://192.168.0.102:5432/univas", "postgres", "diego");
        }catch (Exception e){
            this._mensagem = e.getMessage();
            this._status = false;
        }
    }

    private void conecta(){
        Thread thread = new Thread(this);
        thread.start();
        try{
            thread.join();
        }catch(Exception e){
            this._mensagem = e.getMessage();
            this._status = false;
        }
    }

    private void desconecta(){
        if(this.conn != null){
            try{
                this.conn.close();
            }catch(Exception e){
                this._mensagem = e.getMessage();
                this._status = false;
            }finally {
                //conn = null;
            }
        }
    }

    public ResultSet select(String query){
        this.conecta();
        ResultSet resultSet = null;
        try {
            this.conecta();
            resultSet = new ExecuteDB(this.conn, query).execute().get();
        }catch(Exception e){
            this._mensagem = e.getMessage();
            this._status = false;
        }
        return resultSet;
    }
}
