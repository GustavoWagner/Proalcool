package telas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import static telas.ProjetoTCC.st;

public class InfoController implements Initializable {
    
    @FXML
    private Label label1;
    
    @FXML
    private Label label2;
    
    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private void voltarAction (MouseEvent event) {
        ProjetoTCC.changeScene("graphic");
        st.centerOnScreen();
    }
    
    @FXML
    private void mouseButtonAction(MouseEvent event) {
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void informa (MouseEvent event) {
        Alert inform = new Alert(Alert.AlertType.INFORMATION);
        inform.setTitle("");
        inform.setHeaderText("Informação:");
        inform.setContentText("Nesta tela apresentam-se diagramas que tem o objetivo de facilitar o compreendimento de um evento "
                + "que marcou o Brasil durante as décadas de 1970 a 1990.");
        inform.show();
    }
    
}
