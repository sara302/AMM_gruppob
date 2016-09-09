/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model;
import amm.model.classi.cofanetti;
import amm.model.classi.Cofanetti_Factory;
import amm.model.classi.Utenti_Factory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
/**
 *
 * @author ASSO
 */
@WebServlet(name = "inserimento", urlPatterns = {"/nuovo_oggetto.html"})
public class inserimento extends HttpServlet {

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
        if(request.getParameter("Invia") == null){
            
            request.getRequestDispatcher("nuovo_oggetto.jsp").forward(request, response);
        }
        
    else if(request.getParameter("Invia") != null){
            String titolo = request.getParameter("titolo");
            String stagione = request.getParameter("stagione");
             String genere = request.getParameter("genere");
            String imm = request.getParameter("imm");
            String trama = request.getParameter("trama");
            float prezzo = Integer.parseInt(request.getParameter("prezzo"));
            int quantita = Integer.parseInt(request.getParameter("quantita"));

           cofanetti oggetto = Cofanetti_Factory.getInstance().nuovo(titolo, stagione, genere, imm, trama, prezzo, quantita);

            request.setAttribute("titolo", oggetto.titolo);
            request.setAttribute("imm", oggetto.url_immagine);
           request.setAttribute("stagione", oggetto.stagione);
           request.setAttribute("genere", oggetto.genere);
           request.setAttribute("trama", oggetto.trama);
             request.setAttribute("quantita", oggetto.pezzi);
            request.setAttribute("prezzo", oggetto.prezzo);  

            request.getRequestDispatcher("inserimento_riuscito.jsp").forward(request, response);
        }
    
    
    
    
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
