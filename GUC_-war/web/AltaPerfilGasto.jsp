<%-- 
    Document   : AltaPerfil
    Created on : 27-abr-2013, 19:11:50
    Author     : Juan R
--%>

<html>
    <head>
        <title> Alta Perfil De Gasto </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <meta charset="utf-8">
	
	
	<!-- Stylesheets -->
	<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet'>
	<link rel="stylesheet" href="css/style.css">

    </head>
    <body>
        <!-- TOP BAR -->
	<div id="top-bar">
		
		<div class="page-full-width strong em">
                    <a href="#" id="company-branding" class="fl"><img src="images/logo_DIPUTACION.jpg"/></a>
                    <div id="cabz">
                    <h1>Diputación provincial de Málaga
                        <br>Área de modernización local
                        <br>Servicio de tecnologías de la información</h1>
                    </div>
                    
                    <%--<a href="#" class="round button dark ic-left-arrow image-left ">Return to website</a>--%>
                        

		</div> <!-- end full-width -->	
	
	</div> <!-- end top-bar -->
        <br><br>
        <form method="get" action="AltaPerfil" name="datos">
            <label for="idperfil">Perfil de Gasto</label>
            <input name="idperfil" type="text">
            <br><br>
            
            <label for="gasto">Gasto</label>
            <input name ="gasto" type="text">
            <br><br>
           
            
        <input type="submit" class="button round blue">
    </body>
</html>
