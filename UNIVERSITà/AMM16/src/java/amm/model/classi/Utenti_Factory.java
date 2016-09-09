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
public class Utenti_Factory {
    
    private String connectionString;
   
   private static Utenti_Factory utente;
    public static Utenti_Factory getInstance() {
        if (utente == null) {
            utente = new Utenti_Factory();
        }
        return utente;
    }



private Utenti_Factory() {

    }


public utente getUtente(String username, String password)
    {
        try
        {
            Connection conn = DriverManager.getConnection(connectionString,"asso302","sassola303");




           String query = "select * from venditore where  username = ? and password = ? ";
            PreparedStatement stmt = conn.prepareStatement(query);
           
            stmt.setString(1 ,username);
            stmt.setString(2 ,password);
            
            ResultSet set = stmt.executeQuery();
            
            if(set.next())
            {
                venditore Venditore = new venditore();
                Venditore.id = set.getInt("id");
                Venditore.nome = set.getString("nome");
                Venditore.cognome = set.getString("cognome");
                Venditore.username = set.getString("username");
                Venditore.password = set.getString("password");
                Venditore.saldo = set.getInt("saldo");
                
               
               
              
            
                stmt.close();
                conn.close();
                
                return Venditore;
            }
            
                                
         query = "select * from cliente where username = ? and password = ?";
            stmt = conn.prepareStatement(query);
            
            stmt.setString(1, username);
            stmt.setString(2, password);
           
            set = stmt.executeQuery();
            
            if(set.next())
            {
                cliente Cliente = new cliente();
                Cliente.id = set.getInt("id");
                Cliente.nome = set.getString("nome");
                Cliente.cognome = set.getString("cognome");
                Cliente.username = set.getString("username");
                Cliente.password = set.getString("password");
                Cliente.saldo = set.getInt("saldo");

             
                stmt.close();
                conn.close();
                
                return Cliente;
            }
            
            stmt.close();
          
        }
        catch(SQLException e)
        {
            
        }
        return null;
}
//Dato un certo id, restituire il relativo venditore. Se non esiste un venditore con
//quell'id, restituire null
 
public utente getVenditore(int id)
    {
        try 
        {
            
            Connection conn = DriverManager.getConnection(connectionString, "asso302", "sassola303");
           
            String query = "select * from venditore "
            + "where id = ?";
           
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id);
            
            ResultSet res = stmt.executeQuery();
            
      if(res.next()) 
            {
                venditore current = new venditore();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setSaldo(res.getInt("saldo"));
                
                // cofanetti venduti
                query = "SELECT idCofanetto,titolo"
                        + "FROM cofanetti_venditori, cofanetto, venditore "
                        + "WHERE idCofanetto=cofanetto.id AND  "
                        + "idVenditore="+current.getId();
                Statement st = conn.createStatement();
                ResultSet res2 = st.executeQuery(query);
           
                while(res2.next())
                {
                    cofanetti c = new cofanetti();
                    c.setId(res2.getInt("id"));
                    c.setTitolo(res2.getString("titolo"));
                    current.oggetti_venduti.add(c);
                }           
       st.close();
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
    
 //Metodo che restituisce una lista di tutti i venditori
 
 public ArrayList<venditore> getVenditori()
    {
        ArrayList<venditore> listaVenditori = new ArrayList<venditore>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "asso302", "sassola303");
            Statement stmt = conn.createStatement();
            String query = "select * "
                    +"from venditore";
         
            ResultSet set = stmt.executeQuery(query);
            
             while(set.next()) 
            {
                venditore current = new venditore();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setCognome(set.getString("cognome"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                current.setSaldo(set.getInt("saldo"));
                listaVenditori.add(current);
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaVenditori;
    }         

//Dato un certo id, restituire il relativo cliente. Se non esiste un cliente con
//quell'id, restituire null
 
public utente getCliente(int id)
    {
        try 
        {
            
            Connection conn = DriverManager.getConnection(connectionString, "asso302", "sassola303");
           
            String query = "select * from cliente "
            + "where id = ?";
           
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id);
            
            ResultSet res = stmt.executeQuery();
            
      if(res.next()) 
            {
                cliente current = new cliente();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setSaldo(res.getInt("saldo"));
                
                // cofanetti acquistati
                query = "SELECT idCofanetto,titolo"
                        + "FROM cofanetti_acquistati, cofanetto,cliente"
                        + "WHERE idCofanetto=cofanetto.id AND  "
                        + "idCliente="+current.getId();
                Statement st = conn.createStatement();
                ResultSet res2 = st.executeQuery(query);
           
                while(res2.next())
                {
                    cofanetti c = new cofanetti();
                    c.setId(res2.getInt("id"));
                    c.setTitolo(res2.getString("titolo"));
                    current.oggetti_acquistati.add(c);
                }           
       st.close();
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
    
 //Metodo che restituisce una lista di tutti i clienti
 
 public ArrayList<cliente> getClienti()
    {
        ArrayList<cliente> listaClienti = new ArrayList<cliente>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "asso302", "sassola303");
            Statement stmt = conn.createStatement();
            String query = "select * "
                    +"from cliente";
         
            ResultSet set = stmt.executeQuery(query);
            
             while(set.next()) 
            {
                cliente current = new cliente();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setCognome(set.getString("cognome"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                current.setSaldo(set.getInt("saldo"));
                listaClienti.add(current);
            } 
            
    stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaClienti;
    }         
   
  public int getClientebyCofanetto(int id_cofanetto){
        int id_cliente = 0;
        
        try{    
            Connection conn = DriverManager.getConnection(connectionString, "asso302", "sassola303");
                        
            String query = "select idCliente from cofanetti_acquistati where idCofanetto = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id_cofanetto);
            
            ResultSet set = stmt.executeQuery();
            
            if(set.next()){
                id_cliente = set.getInt("idCliente");
            }
        } catch(SQLException e){
            
        }
        
        return id_cliente;
    }
    
  public int getVenditorebyCofanetto(int id_cofanetto){
        int id_venditore = 0;
        
        try{    
            Connection conn = DriverManager.getConnection(connectionString, "asso302", "sassola303");
                        
            String query = "select idVenditore from cofanetti_venditori where idCofanetto = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id_cofanetto);
            
            ResultSet set = stmt.executeQuery();
            
            if(set.next()){
                id_venditore = set.getInt("idVenditore");
            }
        } catch(SQLException e){
            
        }
        
        return id_venditore;
        
        }
  
 
  
   public float getSaldoCliente(int id_cliente){
        float saldo = 0;
        
        try{    
            Connection conn = DriverManager.getConnection(connectionString, "asso302", "sassola303");
                        
            String query = "select saldo from cliente where id= ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id_cliente);
            
            ResultSet set = stmt.executeQuery();
            
            if(set.next()){
                saldo = set.getFloat("saldo");
            }
        } catch(SQLException e){
            
        }
        
        return saldo;
    }
   
   public ArrayList<cofanetti> getCofanetti()
    {
        ArrayList<cofanetti> lista = new ArrayList<cofanetti>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "asso302", "sassola303");
            Statement stmt = conn.createStatement();
            String query = "select * from cofanetto'";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                cofanetti current = new cofanetti();
                current.setId(set.getInt("id"));
                current.setGenere(set.getString("genere"));
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
 

        