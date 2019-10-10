package telas;

import classes.BD;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import static telas.ProjetoTCC.st;

public class TextController implements Initializable {
    
    @FXML
    private ImageView sair;
    
    @FXML
    private ImageView voltar;
    
    @FXML
    private ImageView info;
    
    @FXML
    private LineChart<String, Integer> LineChart;
    
    public static XYChart.Series<String, Integer> sA = new XYChart.Series<String, Integer>();
    public static XYChart.Series<String, Integer> sG = new XYChart.Series<String, Integer>();    
    
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    private void informa (MouseEvent event) {
        Alert informa = new Alert(Alert.AlertType.INFORMATION);
        informa.setTitle("");
        informa.setHeaderText("Informação:");
        informa.setContentText("Para a visualização do gráfico pressione qualquer canto da tela, "
                + "dessa maneira o gráfico será construído conforme os dados cadastrados.");
        informa.show();
    }
    
    @FXML
    private void mouseButtonAction (MouseEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void proxAction (MouseEvent event) {
        ProjetoTCC.changeScene("info");
        st.centerOnScreen();
    }
    
    @FXML
    private void voltarAction (MouseEvent event) {
        ProjetoTCC.changeScene("dados");
        st.centerOnScreen();
    }
    
    @FXML
    private void atualizarAction (MouseEvent e) {
        
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        XYChart.Series<String, Integer> seriesGasosa = new XYChart.Series<>();
        try {
            try {
                PreparedStatement st = BD.con.prepareStatement("SELECT * FROM dados");
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    series.getData().add(new XYChart.Data<>("" + rs.getInt("ano"), rs.getInt("vendaAlcool")));
                    seriesGasosa.getData().add(new XYChart.Data<>("" + rs.getInt("ano"), rs.getInt("vendaGasolina")));
                }
                if (sA.getData().toString().equalsIgnoreCase(series.getData().toString())   ) {
                    return;
                }
                series.setName("Venda de carros movidos a álcool");
                seriesGasosa.setName("Venda de carros movidos a gasolina");
                LineChart.getData().add(series);
                LineChart.getData().add(seriesGasosa);
                sA.setData(series.getData());
                
                
            } catch (SQLException ex) {
                Logger.getLogger(TextController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(Exception x) {
            
        }
    }
}
