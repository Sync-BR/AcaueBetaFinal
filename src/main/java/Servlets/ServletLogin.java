package Servlets;

import Beans.LoginBeans;
import Dao.LoginDao;
import static Dao.LoginDao.Conectado;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SYNC
 * @Sobre Está classe tem como funcionalidade iniciar o login
 */
public class ServletLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LoginBeans AddLogin = new LoginBeans();
        LoginDao Autenticar = new LoginDao();
        AddLogin.setUsuario(request.getParameter("UserField"));
        AddLogin.setPassword(request.getParameter("FieldPassword"));
        try {
            Autenticar.Authenticate(AddLogin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(LoginDao.Conectado){
            response.sendRedirect("home.jsp");
        } else {
            LoginDao.Status = " Credenciais de acesso inválidas.";
            response.sendRedirect("index.jsp");        
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     *
     * @author SYNC
     * @doPost Pegar todas informações prenchido no form e enviar a solicitalçao
     * pra efetuar o login
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
