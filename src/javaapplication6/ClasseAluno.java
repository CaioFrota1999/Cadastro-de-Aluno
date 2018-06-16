package javaapplication6;

public class ClasseAluno extends ClassePessoa { /* Como o pdf pede,a ClasseAluno herda
                                                da ClassePessoa */
    // Atributos da Classe Aluno
    private String nmatricula;
    private String curso;
    private float nota1;
    private float nota2;
    private float nota3;
   
    // Método Construtor da ClasseAluno
    public ClasseAluno(String nome, String sobrenome, String email, int dia, int mes, int ano, String nmatricula, String curso, float nota1, float nota2, float nota3) {

        this.curso = curso;
        this.nmatricula = nmatricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public ClasseAluno() {

    }

    // Métodos set dos Atributos da ClasseAluno
    public void setNmatricula(String nmatricula) {
        this.nmatricula = nmatricula;
    }
    
    public void setCurso(String curso) {
        this.curso = curso;
    }


    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    
    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    
    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    // Métodos get da ClaaseAluno
    public String getCurso(){
        return curso;
    }
    
    
    public String getNMatricula(){
        return nmatricula;
    }
    
    public float getNota1() {
        return nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public float getMedia() {
        return (nota1 + nota2 + nota3) / 3;
    }

    public String getSituacao() { // Método que retornará uma String contendo a situação do aluno cadastrado

        if ((this.getMedia() >= 7.0)) {
            return "Aprovado por media";
        } else if ((this.getMedia() >= 4.0)) {
            return "Aluno de AF";
        } else {
            return "Aluno reprovado";
        }
    }
    @Override
    public String toString(){ // Método que ficará encarregado de imprimir os dados dos alunos
    String texto = "";
    
    texto += "Nome: " + nomeCompleto() +  "\n";
    texto += "Email: " + getEmail() + "\n";
    texto  += "Data de Nascimento: " + dataNascimento() + "\n";
    texto += "Idade: " + idadeAluno() + " anos"  + "\n";
    texto += "Curso: " + getCurso() + "\n";
    texto += "Matricula: " + getNMatricula() + "\n" ;
    texto += "Notas: " + getNota1() + ", " + getNota2() + ", " + getNota3() + "\n";
    texto += "Media: " + getMedia() + "\n";
    texto += "Situaco: " + getSituacao();
     return texto;
    }

}
