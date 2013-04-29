<%-- 
    Document   : AdminPrincipal
    Created on : 26-abr-2013, 13:25:16
    Author     : O--maro
--%>

<%@page import="app.entity.Usuario"%>
<%@page import="java.util.Collection"%>

<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
	<meta charset="utf-8">
	<title>SimpleAdmin - AdminPrincipal</title>
	
	<!-- Stylesheets -->
	<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet'>
	<link rel="stylesheet" href="css/style.css">
	
	<!-- Optimize for mobile devices -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	
	<!-- jQuery & JS files -->
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="js/script.js"></script>  
</head>
<body>

	<!-- TOP BAR -->
	<div id="top-bar">
		
		<div class="page-full-width strong em">
                        <a href="#" id="company-branding" class="fl"><img src="images/logo_DIPUTACION.jpg" alt="Blue Hosting" /></a>
                        <ul id="nav" class="fr">
	
				
				<li class="v-sep"><a href="#" class="round button dark menu-user image-left">Logged in as <strong>admin</strong></a>
					<ul>
						<li><a href="#">My Profile</a></li>
						<li><a href="#">Ver Factura</a></li>
					</ul> 
				</li>
			
                                <li><a href="#" class="round button dark menu-email-special image-left">3 new messages</a></li>
				<li><a href="login.jsp" class="round button dark menu-logoff image-left">Log out</a></li>
				
			</ul> <!-- end nav -->
                        <div id="cabz">
                            <h1>Diputación provincial de Málaga
                                <br>Área de modernización local
                                <br>Servicio de tecnologías de la información
                            </h1>
                        

			
                        </div>

		</div> <!-- end full-width -->	
	
	</div> <!-- end top-bar -->
	
	<!-- MAIN CONTENT -->
	<div id="content">
		
		<div class="page-full-width cf">

			<div class="side-menu fl">
				
				<h3>Funcionalidades</h3>
				<ul>
					<li><a href="JefeServicioPrincipal.jsp">Side menu link</a></li>
					<li><a href="#">Another link</a></li>
					<li><a href="#">A third link</a></li>
					<li><a href="#">Fourth link</a></li>
				</ul>
				
			</div> <!-- end side-menu -->
                        <div class="side-content fr">
			
				<div class="content-module">
				
					<div class="content-module-heading cf">
					
						<h3 class="fl">Listado de usuarios</h3>
						<div class="fr">
            <label for="buscar" > <font color="#2069b4"><B> BUSCAR USUARIO </B></font> </label>
            <br><br>
            <form method="get" action="BuscarUsuario" name="datos">
                <label> Criterio de b&uacute;squeda </label>
                <select name="criterio" class="round"> <option>NIF</option> 
                <option>Nombre</option> <option>Apellidos</option> <option>Rol</option>
                </select>
                <input name="campo" type="text" >
                <input type="submit">
            </form>
            
            <br><br>
      </div>
					
					</div> <!-- end content-module-heading -->
					
					
					<div class="content-module-main">
	<label for="listado"><font color="#2069b4"> <B> LISTADO DE USUARIOS </B> </font></label>
          <br>				
	<table border="1">
  		<tbody>
  		<tr>
                        <td>DNI</td>
			<td>Nombre</td>
			<td>Apellidos</td>
                        <td>Rol</td>
                        <td>Correo electr&oacute;nico</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
		</tr>
                
                <% Collection lista = (Collection)request.getAttribute("usuarios");
                    if(lista.isEmpty()){
                 %>
                 <tr>
                        <td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                 </tr>
                        
                 <%
                    }else{
                        for (Iterator iter = lista.iterator(); iter.hasNext();) {
                            Usuario user = (Usuario) iter.next();
                %>
                    <tr>
                        <td><%=user.getNif() %> </td>
			<td> <%= user.getNombre() %> </td>
			<td> <%= user.getApellidos() %> </td>
                        <td> <%= user.getRol() %> </td>
                        <td> <%= user.getCorreoE() %> </td>
                        <td> <a href="ConsultarUsuario.jsp">Consultar</a> </td>
                        <td> <a href="EditarUsuarioJsp.jsp">Editar</a> </td>
                        <td> <a href="EditarUsuarioJsp.jsp">Eliminar</a> </td>
		</tr>
                <%      }
                    }%>
	
  		</tbody>
  	</table>
					
					</div> <!-- end content-module-main -->
				
				</div> <!-- end content-module -->
				
				<div class="content-module">
				

					
				</div> <!-- end content-module -->

		
			</div> <!-- end side-content -->

		
		</div> <!-- end full-width -->
			
	</div> <!-- end content -->
	
	
	
	<!-- FOOTER -->
	<div id="footer">

		<p><strong>Admin Principal</strong> theme by Omar Dardak </p>
	
	</div> <!-- end footer -->

</body>
</html>
