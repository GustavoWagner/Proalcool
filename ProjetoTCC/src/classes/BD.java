package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BD {
    
    public static Connection con;
    
    public static void abrir(){
        String connectionString = "jdbc:mysql://127.0.0.1:3306/proalcool";
        
        try{
            con = DriverManager.getConnection(connectionString, "root", "");
            criarTabela();
        }catch(SQLException e){
            System.out.println("ERRO DE CONEXÃO");
        }
    }
    
    public static void criarTabela(){
        try{
            PreparedStatement stm = con.prepareStatement("CREATE TABLE IF NOT EXISTS `dados` (`ano` INT,"
                    + " `prodCana` INT, `prodAçucar` INT, `prodAlcool` INT, `vendaAlcool` INT, `vendaGasolina` INT);");
            stm.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static boolean contains(int ano) throws SQLException{
        PreparedStatement st = con.prepareStatement("SELECT * FROM dados");
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            if(ano == rs.getInt("ano")){
                return true;
            }   
        }
        return false;
    }
    
}