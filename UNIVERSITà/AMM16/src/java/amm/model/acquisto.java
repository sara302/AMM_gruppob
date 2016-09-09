
 
 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model;
import amm.model.classi.Cofanetti_Factory;
import amm.model.classi.Utenti_Factory;
import amm.model.classi.utente;
import amm.model.classi.cofanetti;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "acquisto", urlPatterns = {"/cliente.html"})
public class acquisto extends HttpServlet {
    
    
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
         HttpSession session = request.getSession(false); 
                                
            
          if(session.getAttribute("loggedIn").equals(true) && session.getAttribute("utente").equals("cliente")){
               session.setAttribute("accesso","consentito");
               
                   
                     ArrayList<cofanetti> lista = Cofanetti_Factory.getInstance().getCofanetti();
                   request.setAttribute("oggetti", lista); 
            } else {
                session.setAttribute("accesso","negato");
          }
          request.getRequestDispatcher("cliente.jsp").forward(request,response);        
                    
        
         
        
        if(request.getParameter("Acquista") != null){
            
                Boolean ok = false;
            
                String titolo = request.getParameter("titolo");
                float prezzo = Integer.parseInt(request.getParameter("prezzo"));
                int id_cliente = (Integer) session.getAttribute("id");
                float saldo = Utenti_Factory.getInstance().getSaldoCliente(id_cliente);
                int id_oggetto = Cofanetti_Factory.getInstance().getCofanettobyTitolo(titolo);               
                int id_venditore = Utenti_Factory.getInstance().getVenditorebyCofanetto(id_oggetto);
            
            if(saldo > prezzo){                
                try {
                    ok = Cofanetti_Factory.getInstance().compravendita(titolo, prezzo, id_cliente, id_venditore);
                    session.setAttribute("esito","ok");
                    session.setAttribute("accesso",null);
                    
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                    session.setAttribute("esito","no");
                    session.setAttribute("accesso",null);
                    
            }
            
        } else {
                if(request.getParameter("Carrello") != null){
                    String title = request.getParameter("title");

                    ArrayList<cofanetti> listaCofanetti = Cofanetti_Factory.getInstance().getCofanetti();
                    for(cofanetti c : listaCofanetti){
                        if(c.getTitolo().equals(title)){
                            request.setAttribute("titolo", c.titolo);
                            request.setAttribute("prezzo", c.prezzo);  
                           
                        }
                    }
                    
                    session.setAttribute("accesso","acquisto");
                } 
        }

        request.getRequestDispatcher("cliente.jsp").forward(request,response);        
    
        
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}