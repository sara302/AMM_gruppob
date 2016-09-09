<%-- 
    Document   : venditore
    Created on : 5-set-2016, 16.27.22
    Author     : ASSO
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <title>Cofanetti Serie Tv - Pagina Venditore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name='keywords' content='serietv, cofanetti, dvd, regali'>
        <meta name='author' content='Sara Concas'>
        <meta name='description' content='Compra-vendita online cofanetti serie tv-Inserimento nuovo prodotto'>
        <link rel="stylesheet" type="text/css" href="style.css"
 media="screen">
    </head>
    <body>
      <jsp:include page="header.jsp" />
      <jsp:include page="nav.jsp"/>
      <c:choose>
       <c:when test="${accesso.equals('no')}">
           <div class="form2">  <h3 class="error">Accesso negato.</h3>
               <h4 class="error"> Pagina riservata ai venditori </h4>  </div>
           
                   </c:when>    
        
           <c:when test="${accesso.equals('sì')}">
  <div class="content">
        <h3 class="bentornato">Bentornato ${venditore.nome} ${nome} ${venditore.cognome} ${cognome}!</h3> 
      
      
        <div class="saldo"> <h4> Saldo corrente: ${venditore.saldo} euro </h4></div>
      
  </div>
                                   <ul class="form2"><h3 class="tit">Operazioni disponibili </h3>
                                     <a href="nuovo_oggetto.html"><li><h4>Inserisci un nuovo oggetto</h4></li></a>
                                     <a href="modifica_oggetto.html"> <li><h4>Modifica un oggetto esistente</h4></li></a>
                                     <a href="elimina_oggetto.html"><li><h4>Elimina un oggetto</h4></li></a>
                                
                                      </ul>
      <div class="sidebar">
        <ul>
            <h4> Il tuoi oggetti in vendita:</h4>
                            <c:forEach var="oggetti" items="${oggetti_venduti}">
                                <li>${oggetti.id} ---  ${oggetti.titolo} ---- ${oggetti.prezzo}</li>
                            </c:forEach>
                        </ul>
      </div>
           </c:when>
             </c:choose> 
    </body>
</html>
