/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uninove.controller;

import br.com.uninove.dao.UsuarioDao;
import br.com.uninove.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author supercell
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Usuario usuario = new Usuario();
        UsuarioDao dao = new UsuarioDao();
        usuario = dao.autenticar(request.getParameter("txtEmail"), request.getParameter("txtSenha"));

        if (usuario != null) {
            request.getSession().setAttribute("_usuario_", usuario);
            response.sendRedirect("cadastro.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
