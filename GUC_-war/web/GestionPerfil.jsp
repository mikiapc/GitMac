<%@page import="app.entity.Perfilgasto"%>
<%@page import="java.util.List"%>
<%@page language="java"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

	
	<!-- Stylesheets -->
	<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet'>
	<link rel="stylesheet" href="css/style.css">

	<!-- Optimize for mobile devices -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>  
    <title> Lista de Perfiles </title>
    
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
            <label for="buscar" > <font color="#2069b4"><B> BUSCAR PERFIL GASTO </B></font> </label>
            <br><br>
            <from method="get" action="BuscarPerfil" name="datos">
                <label> Criterio de b&uacute;squeda </label>
                <select name="criterio" class="round"> <option>Perfil</option> 
                <option>Gasto</option>
                </select>
                <input name="campo" type="text" class="round" >
                <input type="submit">
            </form>
            
            <br><br>
      </div>
        <br><br><br> 
      <div>
          <label for="listado"><font color="#2069b4"> <B> LISTADO DE PERFILES </B> </font></label>
          <br>
  	<table border="1">
  		<tbody>
  		<tr>
                        <td>Perfil</td>
			<td>Gasto</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>

                </tr>
                
              <% Collection lista = (Collection)request.getAttribute("perfiles");
                if((String)request.getParameter("perfiles")!=null){
                    
                     if(lista.isEmpty()){
                 %>
                 <tr>
                        <td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>

                        
                 </tr>
                        
                 <%
                    }else{
                        for (Iterator iter = lista.iterator(); iter.hasNext();) {
                            Perfilgasto pg = (Perfilgasto) iter.next();
                %>
                    <tr>
                        <td><%=pg.getIdPerfilGasto() %> </td>
			<td> <%= pg.getTipoSaldo() %> </td>
                        <td> <a href="EditarperfilServlet?do=edit&perfil=<%=pg.getIdPerfilGasto()%>">Editar</a> </td>
                        <td> <a href="EliminarperfilServlet?do=edit&perfil=<%=pg.getIdPerfilGasto()%>">Eliminar</a> </td>
		</tr>
                <%      }}
                    }%>
	
  		</tbody>
  	</table>
  	<br>
        <a href="AltaPerfilGasto.jsp">A&ntilde;adir nuevo Perfil</a>
        
        </div>
  </body>
</html>
