<%-- 
    Document   : AltaTerminal
    Created on : 28-abr-2013, 13:23:59
    Author     : Miki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title> Alta terminal telef&oacute;nico </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <meta charset="utf-8">
	
	
	<!-- Stylesheets -->
	<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet'>
	<link rel="stylesheet" href="css/style.css">

    </head>

    <body>
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
        
        <form method="get" action="AltaTerminal" name="datos">
            
            
            <label for="marca">MARCA: </label>
            <input name="marca" type="text">
            <br><br> 
            
            <label for="modelo">MODELO: </label>
            <input name="modelo" type="text">
            <br><br>
            
            <select name="tipo">
                <option value="f" selected>Fijo</option>
                <option value="m">M&oacute;vil</option>
            </select>
            <br><br>
            
            
            <label for="ubicación">Ubicaci&oacute;n: </label>
            <input name="ubicacion" type="text">
            <br><br>

           <input type="submit" value="Crear">

    </body>
</html>
