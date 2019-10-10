package telas;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class InicioController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private JFXButton vDados;
    
    @FXML
    private JFXButton fLogin;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        ProjetoTCC.changeScene("dados");
    }
    
    @FXML
    private void Login(ActionEvent event) {
        ProjetoTCC.changeScene("login");
    }
    
    @FXML
    private void mouseButtonAction(MouseEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void informarAction(MouseEvent event) {
        Alert inform = new Alert(Alert.AlertType.INFORMATION);
        inform.setTitle("");
        inform.setHeaderText("Informação:");
        inform.setContentText("Este programa, nomeado como Proálcool, foi desenvolvido por Gustavo Odelon Wagner em meio aos estudos realizados"
                + " durante o processo de escrita do TCC para conclusão do Ensino Técnico em Informática pelo IFPR - campus Londrina que tem por título "
                + "'O IMPACTO ECONÔMICO NO SETOR AUTOMOBILÍSTICO E A CRIAÇÃO DO PROÁLCOOL NA DÉCADA DE 1980'");
        inform.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
}    
