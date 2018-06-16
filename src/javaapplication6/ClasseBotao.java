package javaapplication6;
//Importações da ClasseBotão

import java.util.ArrayList;

public class ClasseBotao { // Classe criada para um melhor gerenciamento e controle sobre os botões e o ArrayList

    ArrayList<ClasseAluno> universitarios = new ArrayList<ClasseAluno>();
    private int index = 0;

    //Método para adicionar um novo aluno no ArrayList
    public void addNewAluno(ClasseAluno novo) {
        universitarios.add(novo);

    }

    public int getQuantidade() {
        return universitarios.size();
    }

    /*
      O gerenciamento do array ocorrerá nesses 3 métodos a baixo
     */
    public String getProximoAluno() { // Index incrementa e caso index e tamanho do ArrayList sejam iguais,index receberá 0
        index++;
        if (index == universitarios.size()) {
            index = 0;
        }
        if (universitarios.size() == 0) {
            return "Lista vázia";
        }
        return "Pos: " + (index + 1) + "\n" + universitarios.get(index).toString();
    }

    public String getAlunoAnterior() { // Funciona de maneira análoga ao método anterior
        index--;
        if (index < 0) {
            index = universitarios.size() - 1;
        }
        if (universitarios.size() == 0) {
            return "Lista vázia";
        }

        return "Pos: " + (index + 1) + "\n" + universitarios.get(index).toString();
    }

    public String getUltimoAlunoCadastrado() {

        return "Pos: " + (universitarios.size()) + "\n" + universitarios.get(universitarios.size() - 1).toString();
    }

    public boolean excluirAluno() {
        if (universitarios.size() == 0) {
            return false;
        } else {
            universitarios.remove(index);
            return true;
        }
    }
}
