<%-- 
    Document   : login
    Created on : 29-abr-2013, 17:14:19
    Author     : O--maro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8">
	<title>Simplelogin - Login to Diputación</title>
	
	<!-- Stylesheets -->
	<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet'>
	<link rel="stylesheet" href="css/style.css">

	<!-- Optimize for mobile devices -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>  
</head>
<body>

	<!-- TOP BAR -->
	<div id="top-bar">
		
		<div class="page-full-width strong em">
                    <a href="#" id="company-branding" class="fl"><img src="images/logo_DIPUTACION.jpg" alt="Blue Hosting" /></a>
                    <div id="cabz">
                    <h1>Diputación provincial de Málaga
                        <br>Área de modernización local
                        <br>Servicio de tecnologías de la información</h1>
                    </div>
                    
                    <%--<a href="#" class="round button dark ic-left-arrow image-left ">Return to website</a>--%>
                        

		</div> <!-- end full-width -->	
	
	</div> <!-- end top-bar -->
	
	
	
	<!-- HEADER -->
	<div id="header">
		
		<div class="page-full-width cf">
	
			<div id="login-intro" class="fl">
			
				<h1>Servicio de Identidad</h1>
				<h5>Entrar usando tu dni y contraseña</h5>
			
			</div> <!-- login-intro -->
			
			<!-- Change this image to your own company's logo -->
			<!-- The logo will automatically be resized to 39px height. -->
			
		</div> <!-- end full-width -->	
                <div class ="fr">
                    <a href="#">Directorio telefónico</a>
                </div>

	</div> <!-- end header -->
	
	
	
	<!-- MAIN CONTENT -->
	<div id="content">
	
		<form action="Servlet_Login" method="POST" id="login-form">
		
			<fieldset>

				<p>
					<label for="login-username">usuario</label>
					<input type="text" id="login-username" class="round full-width-input" autofocus name="dni" />
				</p>

				<p>
					<label for="login-password">contraseña</label>
					<input type="password" id="login-password" class="round full-width-input" name="contrasenya" />
				</p>
				
                                <p>
				<input type="submit" class="button round blue image-right ic-right-arrow" value="LOG IN" name="LOG IN">  
                                </p>

			</fieldset>

			<br/>

		</form>
		
	</div> <!-- end content -->
	
	
	
	<!-- FOOTER -->
	<div id="footer">

		<p><strong>Login</strong> theme by Omar Dardak </p>
	
	</div> <!-- end footer -->

</body>
</html>
