/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model;
import amm.model.classi.Cofanetti_Factory;

import amm.model.classi.venditore;

import amm.model.classi.Utenti_Factory;
import amm.model.classi.cofanetti;

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
@WebServlet(name = "Venditore", urlPatterns = {"/venditore.html"})
public class Venditore extends HttpServlet {

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
     



          if(session.getAttribute("loggedIn").equals(true) && session.getAttribute("utente").equals("venditore")){
               session.setAttribute("accesso","sì");
               request.getAttribute("venditore");
               int id_venditore = (Integer) session.getAttribute("id");
               
         
           
                     ArrayList<cofanetti> lista = Cofanetti_Factory.getInstance().getCofanettibyVenditore(id_venditore);
                   request.setAttribute("oggetti", lista); 
            } else {
                session.setAttribute("accesso","no");
          }
          request.getRequestDispatcher("venditore.jsp").forward(request,response);        
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
    }

    }
