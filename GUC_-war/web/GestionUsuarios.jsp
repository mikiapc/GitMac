


<%@page import="app.entity.Usuario"%>
<%@page import="java.util.List"%>
<%@page language="java"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
        <base href="<%=basePath%>">
	
	<!-- Stylesheets -->
	<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet'>
	<link rel="stylesheet" href="css/style.css">

	<!-- Optimize for mobile devices -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>  
    <title> Lista de usuarios </title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
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
            <form method="get" action="BuscarUsuario" name="datos">
                <label> Criterio de b&uacute;squeda </label>
                <select name="criterio" class="round"> <option>NIF</option> 
                <option>Nombre</option> <option>Apellidos</option> <option>Rol</option>
                </select>
                <input name="campo" type="text" class="round" >
                <input type="submit" value="buscar" name="buscar">
            </form>
            
            <br><br>
      </div>
        <br><br><br> 
      <div>
          <label for="listado"><font color="#2069b4"> <B> LISTADO DE USUARIOS </B> </font></label>
          <br>
  	<table border="1">
  		<tbody>
  		<tr>
                        <td>NIF</td>
			<td>Nombre</td>
			<td>Apellidos</td>
                        <td>Rol</td>
                        <td>Correo electr&oacute;nico</td>
                        <td>Direccion</td>
                        <td>Publicable</td>
                        <td>Ayuntamiento</td>
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
                        <td> <%= user.getDireccion() %> </td>
                        <%
			if(user.getPublicable()) {
                        %>
                         <td><input type="checkbox" name="publicable" value="true" disabled checked></td>
                        <%
                        } else {
                        %>
                        <td><input type="checkbox" name="publicable" value="true" disabled></td>
                        <%              
                        }
                        %>
                        <td> <%= user.getAyuntamiento().getAyuntamientoPK().getLocalidad()%> </td>
                        <td> <a href="OpcionesUsuarioServlet?do=edit&nif=<%=user.getNif() %>">Editar</a> </td>
                        <td> <a href="OpcionesUsuarioServlet?do=delete&nif=<%=user.getNif()%>">Eliminar</a> </td>
		</tr>
                <%      }
                    }%>
	
  		</tbody>
  	</table>
  	<br>
        <a href="CargarAltaUsuarioServlet">A&ntilde;adir nuevo usuario</a>
        
        </div>
  </body>
</html>
