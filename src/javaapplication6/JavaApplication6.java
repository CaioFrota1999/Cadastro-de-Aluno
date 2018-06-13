package javaapplication6;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;


public class JavaApplication6 extends Application {

  
    public static void main(String[] args) {
    launch(args);
    }
 @Override
 public void start(Stage primaryStage) throws IOException  {
     AnchorPane root = FXMLLoader.load(
             this.getClass().getResource("FXMLFormulario.fxml")
     );
     Scene scene = new Scene(root);
     primaryStage.setScene(scene);
     primaryStage.show();
     
    
}
}
