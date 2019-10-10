package telas;

import classes.BD;
import classes.ProalcoolDados;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import static telas.ProjetoTCC.st;

public class DadosController implements Initializable {
   
    private ObservableList <ProalcoolDados> lista;
    
    @FXML
    private Label label;
    
    @FXML
    private TableView tbv;
    
    @FXML
    private ImageView sair;
    
    @FXML
    private ImageView voltar;
    
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
    private JFXButton prox;
    
    @FXML
    private JFXButton reDados;
    
    @FXML
    private TableColumn<ProalcoolDados, Integer> ano1;
    
    @FXML
    private TableColumn<ProalcoolDados, Float> prod1;
    
    @FXML
    private TableColumn<ProalcoolDados, Float> prod2;
    
    @FXML
    private TableColumn<ProalcoolDados, Float> prod3;
    
    @FXML
    private TableColumn<ProalcoolDados, Integer> venda1;
    
    @FXML
    private TableColumn<ProalcoolDados, Integer> venda2;
   
    @FXML
    private void voltarAction (MouseEvent event) {
        ProjetoTCC.changeScene("entrada");
        st.centerOnScreen();
    }
    
    @FXML
    private void proxAction (ActionEvent event) {
        ProjetoTCC.changeScene("graphic");
        st.centerOnScreen();
    }
    
    @FXML
    private void mouseButtonAction(MouseEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void atualizarLista(MouseEvent event) {
        update();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        update();
    }
   
    public void update(){
        try {
            lista = FXCollections.observableArrayList();
            String commandDB = "SELECT * FROM dados";
            if(BD.con == null){
                BD.abrir();
            }
            ResultSet rs = BD.con.createStatement().executeQuery(commandDB);
            
            while(rs.next()){
                ProalcoolDados dados = new ProalcoolDados();
                dados.setAno(rs.getInt("ano"));
                dados.setProdCana(rs.getInt("prodCana"));
                dados.setProdAçucar(rs.getInt("prodAçucar"));
                dados.setProdAlcool(rs.getInt("prodAlcool"));
                dados.setVendaAlcool(rs.getInt("vendaAlcool"));
                dados.setVendaGasolina(rs.getInt("vendaGasolina"));
                lista.add(dados);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        ano1.setCellValueFactory(new PropertyValueFactory<>("ano"));
        prod1.setCellValueFactory(new PropertyValueFactory<>("prodCana"));
        prod2.setCellValueFactory(new PropertyValueFactory<>("prodAçucar"));
        prod3.setCellValueFactory(new PropertyValueFactory<>("prodAlcool"));
        venda1.setCellValueFactory(new PropertyValueFactory<>("vendaAlcool"));
        venda2.setCellValueFactory(new PropertyValueFactory<>("vendaGasolina"));
        tbv.setItems(lista);
        
    }
    
    @FXML
    private void informa (MouseEvent event) {
        Alert inform = new Alert(Alert.AlertType.INFORMATION);
        inform.setTitle("");
        inform.setHeaderText("Informação:");
        inform.setContentText("O Proálcool foi um programa brasileiro que se originou no governo de Ernesto Geisel com o objetivo "
                + "de sanar a necessidade do povo pelo combustível derivado do petróleo que encontrava-se a preços exorbitantes. Para isso, o programa"
                + ", inicialmente, tinha como função o acréscimo de 20% de álcool à gasolina para barateá-la. Não sendo suficiente, no ano de 1979"
                + " surge o primeiro carro movido inteiramente pelo biocombustível da cana-de-açúcar, alterando drasticamente o rumo"
                + " do setor automobilístico da época."
                + "\n\nOs dados referentes à produção da cana encontram-se em toneladas, bem como a produção de açúcar. "
                + "\nO dado referente à produção do álcool está em m³. "
                + "\nPor fim, o 'Carro a álcool' e o 'Carro a gasolina' representam o número de vendas dos automóveis."
                + "\n\nCaso alguma alteração tenha sido feita nas informações expostas, pede-se para que seja pressionado a figura"
                + " ilustrativa do Banco de Dados que fará com que este seja atualizado.");
        inform.show();
    }
}
