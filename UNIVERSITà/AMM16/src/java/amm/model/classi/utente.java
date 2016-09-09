/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model.classi;

/**
 *
 * @author ASSO
 */
public class utente {
    public int id;
    protected String username;
    protected String password;
    public String nome;
    public String cognome;
    public float saldo;
    
    
//costruttore
public utente() 
{
id = 0;
username="";
password="";
nome = "";
cognome="";
saldo = 0;
}

//metodi relativi alla classe

public String getUsername() {
    return username;
}

public void setUsername(String username){
    this.username = username;
}

public String getPassword() {
    return password;
}

public void setPassword(String password){
    this.password = password;
   
}

public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

public String getNome() {
    return nome;
}

public void setNome(String nome){
    this.nome = nome;
   
}

public String getCognome(){
    return cognome;
}

public void setCognome(String cognome){
    this.cognome = cognome;
}

public float getSaldo(){
    return saldo;
   }
public void setSaldo(float saldo){
    this.saldo= saldo;
}
}
