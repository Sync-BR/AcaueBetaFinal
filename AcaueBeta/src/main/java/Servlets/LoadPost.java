package Servlets;

import Beans.PostBeans;
import Dao.PostDao;
import static Dao.PostDao.Description;
import static Dao.PostDao.Img;
import static Dao.PostDao.Title;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SYNC
 * @Sobre Está classe tem como funcionalide pesquisar uma postagem por Titulo no Banco de dados
 */
public class LoadPost extends HttpServlet {

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
     * @Sobre Retornar resultado das pesquisar por titulo do post.
     * @ArrayList As variavel que estão sendo removido vai limpar todo array.
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PostDao ReturnPost = new PostDao();
        PostBeans AddPost = new PostBeans();
        AddPost.setTitle(request.getParameter("Titulo"));
        try {

            ReturnPost.UpdatePostS(AddPost);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PostDao.Img.remove(PostDao.Img);
        PostDao.Title.remove(PostDao.Title);
        PostDao.Description.remove(PostDao.Description);
        response.sendRedirect("MenagePost.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
