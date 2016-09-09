/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model.classi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ASSO
 */
public class Cofanetti_Factory {
    
     private String connectionString;
   
   private static Cofanetti_Factory item;
    public static Cofanetti_Factory getInstance() {
        if (item == null) {
            item = new Cofanetti_Factory();
        }
        return item;
    }
    
        
     private ArrayList<cofanetti> listaCofanetti = new ArrayList<cofanetti>();
    
    
    
    
    private Cofanetti_Factory() {

    }
        
        //Metodi
        
        // Restituisce la lista di tutti i cofanetti
    public ArrayList<cofanetti> getCofanetti()
    {
        ArrayList<cofanetti> listaCofanetti = new ArrayList<cofanetti>();
        try 
        {
            
            Connection conn = DriverManager.getConnection(connectionString, "asso302", "sassola303");
           
            String query = "select * from cofanetto";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                cofanetti cofanetto = new cofanetti();
                cofanetto.setId(set.getInt("id"));
                cofanetto.setTitolo(set.getString("titolo"));
                cofanetto.setStagione(set.getString("stagione"));
                cofanetto.setTrama(set.getString("trama"));
                cofanetto.setGenere(set.getString("genere"));
                cofanetto.setUrl(set.getString("url_immagine"));
                cofanetto.setPezzi(set.getInt("pezzi"));
                cofanetto.setPrezzo(set.getFloat("prezzo"));
                listaCofanetti.add(cofanetto);
            }
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaCofanetti;
    }
    
     // Dato un id restituisce il cofanetto, se non esiste restituisce null
    public cofanetti getCofanettoById(int id)
    {
        try 
        {
          
            Connection conn = DriverManager.getConnection(connectionString, "asso302", "sassola303");
            String query = "select * from cofanetto "
            + "where id =?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                cofanetti current = new cofanetti();
                current.setId(res.getInt("id"));
                current.setTitolo(res.getString("titolo"));
                current.setStagione(res.getString("stagione"));
                current.setTrama(res.getString("trama"));
                current.setGenere(res.getString("genere"));
                current.setPezzi(res.getInt("pezzi"));
                current.setPrezzo(res.getFloat("prezzo"));
   
                stmt.close();
                conn.close();
                return current;
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
        
     public int getCofanettobyTitolo(String titolo){
        
        int id = 0;
            
        try {
            Connection conn = DriverManager.getConnection(connectionString, "asso302", "sassola303");
            
            String query = "SELECT id FROM cofanetto WHERE titolo = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, titolo);
            
            ResultSet set = stmt.executeQuery();
            
            if(set.next()){
                id = set.getInt("id");
            }
            
            stmt.close();
            conn.close();
        } catch(SQLException e){
            
        }
        
        return id;
    }



public boolean compravendita (String titolo, float prezzo, int id_cliente, int id_venditore) throws SQLException{
        Boolean result = false;
        
        Connection conn = DriverManager.getConnection(connectionString, "asso302", "sassola303");
        
        PreparedStatement delete = null;
        PreparedStatement decr = null;
        PreparedStatement incr = null;
        
        String cancella = "DELETE FROM cofanetto WHERE titolo = ?";
        String decrementa = "UPDATE cliente SET saldo = saldo - ? WHERE id= ? ";
        String incrementa = "UPDATE venditore SET saldo = saldo - ? WHERE id= ?";
        
        try {
            conn.setAutoCommit(false);
            
            delete = conn.prepareStatement(cancella);
            decr = conn.prepareStatement(decrementa);
            incr= conn.prepareStatement(incrementa);
            
            delete.setString(1,titolo);
            
            decr.setFloat(1,prezzo);
            decr.setInt(2,id_cliente);
            
            incr.setFloat(1,prezzo);
            incr.setInt(2,id_venditore);
            
            int q1 = delete.executeUpdate();
            int q2 = decr.executeUpdate();
            int q3 = incr.executeUpdate();
            
            if( q1 != 1 || q2 != 1 || q3 != 1){
                conn.rollback();
            } else {result = true;}
            
            conn.commit();
            
        } catch(SQLException e){
            try{
                conn.rollback();
            }catch(SQLException e2){
                
            }            
        } finally {
            if(delete != null){
                delete.close();
            }
            
            if(decr!= null){
                decr.close();
            }
            
            if(incr!= null){
                incr.close();
            }
            
            conn.setAutoCommit(true);
            conn.close();     
        }
        
        return result;
    }      
    

 public cofanetti nuovo (String titolo, String stagione, String genere, String imm, String trama, float prezzo, int quantita){
        
        cofanetti oggetto = new cofanetti();
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "asso302", "sassola303");
            
            PreparedStatement stmt = null;
            
            String query = "INSERT INTO cofanetto  (id, genere, titolo, stagione, trama, prezzo, num_pezzi, url_immagine) VALUES (default,?,?,?,?,?,?,?)";            
                  
            stmt = conn.prepareStatement(query);
            
            conn.commit();
            
            stmt.setString(1,genere);
            stmt.setString(2,titolo);
            stmt.setString(3,stagione);
            stmt.setString(4,trama);
            stmt.setFloat(5, prezzo);
            stmt.setInt(6,quantita);
            stmt.setString(7,imm);
            
            int r = stmt.executeUpdate();
            
            if(r==1){
                System.out.println("ok");
                oggetto.setGenere(genere);
                oggetto.setTitolo(titolo);
                oggetto.setStagione(stagione);
                oggetto.setTrama(trama);
                oggetto.setPrezzo(prezzo);
                oggetto.setPezzi(quantita);
                oggetto.setUrl(imm);
            }
            
            stmt.close();
            conn.close();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return oggetto;
    }


 public cofanetti modifica (int id, String titolo, String stagione, String genere, String imm, String trama, float prezzo, int quantita){
        
        cofanetti oggetto = new cofanetti();
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "asso302", "sassola303");
            
            PreparedStatement stmt = null;
            
            String query = "UPDATE cofanetto SET genere = ?, stagione = ?, trama = ?,"+
                    "prezzo = ?, num_pezzi = ?, url_immagine = ? WHERE id = ?";            
                  
            stmt = conn.prepareStatement(query);
            
            conn.commit();
            
            stmt.setString(1,genere);
       stmt.setString(2,titolo);
            stmt.setString(3,stagione);
            stmt.setString(4,trama);
            stmt.setFloat(5, prezzo);
            stmt.setInt(6,quantita);
            stmt.setString(7,imm);
            stmt.setInt(8,id);
            
            int r = stmt.executeUpdate();
            
            if(r==1){
                System.out.println("ok");
                oggetto.setId(id);
                oggetto.setGenere(genere);
                oggetto.setTitolo(titolo);
                oggetto.setStagione(stagione);
                oggetto.setTrama(trama);
                oggetto.setPrezzo(prezzo);
                oggetto.setPezzi(quantita);
                oggetto.setUrl(imm);
            }
            
            stmt.close();
            conn.close();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return oggetto;
    }

