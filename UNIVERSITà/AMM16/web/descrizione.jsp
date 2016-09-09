<%-- 
    Document   : descrizione
    Created on : 5-set-2016, 16.00.07
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
      <jsp:include page="sidebar.jsp"/>
      
       
            <div class="content">
        <p id="descr">Il miglior sito di compra-vendita cofanetti nuovi/usati delle più celebri serie tv, ordinati per genere e per gusto
            dell'autore della pagina. 
           Desideri aquistare? Visita l'elenco dei nostri <a href='cliente.html'>Prodotti</a>.
            Possiedi un cofanetto ma non sei più un appassionato di quella serie? Nessun problema,
            effettua il <a href='login.html'>Login</a> e compila il <a href='venditore.html'>form </a> per aggiungere un nuovo prodotto!
        
        Aquista il cofanetto della tua serie tv preferita, per te o per un amico, 
         il regalo è sempre gradito!</p>
       <div id="elenco">
        <a id='segnalibro0'>
            <h3>Animazione</h3>
           </a>
        <p>Chi dice che le serie animate sono solo per i bambini? Il nostro amato Matt Groening 
            sicuramente non la pensa così!</p>
        <ul>
            <li><a href='cliente.html#simpson'>The Simpsons</a></li>
            <li><a href='cliente.html#americandad'>American Dad</a></li>
            <li><a href='cliente.html#futurama'>Futurama</a></li>
            <li><a href='cliente.html#griffin'>I Griffin</a></li>
            <li><a href='cliente.html#southpark'>South Park</a></li>
        </ul>
       
        <a id="segnalibro1">
            <h3>Comedy</h3>
        </a>
        <p>La vita quotidiana ti stressa? Hai bisogno di farti qualche risata davanti alla tv?
            La nostra sezione comedy è quello che fa per te!
        Che sia tra le corsie d'ospedale di Scrubs o in casa con Modern Family, il divertimento
        è assicurato!</p>
        <ul>
            <li><a href='cliente.html#scrubs'>Scrubs</a></li>
            <li><a href='cliente.html#modernfamily'>Modern Family</a></li>
            <li><a href='cliente.html#friends'>Friends</a></li>
            <li><a href='cliente.html#bbtheory'>The Big Bang Theory</a></li>
            <li><a href='cliente.html#willegrace'>Will & Grace</a></li>
        </ul>
        
        
       <a id='segnalibro2'>
        <h3>Crime</h3>
        </a>
        <p>Se ami il mondo della criminologia, le aule di tribunale e le menti contorte
            di spietati assassini questa è proprio la sezione che fa al caso tuo!</p>
        <ul>
            <li><a href='cliente.html#coldcase'>Cold Case</a></li>
            <li><a href='cliente.html#brba'>Breaking Bad</a></li>
            <li><a href='cliente.html#criminalminds'>Criminal Minds</a></li>
            <li><a href='cliente.html#csi'>CSI: Crime Scene Investigation</a></li>
            <li><a href='cliente.html#regoledelittoperfetto'>Le regole del delitto perfetto</a></li>
        </ul>
        
      
        <a id='segnalibro3'>
            <h3>Fantascienza</h3>
        </a>
        <p>Galassie lontane, robot, mondi paralleli e tanto altro in questa avveniristica sezione </p>
            <ul>
                <li><a href='cliente.html#startrek'>Star Trek</a></li>
                <li><a href='cliente.html#battgalactica'>Battlestar Galactica</a></li>
                <li><a href='cliente.html#doctorwho'>Doctor Who</a></li>
                <li><a href='cliente.html#lost'>Lost</a></li>
                <li><a href='cliente.html#supercar'>SuperCar</a></li>
            </ul>
            
     
     <a id='segnalibro4'>
         <h3>Horror</h3>
     </a>
     
        <p> Streghe, vampiri e mostri spaventosi...Preparati a tremare di paura in questa sezione.</p>
     <ul>
         <li><a href='cliente.html#thewalkingdead'>The Walking Dead</a></li>
         <li><a href='cliente.html#buffy'>Buffy l'Ammazza Vampiri</a></li>
         <li><a href='cliente.html#americanhorror'>American Horror Story</a></li>
         <li><a href='cliente.html#trueblood'>True Blood</a></li>
         <li><a href='cliente.html#grimm'>Grimm</a></li>
     </ul>

<a id='segnalibro5'>
    <h3>Medical Drama</h3>
</a>
        <p> Il meglio delle serie tv ambientate tra le corsie d'ospedale. </p>
<ul>
    <li><a href='cliente.html#er'>E.R. Medici in prima linea</a></li>
    <li><a href='cliente.html#drhouse'>Dr. House Medical Division</a></li>
    <li><a href='cliente.html#greysanatomy'>Grey's Anatomy</a></li>
    <li><a href='cliente.html#privatepractice'>Private Practice</a></li>
    <li><a href='cliente.html#theknick'>The Knick</a></li>    
</ul>  
<a id='segnalibro6'>
    <h3>Teen Drama</h3>
</a>
    <p>Amori tra i banchi di scuola, risse nei corridoi del liceo, mamme ingombranti, amicizie...
        Questo variopinto genere è indirizzato ad un pubblico giovane ma da sempre conmquista 
        spettatori di tutte le età.</p>
    <ul>
        <li><a href='cliente.html#beverlyhills'>Beverly Hills 90210</a></li>
        <li><a href='cliente.html#unamammaperamica'>Una mamma per amica</a></li>
        <li><a href='cliente.html#onetreehill'>One Tree Hill</a></li>
        <li><a href='cliente.html#gossipgirl'>Gossip Girl</a></li>
        <li><a href='cliente.html#theoc'>The OC</a></li>

    </ul>
        </div>
            </div>
    </body>
</html>
