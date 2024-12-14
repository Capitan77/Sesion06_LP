package com.cibertec.servlets;

import com.cibertec.dao.UsuarioDao;
import com.cibertec.dao.impl.UsuarioDaoImpl;
import com.cibertec.models.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="ListadoUsuariosServlets", urlPatterns ="/ListadoUsuariosServlets" )
public class ListadoUsuariosServlets extends HttpServlet {

    UsuarioDao usuarioDao = new UsuarioDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            List<Usuario> usuarios = usuarioDao.obtenerUsuarios();
            req.setAttribute("usuarios", usuarios);
            req.getRequestDispatcher("usuarios.jsp").forward(req, resp);

        }catch (SQLException error) {
            throw  new ServletException("Error al listar los usuarios", error);
        }

    }
}
