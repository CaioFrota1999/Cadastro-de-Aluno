package javaapplication6;
// Importações utilizadas

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import javafx.scene.image.ImageView;

public class FXMLFormularioController implements Initializable {
// Definindo todos os controles que fará a ligação entre o código e a interface como sugerido no pdf da Prática 05

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
    private Button cadastrarButton;
    @FXML
    private Button anteButton;
    @FXML
    private Button proxButton;
    @FXML
    private Button excluirButton;
    @FXML
    private TextArea impressaoTextArea;
    @FXML
    private ImageView imagem;

///Instanciei logo a classe aqui no controlado do FX com um nome sugestivo
    private ClasseBotao controle = new ClasseBotao();

    public void cadastrarButtonClicked() {
        boolean preenchimento = true; // Definindo uma variável do tipo booleana para verificar os campos

        if (!campovazio()) {  // if usado para caso o campo esteja preenchido
            ClasseAluno obj1 = new ClasseAluno();  //instanciando obj do tipo ClasseAluno
            obj1.setNome(nomeTextField.getText()); //getText usado para retornar a String em áreaas de textos
            obj1.setSobrenome(sobrenomeTextField.getText());
            obj1.setEmail(emailTextField.getText());
            obj1.setCurso(cursoComboBox.getSelectionModel().getSelectedItem().toString());
            int dia = Integer.parseInt(diaTextField.getText());
            int mes = Integer.parseInt(mesTextField.getText());
            int ano = Integer.parseInt(anoTextField.getText());

            if (DataCorreta(dia, mes, ano)) {
                obj1.setDia(Integer.parseInt(diaTextField.getText()));
                obj1.setMes(Integer.parseInt(mesTextField.getText()));
                obj1.setAno(Integer.parseInt(anoTextField.getText()));
            } else {
                obj1.setNmatricula(matriTextField.getText());
                try { // Tendo em mente a situação do usuário colocar alguma nota inválida usamos o try para desviar pro catch e assim não haverá paradad brusca na execução do código
                    obj1.setNota1(Float.parseFloat(nota1TextField.getText()));
                    obj1.setNota2(Float.parseFloat(nota2TextField.getText()));
                    obj1.setNota3(Float.parseFloat(nota3TextField.getText()));
                } catch (Exception ex) { // Sendo desviado o programa iinformará uma alerta usando JOptionPane
                    preenchimento = false;
                    JOptionPane.showMessageDialog(null, "Insira uma nota válida");

                }

                if (preenchimento && !campovazio()) { // Caso as duas condições ocorram simultaneamente...

                    nomeTextField.clear(); // Cada campo será limpado através do método clear()
                    sobrenomeTextField.clear();
                    emailTextField.clear();
                    diaTextField.clear();
                    mesTextField.clear();
                    anoTextField.clear();
                    matriTextField.clear();
                    nota1TextField.clear();
                    nota2TextField.clear();
                    nota3TextField.clear();

// Método para adicionar o novo aluno adicionado
                    controle.addNewAluno(obj1);
                    impressaoTextArea.setText(controle.getUltimoAlunoCadastrado());
                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "Campo vazio");
        }

    }

    private boolean campovazio() { // Método que vai verificar se os campos estão vazios
        ArrayList<TextField> fiscalizador = new ArrayList(); // Definindo um ArrayList para auxiliar
        fiscalizador.add(diaTextField);
        fiscalizador.add(nomeTextField);
        fiscalizador.add(sobrenomeTextField);
        fiscalizador.add(emailTextField);
        fiscalizador.add(mesTextField);
        fiscalizador.add(anoTextField);
        fiscalizador.add(matriTextField);
        fiscalizador.add(nota1TextField);
        fiscalizador.add(nota2TextField);
        fiscalizador.add(nota3TextField);
        for (int x = 0; x < fiscalizador.size(); x++) { // Laço de repetição feito para percorrer todas as posições do ArrayList ja que o método size() retorna o tamanho do Array
            if (fiscalizador.get(x).getText() == null || fiscalizador.get(x).getText() == "" || fiscalizador.get(x).getText().isEmpty()) {
                return true; // Nesse método queremos verificar se o campo está vazio,então se ele receber uma String vazia ou nula retornará true e a alerta aparecerá
            }
        }
        return false;
    } // Fim do bloco referente ao Botão Cadastrar

    public void excluirButtonClicked() {
        if (controle.excluirAluno() && controle.getQuantidade() == 0) {
            impressaoTextArea.setText("");
        } else if (controle.excluirAluno()) {
            proxButtonClicked();
        } else {
            JOptionPane.showMessageDialog(null, "Lista vazia");
        }

    }

    public void anteButtonClicked() { // Aqui ocorrerá as chamadas dos metódos feitos na ClasseBotao
        impressaoTextArea.setText(controle.getAlunoAnterior());
    }

    public void proxButtonClicked() {
        impressaoTextArea.setText(controle.getProximoAluno());
    }

    private boolean DataCorreta(int dia, int mes, int ano) {
        try {
            LocalDate teste = LocalDate.of(ano, mes, dia);

        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    @Override // Método utiizado para adicionar itens ao ComboBox tendo como exemplo o pdf da Prática 05
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
