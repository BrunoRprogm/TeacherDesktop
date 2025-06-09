package com.senai.teacherdesktop.Models;

public class User  {

   private String email;
   private String senha;
   private Integer id;
   private String nome;


    public User(int id, String email, String senha, String string) {
        this.email = email;
        this.senha = senha;
    }

    public User(String email, String senha, Integer id, String nome) {
        this.email = email;
        this.senha = senha;
        this.id = id;
        this.nome = nome;
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
