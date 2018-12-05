<%-- 
    Documento   : cadastro
    Autor     : Gerson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
    </head>
    <body>
        <h1>Cadastro de Usuário:</h1>
        <form method="POST" action='ControllerServ' name="frmAddUser">
            <label>Id Usuario:</label>
            <input type="text" readonly="readonly" name="idUsuario"
                   value="<c:out value="${user.idUsuario}" />" /> <br/><br/> 
            <label>Nome:</label>
            <input type="text" name="nome"
                   value="<c:out value="${user.nome}" />" /> <br/><br/>
            <label>E-mail:</label>
            <input type="text" name="email"
                   value="<c:out value="${user.email}" />" /> <br/><br/> 
            <label>Senha:</label>
            <input type="password" name="senha"
                   value="<c:out value="${user.senha}" />" /> <br/><br/>
            <label>Telefone:</label>
            <input type="text" name="fone"
                   value="<c:out value="${user.fone}" />" /> <br/><br/> 

            <input type="submit" value="Salvar" />
        </form>
    </body>
</html>
