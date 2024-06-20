package Servlets;

import Beans.EmailBeans;
import Dao.EmailDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SYNC
 * @Sobre Está classe tem como funcionalide buscar email pelo banco de dados
 */
public class ServletsSearchEmail extends HttpServlet {

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
     * @doPost Codigo para efetuar uma busca de email no banco de dados.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        EmailBeans AddMail = new EmailBeans();
        EmailDao SearchEmail = new EmailDao();

        try {
            SearchEmail.SearchEmail(AddMail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("MenageEmails.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
