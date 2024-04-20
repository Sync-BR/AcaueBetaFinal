/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Beans.PostBeans;
import Dao.PostDao;
import static Dao.PostDao.ImagePost;
import static Dao.PostDao.Img;
import static Dao.PostDao.imagePost1;
import static Dao.PostDao.imgs;
import Util.Settings;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    public static List<String> imgName = new ArrayList<>();

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
        boolean Updatetype = false;
        processRequest(request, response);
        PostBeans UpdatePost = new PostBeans();
        PostDao Update = new PostDao();
        String alterar = request.getParameter("Alterar");
        String apagar = request.getParameter("Apagar");
        if (alterar != null) {
            //Verificar se a imagem está nulla
            String updateImg = request.getParameter("UpdateIMG");
            if (updateImg != null && !updateImg.trim().isEmpty()) {
                UpdatePost.setImageMain(updateImg);
            } else {
                UpdatePost.setImageMain(imgs);
            }
            String updateImg1 = request.getParameter("UpdateIMG1");
            if (updateImg1 != null && !updateImg1.isEmpty()) {
                UpdatePost.setImage1(updateImg1);
            } else {
                UpdatePost.setImage1(Img.get(0));
            }

            String updateImg2 = request.getParameter("UpdateIMG2");
            if (updateImg2 != null && !updateImg2.isEmpty()) {
                UpdatePost.setImage2(updateImg2);
            } else {
                UpdatePost.setImage2(Img.get(1));
            }

            String updateImg3 = request.getParameter("UpdateIMG3");
            if (updateImg3 != null && !updateImg3.isEmpty()) {
                UpdatePost.setImage3(updateImg3);
            } else {
                UpdatePost.setImage3(Img.get(2));
            }

            String updateImg4 = request.getParameter("UpdateIMG4");
            if (updateImg4 != null && !updateImg4.isEmpty()) {
                UpdatePost.setImage4(updateImg4);
            } else {
                UpdatePost.setImage4(Img.get(3));
            }
            UpdatePost.setDescription(request.getParameter("UpdateDescricao"));
            UpdatePost.setTitle(request.getParameter("UpdateTitulo"));
            UpdatePost.setDescription1(request.getParameter("UpdateDescricao1"));
            UpdatePost.setDescription2(request.getParameter("UpdateDescricao2"));
            UpdatePost.setDescription3(request.getParameter("UpdateDescricao3"));
            UpdatePost.setDescription4(request.getParameter("UpdateDescricao4"));

            try {
                Update.UpdatePost(UpdatePost);
            } catch (Exception e) {
                e.printStackTrace();
            }

            response.sendRedirect("MenagePost.jsp");
        } else if (apagar != null) {
            UpdatePost.setTitle(request.getParameter("UpdateTitulo"));
            try {
                Update.DeletePost(UpdatePost);
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.sendRedirect("MenagePost.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
