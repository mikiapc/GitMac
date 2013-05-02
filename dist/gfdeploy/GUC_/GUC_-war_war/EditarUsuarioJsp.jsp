<%-- 
    Document   : EditarUsuarioJsp
    Created on : 23-abr-2013, 19:07:08
    Author     : Naoual Amasri
--%>

<%@page import="app.entity.Usuario"%>
<%@page import="app.entity.Ayuntamiento"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Editar Usuario </title>
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
        <% Usuario usuario = (Usuario)request.getAttribute("usuario");
        %>
        <form method="get" action="EditUsuarioServlet" name="edit">
            <label for="nif">nif</label>
            <input name="nif" type="text" value="<%=usuario.getNif()%>">
            <br><br>
            
            <label for="nombre">nombre</label>
            <input name="nombre" type="text" value="<%=usuario.getNombre()%>">
            <br><br>
            
            <label for="apellidos">apellidos</label>
            <input name ="apellidos" type="text" value="<%=usuario.getApellidos()%>">
            <br><br>
            
            <label for="contrasenya">contrase&ntilde;a</label>
            <input name="contrasenya" type="text" value="<%=usuario.getPassword()%>">
            <br><br>
           
            <label for="email">correo electr&oacute;nico</label>
            <input name="email" type="text"  value="<%=usuario.getCorreoE()%>">
            <br><br>
            
            <label for="direccion">direcci&oacute;n</label>
            <input name="direccion" type="text" value="<%=usuario.getDireccion()%> " >
            <br><br>
            
            <label for="telefono">tel&eacute;fono</label>
            <input name="telefono" type="text" value="<%=usuario.getTelefono()%>">
            <br><br>
                
            <label for="publicable">publicable</label>
            <% if(usuario.getPublicable()){%>
                <input name="publicable" value="si" type="radio" checked="true"> S&iacute;
                <input name="publicable" value="no" type="radio"> No
             <%}else{%>
                <input name="publicable" value="si" type="radio"> S&iacute;
                <input name="publicable" value="no" type="radio" checked="true"> No
             <%}%>
            <br><br>
            
            <label for="rol">rol</label>
            <% if(usuario.getRol().equalsIgnoreCase("administrador")){%>
                <select name="rol">
                    <option selected="true"> Administrador </option>
                    <option> Controlador diputaci&oacute;n</option>
                    <option> Controlador ayuntamiento </option>
                    <option> Jefe de servicio </option>
                    <option> Usuario </option>
                </select>
             <%} else if (usuario.getRol().equalsIgnoreCase("Controlador Diputacion")){ %>
             <select name="rol">
                    <option> Administrador </option>
                    <option selected="true"> Controlador diputaci&oacute;n</option>
                    <option> Controlador ayuntamiento </option>
                    <option> Jefe de servicio </option>
                    <option> Usuario </option>
                </select>
             <% } else if(usuario.getRol().equalsIgnoreCase("Controlador ayuntamiento")){%>
             <select name="rol">
                    <option> Administrador </option>
                    <option> Controlador diputaci&oacute;n</option>
                    <option selected="true"> Controlador ayuntamiento </option>
                    <option> Jefe de servicio </option>
                    <option> Usuario </option>
                </select>
             <%} else if(usuario.getRol().equalsIgnoreCase("Jefe de servicio")){%>
             <select name="rol">
                    <option> Administrador </option>
                    <option> Controlador diputaci&oacute;n</option>
                    <option> Controlador ayuntamiento </option>
                    <option selected="true"> Jefe de servicio </option>
                    <option> Usuario </option>
                </select>
             <%}else{%>
             <select name="rol">
                    <option> Administrador </option>
                    <option> Controlador diputaci&oacute;n</option>
                    <option> Controlador ayuntamiento </option>
                    <option> Jefe de servicio </option>
                    <option selected="true"> Usuario </option>
                </select>
             <%}%>
             
            <br><br>
            
            <label for="ayuntamiento">ayuntamiento</label>
            <select name="ayuntamiento">
            <% 
                List<Ayuntamiento> ayuntamientos = (List<Ayuntamiento>)request.getAttribute("ayuntamientos");
                for(Ayuntamiento a : ayuntamientos){            
                    if(usuario.getAyuntamiento().equals(a)){
                        
            %>
                    <option selected="true"><%=a.getAyuntamientoPK().getLocalidad() %></option>
                    <%}else{%>
                    <option selected="false"><%=a.getAyuntamientoPK().getLocalidad() %></option>
            <%
                    }
                }
            %>
            </select>
            <br><br>
            <%--
            <label for="jefe">jefe de servicio</label>
            <select name="jefe">
                <% List<Usuario> jefes = (List<Usuario>)request.getAttribute("jefes"); 
                    for(Usuario j:jefes){   
                        if(usuario.getJefeservicio().equals(j)){
                %>
                <option selected="true">j.getNombre()+j.getApellidos() </option>
                <%
                    }else{
                %>
                <option selected="flase">j.getNombre()+j.getApellidos() </option>
                <%
                        }
                    }
                %>
            </select>
            --%>
            <input type="submit" class="button round blue">
        </form>
    </body>
</html>