  public void elimina (int id){
        
        try{
            Connection conn = DriverManager.getConnection(connectionString, "asso302", "sassola303");
            
            String query = "DELETE FROM cofanetto WHERE id = ? ";
            
            
            PreparedStatement stmt = conn.prepareStatement(query);
           
            
            stmt.setInt(1,id);
           
            
            int r = stmt.executeUpdate();
          
            
            if(r==1){
                System.out.println("Ok!");
            } 
            
           
            
            
            stmt.close();
            
            conn.close();
                       
        } catch(SQLException e){
            e.printStackTrace();
        }
    
  }
  
   public ArrayList<cofanetti> getCofanettibyVenditore(int id_venditore){
       ArrayList<cofanetti> lista = new ArrayList<cofanetti>();
        try 
        {
            
            Connection conn = DriverManager.getConnection(connectionString, "asso302", "sassola303");
         
            String query = "select *" +
                            "from cofanetto" +
                           "where cofanetto.id in (" +
                             "select idCofanetto" +
                          "from cofanetti_venditori" +
                            "where idVenditore= ?)";
          
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id_venditore);
            ResultSet set = stmt.executeQuery(query);
            
             while(set.next()) 
            {
                cofanetti current = new cofanetti();
                current.setId(set.getInt("id"));
                current.setTitolo(set.getString("titolo"));
                 current.setStagione(set.getString("stagione"));
                  current.setTrama(set.getString("trama"));
                current.setPrezzo(set.getFloat("prezzo"));
                current.setPezzi(set.getInt("num_pezzi"));
                 current.setUrl(set.getString("url_immagine"));
             
                lista.add(current);
            } 
            
    stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return lista;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  




    // ConnectionString
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
}
    
    
    
    
    
    

