<%-- 
    Document   : EditarTerminal
    Created on : 02-may-2013, 16:32:57
    Author     : Miki
--%>

<%@page import="app.entity.Terminal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Terminal</title>
    </head>
    <body>
        
        <form method="get" action="EditarTerminalServlet" name="datos">
            <% Terminal terminal = (Terminal) request.getAttribute("terminal");
            %>
            
            <label for="marca">MARCA: </label>
            <input name="marca" type="text" value ="<%= terminal.getMarca() %>">
            <br><br> 
            
            <label for="modelo">MODELO: </label>
            <input name="modelo" type="text" value ="<%= terminal.getModelo()  %>">
            <br><br>
            
            <label for="modelo">TIPO: </label>
            <% if(terminal.getTipo()=='m'){%>
            <select name="tipo">
                <option value="f">Fijo</option>
                <option value="m" selected>M&oacute;vil</option>
            </select>
            <br><br>
            <% }else{%>
                <select name="tipo">
                <option value="f" selected>Fijo</option>
                <option value="m">M&oacute;vil</option>
            </select>
            <br><br>
            
            <label for="ubicación">Ubicaci&oacute;n: </label>
            <input name="ubicacion" type="text"value ="<%= terminal.getUbicacion() %>">
            <br><br>
            <%}%>
                        
            

<td><a href="EditarTerminalServlet?id=<%= terminal.getIdTerminal() %> "\>Editar</a></td>
        
    </body>
</html>
