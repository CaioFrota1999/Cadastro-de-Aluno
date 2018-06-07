package javaapplication6;

public abstract class ClassePessoa {

    private String nome;
    private String sobrenome;
    private String email;
    private int dia;
    private int mes;
    private int ano;

    /**
     * @param nome the nome to set
     */
    protected void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    protected void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @param email the email to set
     */
    protected void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param dia the dia to set
     */
    protected void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @param mes the mes to set
     */
    protected void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @param ano the ano to set
     */
    protected void setAno(int ano) {
        this.ano = ano;
    }

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

    protected String nomeCompleto() {
        return this.getNome() + " " + this.getSobrenome();
    }

    protected int idadeAluno() {
        return 2018 - this.getAno();
    }

    protected String dataNascimento() {
        return this.getDia() + "/" + this.getMes() + "/" + this.getAno();
    }

}
