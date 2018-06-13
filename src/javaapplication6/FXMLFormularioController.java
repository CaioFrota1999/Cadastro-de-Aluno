package javaapplication6;

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
import java.time.Month;
import java.time.Period;

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
    private Button cadastrarButton;
    @FXML
    private Button anteButton;
    @FXML
    private Button proxButton;
    @FXML
    private Button excluirButton;
    @FXML
    private TextArea impressaoTextArea;

///Instanciei logo a classe aqui no controlado do FX com um nome sugestivo
    private ClasseBotao controle = new ClasseBotao();

    public void cadastrarButtonClicked() {
        boolean preenchimento = true;

        if (!campovazio()) {
            ClasseAluno obj1 = new ClasseAluno();
            obj1.setNome(nomeTextField.getText());
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
            }
            obj1.setNmatricula(matriTextField.getText());
            try {
                obj1.setNota1(Float.parseFloat(nota1TextField.getText()));
                obj1.setNota2(Float.parseFloat(nota2TextField.getText()));
                obj1.setNota3(Float.parseFloat(nota3TextField.getText()));
            } catch (Exception ex) {
                preenchimento = false;
                JOptionPane.showMessageDialog(null, "Insira uma data válida");

            }

            if (preenchimento && !campovazio()) {

                nomeTextField.clear();
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
        } else {
            JOptionPane.showMessageDialog(null, "Campo vazio");
        }
        // Limpando os campos para cadastrar o próximo aluno

    }

    private boolean campovazio() {
        ArrayList<TextField> fiscalizador = new ArrayList();
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
        for (int x = 0; x < fiscalizador.size(); x++) {
            if (fiscalizador.get(x).getText() == null) {
                return true;
            }
        }
        return false;
    }

    public void excluirButtonClicked() {
        controle.excluirAluno();
    }

    public void anteButtonClicked() {
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
