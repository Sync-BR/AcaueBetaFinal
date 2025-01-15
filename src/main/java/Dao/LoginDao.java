package Dao;

import Beans.LoginBeans;
import Util.Conexao;
import Util.Settings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author SYNC
 * @Sobre Está class tem como funcionalidade todas operações relacionado ao
 * login
 */
public class LoginDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public static String Status = "";
    public static boolean Conectado;

    public LoginDao() {
        try {
            connection = Conexao.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco de dados");
        }
    }


    /**
     * Efetuar autenticação do usuário!.
     * @return Retornar os dados do usuário se estiver correto
     * @author SYNC
     * @since 2025-01-15
     */
    public LoginBeans Authenticate(LoginBeans login) throws Exception {
        System.out.println("Task - > Authenticate executada com sucesso!");
        if (connection.isClosed()) {
            connection = Conexao.getConnection();
        }
        Conectado = false;
        Status = null;
        try {
            String sql = "SELECT * FROM " + Settings.Db + ".usuarios WHERE Login = ? AND Password = ?";
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login.getUsuario());
            preparedStatement.setString(2, login.getPassword());
            resultSet = preparedStatement.executeQuery();
            String User = null;
            String Pass = null;
            if (resultSet.next()) {
                User = resultSet.getString("Login");
                Pass = resultSet.getString("Password");
            }
            if (login.getUsuario().equals(User) && login.getPassword().equals(Pass)) {
                Conectado = true;
                return login;
            }
        } catch (SQLException e) {
            System.out.println("Task - > Authenticate: Erro ao executar SQL: " + e.getMessage());
        } finally {
            Conexao.closeConnection(connection, preparedStatement, resultSet);
            System.out.println("Task - > Authenticate: finalizado com sucesso!");

        }
        return null;
    }

    /**
     * @author SYNC
     * @ReceiveUserDate Tem como funcionalidade receber o login e a senha do
     * usuario
     */
    private String CurrentUser;
    private String CurrentPassword;
    public static String OldPassword;
    public static boolean EqualPassword;

    public void ReceiveUserDate() throws Exception {
        EqualPassword = false;
        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        LoginBeans AddLogin = new LoginBeans();
        try {
            String sql = "select * from " + Settings.Db + ".usuarios";
            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                CurrentUser = rs.getString("Login");
                CurrentPassword = rs.getString("Password");
            }
            //Verificar se a senha Antiga esta Correta
            if (OldPassword.equals(CurrentPassword)) {
                EqualPassword = true;
            } else {
                EqualPassword = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.closeConnection(conexao, stm, rs);
        }
    }

    /**
     * @author SYNC
     * @ChangePassword Tem como funcionalidade atualizar a senha
     */
    public static boolean PasswordChangeSucess;
    public static String newpassword;

    public void ChangePassword(LoginBeans login) throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        PasswordChangeSucess = false;
        Status = "";
        int sucess = 0;
        try {
            String sql = "Update " + Settings.Db + ".usuarios set Password = ? WHERE Login = ?";
            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            stm.setString(1, login.getPassword());
            stm.setString(2, CurrentUser);
            sucess = stm.executeUpdate();
            if (sucess > 0) {
                PasswordChangeSucess = true;
            } else {
                PasswordChangeSucess = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.closeConnection(conexao, stm);
        }
    }

    /**
     * @author SYNC
     * @ChangeUser Tem como funcionalidade atualizar o login
     */
    public static boolean ChangeUsuario;

    public void ChangeUser(LoginBeans AddLogin) throws Exception {
        ChangeUsuario = false;
        Connection conexao = null;
        PreparedStatement stm = null;
        int StatusChange;
        try {
            String sql = "Update " + Settings.Db + ".usuarios set Login = ? WHERE Login = ?";
            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            stm.setString(1, AddLogin.getUsuario());
            stm.setString(2, CurrentUser);
            StatusChange = stm.executeUpdate();
            if (StatusChange > 0) {
                ChangeUsuario = true;
            } else {
                ChangeUsuario = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.closeConnection(conexao, stm);
        }
    }

}
