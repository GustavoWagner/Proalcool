package telas;

import classes.BD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import static telas.ProjetoTCC.st;

public class CadastrarController implements Initializable {
    
    Alert alerta;
    
    @FXML
    private JFXTextField ano;
    
    @FXML
    private JFXTextField prodCana;
    
    @FXML
    private JFXTextField prodAçucar;
    
    @FXML
    private JFXTextField prodAlcool;
    
    @FXML
    private JFXTextField vendaAlcool;
    
    @FXML
    private JFXTextField vendaGasolina;
    
    @FXML
    private JFXButton adDados;
    
    @FXML
    private JFXButton rmvDados;
    
    @FXML
    private void adicionarDados (ActionEvent event) throws SQLException {
        
        if(ano.getText() != null && prodCana.getText() != null && prodAçucar.getText() != null && prodAlcool.getText() != null
                && vendaAlcool.getText() != null && vendaGasolina.getText() != null){
            if (isInt(ano.getText()) && isInt(prodCana.getText()) && isInt(prodAçucar.getText()) 
                    && isInt(prodAlcool.getText()) && isInt(vendaAlcool.getText()) && isInt(vendaGasolina.getText())){
                
                if(!BD.contains(Integer.parseInt(ano.getText()))){
                    novosDados(Integer.parseInt(ano.getText()), Integer.parseInt(prodCana.getText()), 
                        Integer.parseInt(prodAçucar.getText()),Integer.parseInt(prodAlcool.getText()), 
                        Integer.parseInt(vendaAlcool.getText()), Integer.parseInt(vendaGasolina.getText()));
                } else {
                    alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setContentText("O ano inserido já existe no Banco de Dados");
                    alerta.show();
                }
                
            } else {
                    alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setContentText("Um ou mais valores inválidos");
                    alerta.show();
            }
            } else {
                alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Um ou mais dados possuem valor nulo");
                alerta.show();
        }
    }
    
    @FXML
    public void removerDados (ActionEvent event){
        remover(ano.getText());
    }
    
    public void remover (String ano){
        
        if(!this.ano.getText().equals("1982") && !this.ano.getText().equals("1983") && !this.ano.getText().equals("1984")
                && !this.ano.getText().equals("1985") && !this.ano.getText().equals("1986") && !this.ano.getText().equals("1987")
                && !this.ano.getText().equals("1988") && !this.ano.getText().equals("1989") && !this.ano.getText().equals("1990")
                && !this.ano.getText().equals("1991")){
        try {
            alerta = new Alert(Alert.AlertType.CONFIRMATION);
            PreparedStatement st = BD.con.prepareStatement("DELETE FROM dados WHERE ano = ?");
            st.setInt(1, Integer.parseInt(ano));
            st.executeUpdate();
            alerta.setContentText("Os dados correspondentes ao ano digitado, foram excluídos!");
            alerta.show();
            this.ano.clear();
            this.prodCana.clear();
            this.prodAçucar.clear();
            this.prodAlcool.clear();
            this.vendaAlcool.clear();
            this.vendaGasolina.clear();
        } catch (Exception e) {
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("O campo 'ano' fora preenchido de maneira errada!");
            alerta.show();
        }
        } else {
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("O ano solicitado não permite exclusão!");
            alerta.show();
        }
    }
    
    public void novosDados(int ano, int prodCana, int prodAçucar, int prodAlcool, int vendaAlcool, int vendaGasolina){
        
            try {
                PreparedStatement stm = BD.con.prepareStatement("INSERT INTO dados VALUES (?, ?, ?, ?, ?, ?);");
                stm.setInt(1, ano);
                stm.setInt(2, prodCana);
                stm.setInt(3, prodAçucar);
                stm.setInt(4, prodAlcool);
                stm.setInt(5, vendaAlcool);
                stm.setInt(6, vendaGasolina);
                stm.executeUpdate();
                this.ano.clear();
                this.prodCana.clear();
                this.prodAçucar.clear();
                this.prodAlcool.clear();
                this.vendaAlcool.clear();
                this.vendaGasolina.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
    public boolean isInt(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    @FXML
    private void informa (MouseEvent event) {
        Alert inform = new Alert(Alert.AlertType.INFORMATION);
        inform.setTitle("");
        inform.setHeaderText("Informação:");
        inform.setContentText("Para adicionar os dados, preencha todos os campos com dados válidos e pressione 'Adicionar dados'. "
                + "Para excluir basta digitar o ano e pressionar 'Remover dados' que todos os dados referentes ao ano digitado"
                + " serão deletados do Banco.");
        inform.show();
    }
    
    @FXML
    private void voltarAction (MouseEvent event) {
        ProjetoTCC.changeScene("login");
        st.centerOnScreen();
    }
    
    @FXML
    private void mouseButtonAction(MouseEvent event) {
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
