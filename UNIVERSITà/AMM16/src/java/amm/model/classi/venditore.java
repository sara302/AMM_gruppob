/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model.classi;

import java.util.ArrayList;



/**
 *
 * @author ASSO
 */
public class venditore extends utente {
 protected int num_oggetti;
 protected ArrayList<cofanetti> oggetti_venduti = new ArrayList<cofanetti>(); 

public venditore() {
super();
}

public ArrayList<cofanetti> getOggetti_venduti(){
    return oggetti_venduti;
}

 public void setOggetti_venduti(ArrayList<cofanetti> oggetti_venduti) {
        this.oggetti_venduti=oggetti_venduti;
    }

        
public void setNum_oggetti(int num_oggetti) {
    this.num_oggetti=num_oggetti;
}

public int getNum_oggetti() {
    return num_oggetti;
}

}