<%-- 
    Documento   : listaUsuarios
    Autor     : Gerson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Usuarios</title>
    </head>
    <body>
        <table border=1>
        <thead>
            <tr>
                <th>Id Usuario</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Senha</th>
                <th>Telefone</th>
                <th colspan=2>Ação</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.idUsuario}" /></td>
                    <td><c:out value="${user.nome}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.senha}" /></td>
                    <td><c:out value="${user.fone}" /></td>
                    <td><a href="ControllerServ?action=edit&userId=<c:out value="${user.idUsuario}"/>">Update</a></td>
                    <td><a href="ControllerServ?action=delete&idUsuario=<c:out value="${user.idUsuario}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="ControllerServ?action=insert">Adicionar Novo Usuario</a></p>
    </body>
</html>
