<%-- 
    Document   : cliente
    Created on : 5-set-2016, 16.17.28
    Author     : ASSO
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <title>Cofanetti Serie tv - Pagina Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name='keywords' content='serietv, cofanetti, dvd, regali'>
        <meta name='author' content='Sara Concas'>
        <meta name='description' content='Compra-vendita online cofanetti serie tv-Prodotti'>
        <link rel="stylesheet" type="text/css" href="style.css"
 media="screen">
    </head>
    <body>
      <jsp:include page="header.jsp" />
      <jsp:include page="nav.jsp"/>

       <c:choose>
               <c:when test="${accesso.equals('negato')}">
                    <div class="form2">  <h3 class="error">Accesso negato.</h3>
               <h4 class="error"> Pagina riservata ai clienti </h4>  </div>
              </c:when>    
                       
            <c:when test="${accesso.equals('consentito')}">   
                
                  <div class="sidebar">
           
            <h3 id="categorie">Ricerca</h3>
        <ul id="side">
            <li> per titolo </li>
            <li> per categoria </li>
            <li> ecc </li>  
        </ul>
        </div>
                       
                       <div class="content">
       <h3 class="bentornato">Bentornato ${cliente.nome} ${cliente.cognome}!</h3>
        
<div class="saldo"> <h4> Saldo corrente: ${cliente.saldo} euro </h4></div>
      
  

        
        
        <table id="tabella">
           
            <tr>
                <th>Titolo</th>
                <th>Immagine</th>
                <th>Stagione</th>
                <th>Trama</th>
                <th>Pezzi disponibili</th>
                <th>Prezzo(euro)</th>
                <th>Carrello</th>    
            </tr>
            <c:forEach var="oggetto" items="${oggetti}">
            <tr class="disp">
                <td class="tit">${oggetto.titolo}</td>
                <td> <img src="${oggetto.url_immagine}" width="90" height="120"></td>
                <td>${oggetto.stagione}</td>
                <td>${oggetto.trama}</td>
                <td>1</td>
                <td>${oggetto.prezzo}</td>
                <td><form action="cliente_autenticato.html">
                                        <input type="hidden" name="title" value="${oggetto.titolo}" />
                                        <button type="submit" name="Carrello"></button>
                                        </form></td>
            </tr>
            </c:forEach>
        </table>
                       </div>                             
           </c:when>
        
             <c:when test="${accesso.equals('acquisto')}">
                <h2>Riepilogo acquisto</h2>
        
                <ul>
                    <li>Nome prodotto: ${titolo}</li>
                    <li>Prezzo: ${prezzo}</li>
                 
                </ul>

                <form action="cliente.html"
                <input type="hidden" name="objtitle" value="${titolo}" />
                <input type="hidden" name="objprice" value="${prezzo}" />      
                <button type="submit" name="conferma">Acquista</button>
                </form>
            </c:when>
    
             <c:when test="${esito.equals('ok')}">
               
                <h3 class="bentornato">Acquisto effettuato con successo!</h3> 
                
            </c:when>

            <c:when test="${esito.equals('no')}">
                
                <h3 class="bentornato">Operazione non riuscita, saldo insufficiente.</h3>               
            </c:when>                
        </c:choose>
         
    </body>
</html>
