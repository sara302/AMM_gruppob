<%-- 
    Document   : elimina_oggetto
    Created on : 8-set-2016, 23.28.02
    Author     : ASSO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <title>Cofanetti Serie Tv - Elimina prodotto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name='keywords' content='serietv, cofanetti, dvd, regali'>
        <meta name='author' content='Sara Concas'>
        <meta name='description' content='Compra-vendita online cofanetti serie tv-Inserimento nuovo prodotto'>
        <link rel="stylesheet" type="text/css" href="style.css"
 media="screen">
    </head>
    <body>
       <jsp:include page="header.jsp"/>
         <jsp:include page="nav.jsp"/>
        
        <div class="form2">
<h3>Elimina oggetto esistente</h3>
<form method="post" action="elimina_oggetto.html">

<label for="id">Id prodotto</label>
<input name="id" id="id" type="text"/></br></br>
<input type="submit" value="Elimina"/>
</form>
</div>
    </body>
</html>
