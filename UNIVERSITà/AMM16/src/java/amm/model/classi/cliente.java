/*
 * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model.classi;
import java.util.ArrayList;

/**
 *
 * @author ASSO
 */
public class cliente extends utente {
    
 protected ArrayList<cofanetti> oggetti_acquistati = new ArrayList<cofanetti>(); 
 protected ArrayList<cofanetti> carrello = new ArrayList<cofanetti>(); 
 
public cliente() {
username="";
password="";
id = 0;
nome = "";
cognome="";
saldo= 0;

}

public ArrayList<cofanetti> getOggetti_acquistati(){
    return oggetti_acquistati;
}

 public void setOggetti_acquistati(ArrayList<cofanetti> oggetti_acquistati) {
        this.oggetti_acquistati=oggetti_acquistati;
    }

 public ArrayList<cofanetti> getCarrello(){
    return carrello;
}

 public void setCarrello(ArrayList<cofanetti> carrello) {
        this.carrello=carrello;
 }


}
