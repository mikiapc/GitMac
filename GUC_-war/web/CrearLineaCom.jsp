<%-- 
    Document   : CrearLineaCom
    Created on : 28-abr-2013, 12:45:59
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Crear l&iacute;nea de comunicaci&oacute;n </title>
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
        <form method="set" action="CrearLineaCom" name="datos">
            <label for="id">N&uacute;mero de la l&iacute;nea: </label>
            <input name="id" type="text">
            <br></br>    
            
            
            
            <select name="operadora">
                <option value="vodafone">Vodafone</option>
                <option value="orange">Orange</option>
                <option value="movistar">Movistar</option>
            </select>     
                <br></br>  
                
                <input type="submit" value="Crear">
            
    </body>
</html>
