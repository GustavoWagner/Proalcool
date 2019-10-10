package telas;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import static telas.ProjetoTCC.st;

public class LoginController implements Initializable {
    
    @FXML
    private ImageView voltar;
    
    @FXML
    private JFXTextField user;
    
    @FXML
    private JFXPasswordField password;
    
    @FXML
    private JFXButton logar;
    
    @FXML
    private void voltarAction (MouseEvent event) {
        ProjetoTCC.changeScene("entrada");
        st.centerOnScreen();
    }
    
    @FXML
    private void logarAction (ActionEvent event) {
        if(user.getText().equals("admin") && password.getText().equals("admin")){
            ProjetoTCC.changeScene("cadastrar");
        }
        else {
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setHeaderText("ERRO!");
            alerta.setContentText("Usuário ou senha incorretos, tente novamente");
            alerta.show();
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    }    
    
}
