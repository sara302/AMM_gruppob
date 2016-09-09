<%-- 
    Document   : login
    Created on : 5-set-2016, 16.13.59
    Author     : ASSO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login-Error</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name='keywords' content='login,serietv, cofanetti, dvd, regali'>
        <meta name='author' content='Sara Concas'>
        <meta name='description' content='Compra-vendita online cofanetti serie tv-Effettua login'>
         <link rel="stylesheet" type="text/css" href="style.css"
 media="screen">
    </head>
    <body>
        <jsp:include page="header.jsp" />
      <jsp:include page="nav.jsp"/>
      <div class="content">
          <h4 class="error">Errore di autenticazione. Riprova: </h4>
      </div>
      
      <div class="form">
        <h2 class="log">Login</h2>
            <form method="post" action="login.html">
                  <input type="hidden" name="cmd" value="login">
                
                  <label id="ut" for="nomeutente">Nome Utente</label>
                <input type="text" name="Username" id="nomeutente"/>
               <label id="pss" for="pw">Password</label>
                 <input type="password" id="pw" name="Password" value="password"/>
                
                 <p>  <button id="but" type="submit" name="Submit" value="login">Accedi</button> </p>
            </form>
        </div>   
      
    </body>
</html>
