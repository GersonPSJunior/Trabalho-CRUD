<%-- 
    Document   : login
    Created on : 15/09/2017, 21:35:43
    Author     : supercell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Usuario</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="ServletLogin" method="post">
            <label>E-mail:</label>
            <input type="text" name="txtEmail"/><br><br>
            <label>Senha:</label>
            <input type="password" name="txtSenha"/><br><br>
            <input type="submit" value="Entrar">
        </form>
    </body>
</html>
