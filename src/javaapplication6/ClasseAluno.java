package javaapplication6;

public class ClasseAluno extends ClassePessoa {

    private int nmatricula;
    private String curso;
    private float nota1;
    private float nota2;
    private float nota3;
   ///comentário teste
    public ClasseAluno(String nome, String sobrenome, String email, int dia, int mes, int ano, int nmatricula, String curso, float nota1, float nota2, float nota3) {

        this.curso = curso;
        this.nmatricula = nmatricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public ClasseAluno() {

    }

    /**
     * @param nmatricula the nmatricula to set
     */
    public void setNmatricula(int nmatricula) {
        this.nmatricula = nmatricula;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @param nota1 the nota1 to set
     */
    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    /**
     * @param nota2 the nota2 to set
     */
    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    /**
     * @param nota3 the nota3 to set
     */
    public void setNota3(float nota3) {
        this.nota3 = nota3;
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

    public String getSituacao() {

        if ((this.getMedia() >= 7.0)) {
            return "Aprovado por media";
        } else if ((this.getMedia() >= 4.0)) {
            return "Aluno de AF";
        } else {
            return "Aluno reprovado";
        }
    }

}
