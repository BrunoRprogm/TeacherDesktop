package com.senai.teacherdesktop.Models;

public class SchoolClass {

    private int idTurma;
    private String nm_turma;

    public void setNm_turma(String nm_turma) {
        this.nm_turma = nm_turma;
    }

    public SchoolClass() {
    }

    public SchoolClass(String nm_turma) {
        this.nm_turma = nm_turma;
    }

    public SchoolClass(int idTurma, String nm_turma){
        this.idTurma = idTurma;
        this.nm_turma = nm_turma;
    }

    public int getIdTurma() {return idTurma;}
    public String getNm_turma(){return nm_turma;}
}