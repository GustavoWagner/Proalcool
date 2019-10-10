package classes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ProalcoolDados {

    private final IntegerProperty ano = new SimpleIntegerProperty();
    private final IntegerProperty prodCana = new SimpleIntegerProperty();
    private final IntegerProperty prodAçucar = new SimpleIntegerProperty();
    private final IntegerProperty prodAlcool = new SimpleIntegerProperty();
    private final IntegerProperty vendaAlcool = new SimpleIntegerProperty();
    private final IntegerProperty vendaGasolina = new SimpleIntegerProperty();

    public int getProdAçucar() {
        return prodAçucar.get();
    }
    
    public void setProdAçucar(int value) {
        prodAçucar.set(value);
    }
    
    public IntegerProperty prodAçucarProperty(){
        return prodAçucar;
    }
    
    public int getVendaGasolina() {
        return vendaGasolina.get();
    }

    public void setVendaGasolina(int value) {
        vendaGasolina.set(value);
    }

    public IntegerProperty vendaGasolinaProperty() {
        return vendaGasolina;
    }
    
    public int getVendaAlcool() {
        return vendaAlcool.get();
    }

    public void setVendaAlcool(int value) {
        vendaAlcool.set(value);
    }

    public IntegerProperty vendaAlcoolProperty() {
        return vendaAlcool;
    }
    
    public int getProdCana() {
        return prodCana.get();
    }
    
    public void setProdCana(int value) {
        prodCana.set(value);
    }
    
    public IntegerProperty prodCanaProperty(){
        return prodCana;
    }
    
    public int getProdAlcool() {
        return prodAlcool.get();
    }
    
    public void setProdAlcool(int value) {
        prodAlcool.set(value);
    }
    
    public IntegerProperty prodAlcoolProperty(){
        return prodAlcool;
    }

    public int getAno() {
        return ano.get();
    }

    public void setAno(int value) {
        ano.set(value);
    }

    public IntegerProperty anoProperty() {
        return ano;
    }
    
    
}
