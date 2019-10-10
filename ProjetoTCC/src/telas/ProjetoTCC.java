package telas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ProjetoTCC extends Application {
    public static Stage  st;
    public static Scene  scene;
    public static Scene  dadosScene;
    public static Scene  addLoginScene;
    public static Scene  addCadastrarScene;
    public static Scene  graphicScene;
    public static Scene  infoScene;
    public static Parent dados;
    public static Parent droot;
    public static Parent login;
    public static Parent cadastrar;
    public static Parent info;
    public static Parent graphic;
    @Override
    public void start(Stage stage) throws Exception {
        
        st = stage;
        
        droot     = FXMLLoader.load(getClass().getResource("Inicio.fxml"));
        dados     = FXMLLoader.load(getClass().getResource("Dados.fxml"));
        login     = FXMLLoader.load(getClass().getResource("Login.fxml"));
        cadastrar = FXMLLoader.load(getClass().getResource("Cadastrar.fxml"));
        info      = FXMLLoader.load(getClass().getResource("Info.fxml"));
        graphic   = FXMLLoader.load(getClass().getResource("Text.fxml"));
        stage.setTitle("Entrada");
        scene             = new Scene (droot);
        dadosScene        = new Scene (dados);
        addLoginScene     = new Scene (login);
        addCadastrarScene = new Scene (cadastrar);
        infoScene         = new Scene (info);
        graphicScene      = new Scene(graphic);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void changeScene(String s) { // mudança de cena.
        switch (s) {
            case "entrada": // escolha entre login e visualização de dados.
                st.setScene(scene);
                st.show();
                break;
            case "dados": //    
                    st.setTitle("Proálcool");
                    st.setScene(dadosScene);                 
                    st.centerOnScreen(); //centralizar
                    st.show();
                    break;
            case "login":
                    st.setTitle("Novos dados");
                    st.setScene(addLoginScene);
                    st.centerOnScreen();
                    st.show();
                    break;
            case "cadastrar":
                    st.setTitle("Edição dos dados");
                    st.setScene(addCadastrarScene);
                    st.centerOnScreen();
                    st.show();
                    break;
            case "info":
                    st.setTitle("Info dos Dados");
                    st.setScene(infoScene);
                    st.centerOnScreen();
                    st.show();
                break;
            case "graphic":
                    st.setTitle("Gráfico");
                    st.setScene(graphicScene);
                    st.centerOnScreen();
                    st.show();
            }
        }
    public static Stage getStage() {
       return st;
    }
}   