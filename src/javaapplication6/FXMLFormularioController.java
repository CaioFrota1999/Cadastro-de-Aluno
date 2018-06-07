package javaapplication6;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



public class FXMLFormularioController implements Initializable {
@FXML
private TextField nomeTextField;
@FXML
private TextField sobrenomeTextField;
@FXML
private TextField emailTextField;
@FXML
private TextField diaTextField;
@FXML
private TextField mesTextField;
@FXML
private TextField anoTextField;
@FXML
private ComboBox cursoComboBox;
@FXML
private TextField matriTextField;
@FXML
private TextField nota1TextField;
@FXML
private TextField nota2TextField;
@FXML
private TextField nota3TextField;
@FXML
private TextArea impressaoTextArea;

///Instanciei logo a classe aqui no controlado do FX com um nome sugestivo
private ArrayController controle = new ArrayController();

private void cadastrarButtonClicked(){
    System.out.println("Botão Clicado");
    ClasseAluno obj1 = new ClasseAluno();
    obj1.setNome(nomeTextField.getText());
    obj1.setSobrenome(sobrenomeTextField.getText());
    obj1.setEmail(emailTextField.getText());
    obj1.setDia(Integer.parseInt(diaTextField.getText()));
    obj1.setMes(Integer.parseInt(mesTextField.getText()));
    obj1.setAno(Integer.parseInt(anoTextField.getText()));
    obj1.setNota1(Float.parseFloat(nota1TextField.getText()));
    obj1.setNota2(Float.parseFloat(nota2TextField.getText()));
    obj1.setNota3(Float.parseFloat(nota3TextField.getText()));
    
    ArrayList<ClasseAluno> universitario = new ArrayList();
    universitario.add(obj1);
    ///método para adicionar o novo aluno já adicionado
    controle.addNewAluno(obj1);
    ///sugestão apague esssa parte da exibição aqui do controle e adiciona para dentro da classe ArrayController que fica mais elegante 
    String texto = "";
    texto += "Nome: " + nomeTextField.getText() + " " + sobrenomeTextField.getText() +  "\n";
    texto += "Email: " + emailTextField.getText() + "\n";
    texto  += "Data de Nascimento: " + diaTextField.getText() + "/" + mesTextField.getText() + "/" + anoTextField.getText() + "\n";
    texto += "Idade: " + (2018 - Integer.parseInt(anoTextField.getText())) + "\n";
    texto += "Curso: " + cursoComboBox.getSelectionModel().getSelectedItem().toString() + "\n";
    texto += "Matricula: " + matriTextField.getText() + "\n" ;
    texto += "Notas: " + nota1TextField.getText()+".0" + ", " + nota2TextField.getText() + ".0" + ", " + nota3TextField.getText()+ ".0" + "\n";
    ///apague até aqui
    
    ////altera a linha 74 para impessaoTextArea.setText(controle.getUltimoAluno());
    /// depois que cria os métodos lá na classe ArrayController
    impressaoTextArea.setText(texto);
   
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cursoComboBox.getItems().addAll(
                "Engenharia Elétrica",
                "Engenharia da Computação",
                "Psicologia",
                "Medicina",
                "Música",
                "Odontologia",
                "Economia",
                "Finanças"
        );
    }    
    
}
