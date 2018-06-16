package javaapplication6;
// Importações utilizadas na Classe Principal
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

 // Classe principal criada
public class JavaApplication6 extends Application {

  
    public static void main(String[] args) {
    launch(args);
    }
 @Override
 public void start(Stage primaryStage) throws IOException  {
     AnchorPane root = FXMLLoader.load( // Leiaute do contêiner do nosso formulário
             this.getClass().getResource("FXMLFormulario.fxml") // Recebendo um String com o nome do arquivo FXML
     );
     Scene scene = new Scene(root); // Instaciamento do objeto Scene
     primaryStage.setScene(scene);
     primaryStage.show();
     
    
}
}
