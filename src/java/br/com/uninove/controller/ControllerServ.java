/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uninove.controller;

import br.com.uninove.dao.UsuarioDao;
import br.com.uninove.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author supercell
 */
public class ControllerServ extends HttpServlet {

    private static String INSERT_OR_EDIT = "/cadastro.jsp";
    private static String LIST_USER = "/listaUsuarios.jsp";
    private UsuarioDao dao;

    public ControllerServ() {
        super();
        dao = new UsuarioDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int userId = Integer.parseInt(request.getParameter("idUsuario"));
            dao.delete(userId);
            forward = LIST_USER;
            request.setAttribute("users", dao.listaTodos());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int userId = Integer.parseInt(request.getParameter("userId"));
            Usuario user = dao.getUsuarioId(userId);
            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;
            request.setAttribute("users", dao.listaTodos());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario user = new Usuario();
        user.setNome(request.getParameter("nome"));
        user.setEmail(request.getParameter("email"));
        user.setSenha(request.getParameter("senha"));
        user.setFone(request.getParameter("fone"));
        String userid = request.getParameter("idUsuario");
        if(userid == null || userid.isEmpty())
        {
            dao.gravar(user);
        }
        else
        {
            user.setIdUsuario(Integer.parseInt(userid));
            dao.update(user);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("users", dao.listaTodos());
        view.forward(request, response);
    }
}
