<%-- 
    Document   : ConsultarAsignacionLineaUsuario
    Created on : 28-abr-2013, 17:50:58
    Author     : Nacho
--%>

<%@page import="app.entity.Linea"%>
<%@page import="app.entity.Usuario"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <title> Consultar asignación de línea a usuario </title>
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
        
        <div>
            <label for="buscar" > <font color="#2069b4"><B> BUSCAR USUARIO </B></font> </label>
            <br><br>
            <fieldset>
                <label> Criterio de b&uacute;squeda </label>
                <select name="busqueda" class="round"> <option>DNI</option> 
                <option>N&uacute;mero</option> 
                </select>
            <input name="campo" type="text" class="round" autofocus>
            <button>Buscar</button>
            </fieldset>
            
            <br><br>
      </div>
        <br><br><br> 
      <div>
          
                <br><br>
      </div>
        <br><br><br> 
      <div>
          <label for="listado"><font color="#2069b4"> <B> LISTADO DE USUARIOS </B> </font></label>
          <br>
  	<table border="1">
  		<tbody>
  		<tr>
                        <td>DNI</td>
			<td>Nombre</td>
                        <td>Linea</td>
                                               
		</tr>
                
               <% Collection lista = (Collection)request.getAttribute("usuarios");
                    for (Iterator iter = lista.iterator(); iter.hasNext();) {
	  		Usuario user = (Usuario) iter.next();
                    %>
                    <tr>
                          
                        <td> <%= user.getNif()%></td>
                        <td> <%= user.getNombre()%></td>
                        <td> <%= user.getTelefono()%></td>
                        <td> <a href="ConsultarUsuario.jsp">Consultar</a> </td>
                        <td> <a href="EditarUsuarioJsp.jsp">Editar</a> </td>
                        <td> <a href="EditarUsuarioJsp.jsp">Eliminar</a> </td>
		   </tr>
                <% } %>
	
  		</tbody>
  	</table>
  	<br>
              <a href="ConsultarUsuario.jsp">Consultar</a> 
        </div>
  </body>
        
   
</html>











