<%-- 
    Document   : ConsultarUsuario
    Created on : 23-abr-2013, 19:30:55
    Author     : Naoual Amasri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Consultar Usuario </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
	
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
        <br><br>
        <%
            String nombre = (String)request.getAttribute("nombre");
            String apellidos = (String)request.getAttribute("apellidos");
            String nif = (String)request.getAttribute("nif");
            String direccion = (String)request.getAttribute("direccion");
            String email = (String)request.getAttribute("email");
            String telefono = (String)request.getAttribute("telefono");
            String publicable = (String)request.getAttribute("publicable");
            String rol = (String)request.getAttribute("rol");
            String ayuntamiento = (String)request.getAttribute("ayuntamiento");
        %>
            Nombre <%=nombre%>
            <br><br>
            
            Apellidos <%=apellidos%>
            <br><br>
            
            Dni <%=nif%>
            <br><br>
           
            Correo electr&oacute;nico <%=email%>
            <br><br>
            
            Direcci&oacute;n <%=direccion%>
            <br><br>
            
            Tel&eacute;fono de contacto <%=telefono%>
            <br><br>
                
            Publicable <%=publicable%>
            <br><br>
            
            Rol <%=rol%>
            <br><br>
            
            Ayuntamiento <%=ayuntamiento%>
            <br><br>
            
        <a href="EditarUsuarioJsp.jsp"><button>Editar</button></a>
    </body>
</html>
