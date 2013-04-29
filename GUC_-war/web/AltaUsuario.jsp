<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->

<!DOCTYPE html>
<html>
    <head>
        <title> Alta Usuario </title>
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
        <form method="get" action="AltaUsuario" name="datos">
            <label for="nombre">nombre</label>
            <input name="nombre" type="text">
            <br><br>
            
            <label for="apellidos">apellidos</label>
            <input name ="apellidos" type="text">
            <br><br>
            
            <label for="nif">nif</label>
            <input name="nif" type="text">
            <br><br>
           
            <label for="email">correo electr&oacute;nico</label>
            <input name="email" type="text">
            <br><br>
            
            <label for="direccion">direcci&oacute;n</label>
            <input name="direccion" type="text">
            <br><br>
            
            <label for="telefono">tel&eacute;fono</label>
            <input name="telefono" type="text">
            <br><br>
                
            <label for="publicable">publicable</label>
            <input name="publicable" value="si" type="radio"> S&iacute;
            <input name="publicable" value="no" type="radio"> No
            <br><br>
            
            <label for="rol">rol</label>
            <select name="rol">
                <option> Administrador </option>
                <option> Controlador diputaci&oacute;n</option>
                <option> Controlador ayuntamiento </option>
                <option> Jefe de servicio </option>
                <option> Usuario </option>
            </select>
            <br><br>
            
            <label for="ayuntamiento">ayuntamiento</label>
            <select name="ayuntamiento"><option>none</option></select>
            <br><br>
            
        <input type="submit" class="button round blue">
    </body>
</html>
