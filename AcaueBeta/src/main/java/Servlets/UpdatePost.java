/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Beans.PostBeans;
import Dao.PostDao;
import static Dao.PostDao.Status;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SYNC
 * @Sobre Está classe tem como funcionalidade
 */
public class UpdatePost extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     *
     * @author SYNC
     * @doPost Este codigo tem como funcionalide pegar as informações no site e
     * efetuar a atualização
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PostBeans UpdatePost = new PostBeans();
        PostDao Update = new PostDao();
        String alterar = request.getParameter("Alterar");
        String apagar = request.getParameter("Apagar");
        if (alterar != null) {
            UpdatePost.setImageName(request.getParameter("UpdateIMG"));
            UpdatePost.setDescription(request.getParameter("UpdateDescricao"));
            UpdatePost.setTitle(request.getParameter("UpdateTitulo"));
            try {
                Update.UpdatePost(UpdatePost);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (apagar != null) {
            UpdatePost.setTitle(request.getParameter("UpdateTitulo"));
            try {
                Update.DeletePost(UpdatePost);
                Update.Status = "Apagado com sucesso";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("MenagePost.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
