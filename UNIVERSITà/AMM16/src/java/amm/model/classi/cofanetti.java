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
public class cofanetti {
    protected int id;
    public String titolo;
    public String stagione;
    public String trama;
    public String genere;
    public float prezzo;
    public int pezzi;
    public String url_immagine;
    
    public cofanetti ()
    {   
        id = 0;
        titolo = "";
        stagione = "";
        trama= "";
        genere = "";
        prezzo= 0;
        pezzi = 0;
        url_immagine="";
    }        
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getTitolo() {
        return titolo;
    }
    
    public void setTitolo(String titolo){
        this.titolo = titolo;
    }
    
    public String getStagione(){
        return stagione;
    }
    
    public void setStagione (String stagione){
    this.stagione = stagione;
    }
    
     public String getTrama(){
        return trama;
    }
    
    public void setTrama (String trama){
    this.trama = trama;
    }
    
     public String getGenere() {
        return genere;
    }
    
    public void setGenere(String genere){
        this.genere = genere;
    }
     
    
    public float getPrezzo (){
        return prezzo;
    }
    
    public void setPrezzo (float prezzo){
        this.prezzo = prezzo;
    }
    
    public int getPezzi() {
        return pezzi;
    }
    
    public void setPezzi(int pezzi) {
        this.pezzi = pezzi;
    }
     public String getUrl(){
        return url_immagine;
    }
    
    public void setUrl (String url_immagine){
    this.url_immagine = url_immagine;
    }
       
}
