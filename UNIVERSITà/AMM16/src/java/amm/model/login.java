/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model;

import amm.model.classi.utente;
import amm.model.classi.venditore;
import amm.model.classi.Utenti_Factory;
import amm.model.classi.Cofanetti_Factory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASSO
 */
@WebServlet(name = "login", urlPatterns = {"/login.html"}, loadOnStartup = 0)
public class login extends HttpServlet{
    
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db1/ammdb1";
    private static final String DB_BUILD_PATH = "WEB-INF/db1/ammdb1";
    
    @Override 
    public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        Utenti_Factory.getInstance().setConnectionString(dbConnection);
        Cofanetti_Factory.getInstance().setConnectionString(dbConnection);
    }
 
 
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
      
     HttpSession session = request.getSession(true);
        
        if(request.getParameter("Submit") != null)
        {
            String username = request.getParameter("Username");
            String password = request.getParameter("Password");
            
            utente u = Utenti_Factory.getInstance().getUtente(username, password);
        
            if(u != null)
            {
                session.setAttribute("loggedIn", true);
                session.setAttribute("id", u.getId());
                
                
                
                if(u instanceof venditore) 
                {
                   session.setAttribute("utente", "venditore");
                   
                   session.setAttribute("venditore", u);
               
                    request.getRequestDispatcher("venditore.html").forward(request, response);
                    
                }
                
                 else
                {
                   session.setAttribute("utente", "cliente");
                   session.setAttribute("cliente", u);
                   
                    request.getRequestDispatcher("cliente.html").forward(request, response);  
                }    
                
                
            } else { 
                
                 session.setAttribute("loggedIn", false);
            }
            
             if(session.getAttribute("loggedIn").equals(false)){      
       request.getRequestDispatcher("login_error.jsp").forward(request, response);
    }
             
        } else {  
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } 
    }
  
            
            
            @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
   
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
 // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
  
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
   
}