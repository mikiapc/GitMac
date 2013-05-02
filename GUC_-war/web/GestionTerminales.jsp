<%-- 
    Document   : GestionTerminales
    Created on : 28-abr-2013, 19:12:49
    Author     : Miki
--%>


<%@page import="app.entity.Terminal"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <head>
        <title> Gesti&oacute;n l&iacute;neas de comunicaci&oacute;n </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <meta charset="utf-8">
	
	
	<!-- Stylesheets -->
	<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet'>
	<link rel="stylesheet" href="css/style.css">
    </head>
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
        
        <table border="1">
            <tbody>
                <tr>
                    

                    <td>Marca</td>
                    <td>Modelo</td>
                    <td>Tipo</td>
                    <td>Ubicación</td>
                    <td>Asignado</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    
                </tr>
              
                <% Collection lista = (Collection)request.getAttribute("terminales");
               
                    for (Iterator iter = lista.iterator(); iter.hasNext();) {
	  		Terminal terminal = (Terminal) iter.next();
                        
                        if(!terminal.getBorrado()){
                %>
                <tr>
                    
                    <td><%= terminal.getMarca()  %></td>
                    <td><%= terminal.getModelo()  %></td>
                    
                    <% if(terminal.getTipo()=='m'){ %>
                    <td>M&oacute;vil</td>
                    <%}else {%>
                    <td>Fijo</td>
                    <% } %>
                        
                    <td><%= terminal.getUbicacion()%></td>
                    
                    <% if(terminal.getAsignado()){ %>
                    <td><input type="checkbox" name="available" value="asignado" disabled checked></td>
                    <%}else {%>
                    <td><input type="checkbox" name="available" value="asignado" disabled></td>
                  <% } %>
                    
                    <td><a href="OpcionesTerminalesServlet?do=edit&id=<%= terminal.getIdTerminal() %> "\>Editar</a></td>
                    <td><a href="OpcionesTerminalesServlet?do=delete&id=<%= terminal.getIdTerminal() %>" \>Eliminar</a></td>
                    
               
                    <% } %>

                </tr>
                    
               <% } %>
                    
                

                
            </tbody>
        </table>
        
                	<a href="AltaTerminal.jsp">Añadir terminal</a>
    </body>
</html>
