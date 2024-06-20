package Util;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexao {

    private static Connection conexao = null;

    public static Connection getConnection() throws Exception {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           
            return DriverManager.getConnection(Settings.Host+"/"+ Settings.Db+"?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", Settings.User, Settings.Pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexao;
    }

    /**
     *
     * @author SYNC
     * @Funcionalidade Encerra Conexão Funcionalidade para verificar se uma
     * conexão está aberta e encerrar
     */
    private void close(Connection conn, ResultSet rs, Statement stmt) throws Exception {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    // Fechar conexão Statement & Conjunto de resultado do ResultSet

    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        close(conn, stmt, rs);
    }
    //Fechar conexão sem fechar o conjunto do ResultSet

    public static void closeConnection(Connection conn, Statement stmt) throws Exception {
        close(conn, stmt, null);
    }
    //Fechar apenas a conexão

    public static void closeConnection(Connection conn) throws Exception {
        closeConnection(conn, null, null);
    }

}
