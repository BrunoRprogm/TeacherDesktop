package com.senai.teacherdesktop.Models;

public class User  {

    private String email;
    private String senha;
    private Integer id;
    private String nome;


    public User(Integer id,  String nome, String email, String senha ) {

        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }




    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }


    public String getNome() {
        return nome;
    }

    public int getInt(){
        return id;
    }


}
