
package javaapplication6;

import java.util.ArrayList;


public class ClasseBotao {
    
    ArrayList<ClasseAluno> universitarios = new ArrayList<ClasseAluno>();
    private int index = 0;
    
     ///Essa função vc vai usar quando aperta no botão de "cadastrar"
    ///Função para adicionar um novo aluno no arrayList
    public void addNewAluno(ClasseAluno novo){
    universitarios.add(novo);   
    
    
}
    
    /*
      O gerenciamento do array ocorrerá nessas 3 funções a baixo
    */
    
    public String getProximoAluno(){
       index++;
       if(index == universitarios.size()){
          index = 0;
       }
       return  "Pos: " + index + "\n" + universitarios.get(index).toString();
    }
    public String getAlunoAnterior(){
      index--;
      if(index  < 0){
         index  = universitarios.size() - 1;
      }
      
      return "Pos: " + index + "\n" + universitarios.get(index).toString();
    }
    public String getUltimoAlunoCadastrado(){
       
       return "Pos: " + (universitarios.size()) + "\n" + universitarios.get(universitarios.size() - 1).toString();
    }
    public boolean excluirAluno(){
       universitarios.remove(index);
       
       return true;
    }
}
