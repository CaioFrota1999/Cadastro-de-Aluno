package javaapplication6;

import java.time.LocalDate;
import java.time.Period;

public abstract class ClassePessoa {

    // Atributos da Classe Pessoa
    private String nome;
    private String sobrenome;
    private String email;
    private int dia;
    private int mes;
    private int ano;

    //Métodos set da Classe Aluno
    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    protected void setDia(int dia) {
        this.dia = dia;
    }

    protected void setMes(int mes) {
        this.mes = mes;
    }

    protected void setAno(int ano) {
        this.ano = ano;
    }
    // Métodos get da Classe Aluno

    protected String getNome() {
        return nome;
    }

    protected String getSobrenome() {
        return sobrenome;
    }

    protected String getEmail() {
        return email;
    }

    protected int getDia() {
        return dia;
    }

    protected int getMes() {
        return mes;
    }

    protected int getAno() {
        return ano;
    }

    // Métodos auxiliares da Classe Pessoa
    protected String nomeCompleto() {
        return this.getNome() + " " + this.getSobrenome();
    }

    protected int idadeAluno() {
        LocalDate aniversario = LocalDate.of(ano,mes,dia);
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(aniversario, dataAtual);
        return periodo.getYears();
    }

    protected String dataNascimento() {
        return this.getDia() + "/" + this.getMes() + "/" + this.getAno();
    }

}
