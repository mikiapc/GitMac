<%-- 
    Document   : GestionLineas
    Created on : 28-abr-2013, 19:01:51
    Author     : Miki
--%>
<%@page import="app.entity.Linea"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Gesti&oacute;n l&iacute;neas de comunicaci&oacute;n </title>
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
        
        <table>
            <tr>
                <td>N&uacute;mero</td>
                <td>Operadora</td>
                <td>Asignada</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                 
                <% Collection lista = (Collection)request.getAttribute("lineas");
                for (Iterator iter = lista.iterator(); iter.hasNext();) {
	  		Linea linea = (Linea) iter.next();
                        
                        
                %>
                <tr>
                    <td><%= linea.getIdLinea() %></td>
                                          
                    <td><%= linea.getOperadora() %></td>
                    
                    <% if(linea.getAsignada()){ %>
                    <td><input type="checkbox" name="available" value="asignado" disabled checked></td>
                    <%}else {%>
                    <td><input type="checkbox" name="available" value="asignado" disabled></td>
                  <% } %>
                    
                    <td><a href="BookEdit?do=edit&id=<%= linea.getIdLinea() %> "\>Editar</a></td>
                    <td><a href="BookEdit?do=delete&id=<%= linea.getIdLinea() %>" \>Eliminar</a></td>
                    
               
                    

                </tr>
                    
               <% } %>
                
            </tr>
            
            </table>
               <a href="AltaLinea.jsp">Añadir terminal</a>

    </body>
</html>
