package Servlets;

import Beans.LoginBeans;
import Dao.LoginDao;
import static Dao.LoginDao.PasswordChangeSucess;
import static Dao.LoginDao.newpassword;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SYNC
 * @Sobre Está classe tem como funcionalidade alterar a senha Administrador.
 */
public class ServletChangePassword extends HttpServlet {

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
     * @Sobre Pegar todas informações da pagina e enviar a solicitação para alterar a senha.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        boolean CheckBox = false;
        boolean PasswordOK = false;
        LoginBeans AddLogin = new LoginBeans();
        LoginDao ChangePassword = new LoginDao();

        String ChangeUsuario = request.getParameter("ChangeUser");
        if ("true".equals(ChangeUsuario)) {
            CheckBox = true;
        }
        LoginDao.OldPassword = request.getParameter("OldPassword");
        LoginDao.newpassword = request.getParameter("NewPassword");
        String RepeatPassword = request.getParameter("Repeatpassword");
        if (LoginDao.newpassword.equals(RepeatPassword)) {
            PasswordOK = true;
            AddLogin.setPassword(request.getParameter("NewPassword"));
            try {
                ChangePassword.ReceiveUserDate();
                if (LoginDao.EqualPassword) {
                    ChangePassword.ChangePassword(AddLogin);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            PasswordOK = false;
        }
        if (CheckBox) {
            AddLogin.setUsuario(request.getParameter("UserName"));

            try {
                ChangePassword.ChangeUser(AddLogin);

                if (ChangePassword.ChangeUsuario) {
                    LoginDao.Status = "Usuario alterado com sucesso.";
                } else {
                    LoginDao.Status = "Erro desconhecido.";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("teste");
        }

        //Retornar Resposta
  
        if(PasswordChangeSucess){
            if(LoginDao.ChangeUsuario){
                LoginDao.Status = " Login e Senha alterada com sucesso.";
            } else{
                LoginDao.Status = " Senha alterada com sucesso.";
            }
            
        }  else if(!PasswordChangeSucess) {
            if(!LoginDao.EqualPassword){
                LoginDao.Status = "Senha atual não corresponde com a senha cadastrada.";
            } 
            if(!PasswordOK) {
                LoginDao.Status = "A Senha prenchida não corresponde com a senha solicitada";
            }
        }

        System.out.println("Password> " +PasswordOK);
        
        response.sendRedirect("Account.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
