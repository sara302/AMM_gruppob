<%-- 
    Document   : nuovo_oggetto
    Created on : 8-set-2016, 19.16.23
    Author     : ASSO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <title>Cofanetti Serie Tv - Aggiungi nuovo prodotto</title>
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
      
      
           <div class="form2">
<h3>Inserisci un nuovo oggetto</h3>
<form method="post" action="nuovo_oggetto.html">
<label for="titolo">Titolo</label>
<input name="titolo" id="nome_ogg" type="text"
       value="Titolo"/>
<label for="stagione">Stagione</label>
<input name="stagione" id="stagione" type="text"
       value="Stagione/i"/>
<label for="genere">Genere</label>
<input name="genere" id="genere" type="text"/>
<label for="imm">Url immagine descrittiva</label>
<input name="imm" id="imm" type="url"/>
<label for="trama">Trama</label>
<textarea rows="5" cols="20" name="trama" id="trama" >Trama serie tv</textarea>
<label for="prezzo">Prezzo(euro)</label>
<input name="prezzo" id="prezzo" type="number"/>
<label for="quantita">Numero oggetti disponibili</label>
<input name="quantita" id="quantita" type="number"/></br></br>
<input type="submit" value="Invia"/>
</form>
</div>
    </body>
</html>
